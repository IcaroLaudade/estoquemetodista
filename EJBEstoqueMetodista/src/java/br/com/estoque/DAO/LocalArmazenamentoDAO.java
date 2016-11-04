/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.DAO;

import br.com.estoque.objeto.LocalArmazenamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LocalArmazenamentoDAO {

    private EntityManager em;

    public LocalArmazenamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(LocalArmazenamento local) {
        em.persist(local);
    }

    public void alterar(LocalArmazenamento local) {
        em.merge(local);
    }

    public void remover(LocalArmazenamento local) {
        em.remove(local);
    }

    public LocalArmazenamento consultarPorId(long id) {
         
        return em.find(LocalArmazenamento.class, id);
    }

    public List<LocalArmazenamento> consultarTodos() {

        Query query = em.createNamedQuery("LocalArmazenamento.consultarTodos");
        return query.getResultList();
    }
      public LocalArmazenamento consultarLocalProduto(long codigo) {
          try{
        Query q = em.createNativeQuery("SELECT * FROM LocalArmazenamento WHERE ID=(SELECT ID_LOCAL FROM Produto WHERE CODIGO=?)",LocalArmazenamento.class);

        q.setParameter("1", codigo);
        
        return(LocalArmazenamento) q.getSingleResult();
          }
          catch(Exception e){
          return new LocalArmazenamento();
          }
    }

}
