/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.DAO;


import br.com.estoque.objeto.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public Produto consultarPorId(Long id) {

        return em.find(Produto.class, id);

    }

    public List<Produto> consultarTodos() {

        Query query = em.createNamedQuery("Produto.consultarTodos");
        return query.getResultList();
    }

    public List<Produto> consultarProdutoPorNota(long nnota) {

        Query q = em.createNativeQuery("SELECT * FROM Produto p WHERE p.ID_NOTA=(SELECT n.id FROM NotaProduto n WHERE n.NNOTA=?)",Produto.class);

        q.setParameter("1", nnota);
        return (List<Produto>)q.getResultList();

    }

    public void salvar(Produto produto) {

        em.persist(produto);
    }

    public void alterar(Produto produto) {

        em.merge(produto);
    }

    public void remover(Produto produto) {
    Produto produto2=em.merge(produto);
        em.remove(produto2);
    }
}
