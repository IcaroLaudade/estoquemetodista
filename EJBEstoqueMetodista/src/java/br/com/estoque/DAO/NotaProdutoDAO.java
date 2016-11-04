/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.DAO;


import br.com.estoque.objeto.NotaProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class NotaProdutoDAO {
 
    private EntityManager em;
    
    public NotaProduto consultarPorNnota(Long nNota) {
    Query query=em.createNativeQuery("SELECT n.id FROM NotaProduto n WHERE n.NNOTA=?", NotaProduto.class);
        query.setParameter("1",nNota );
    return (NotaProduto) query.getSingleResult();

    }
    public NotaProdutoDAO(EntityManager em)
    {
    this.em=em;
    }
    

    public List<NotaProduto> consultarTodos() {
       
        Query query = em.createNamedQuery("NotaProduto.consultarTodos");
        return query.getResultList();
    }

    public void salvar(NotaProduto nota) {
    
        em.persist(nota);
    }

    public void alterar(NotaProduto nota) {
     
        em.merge(nota);
    }

    public void remover(NotaProduto nota) {
        NotaProduto nota2=em.merge(nota);
        em.remove(nota2);
    }
}
