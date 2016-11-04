/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.EJBEstoque;

import br.com.estoque.DAO.ProdutoDAO;
import br.com.estoque.objeto.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author icaro
 */
@Stateless
public class ProdutoBean implements IProdutoBean {

    @PersistenceContext(unitName = "EstoquePU")
    private EntityManager em;

    @Override
    public void salvar(Produto produto) {

        ProdutoDAO dao = new ProdutoDAO(em);
        dao.salvar(produto);
    }
      @Override
    public List<Produto> consultarProdutoPorNota(long id) {
       ProdutoDAO dao = new ProdutoDAO(em);
        
        return dao.consultarProdutoPorNota(id);
    }

    @Override
    public void remover(Produto produto) {

        ProdutoDAO dao = new ProdutoDAO(em);
        dao.remover(produto);
    }

    @Override
    public void alterar(Produto produto) {

        ProdutoDAO dao = new ProdutoDAO(em);
        dao.alterar(produto);
    }

    @Override
    public Produto consultarPorId(Long codigo) {
        ProdutoDAO dao = new ProdutoDAO(em);
        return dao.consultarPorId(codigo);
    }

    @Override
    public List<Produto> consultarTodos() {
        ProdutoDAO dao = new ProdutoDAO(em);

        return dao.consultarTodos();
    }
}
