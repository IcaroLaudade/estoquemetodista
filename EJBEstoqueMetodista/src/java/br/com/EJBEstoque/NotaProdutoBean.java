/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.EJBEstoque;

import br.com.estoque.DAO.NotaProdutoDAO;
import br.com.estoque.objeto.NotaProduto;
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
public class NotaProdutoBean implements INotaProdutoBean {

    @PersistenceContext(unitName = "EstoquePU")
    private EntityManager em;

    @Override
    public void salvar(NotaProduto nota) {

        NotaProdutoDAO dao = new NotaProdutoDAO(em);
        dao.salvar(nota);
    }

    @Override
    public void remover(NotaProduto nota) {

        NotaProdutoDAO dao = new NotaProdutoDAO(em);
        dao.remover(nota);
    }

    @Override
    public void alterar(NotaProduto nota) {

        NotaProdutoDAO dao = new NotaProdutoDAO(em);
        dao.alterar(nota);
    }

    @Override
    public NotaProduto consultarPorNnota(Long nnota) {
        NotaProdutoDAO dao = new NotaProdutoDAO(em);
        return dao.consultarPorNnota(nnota);
    }
   

    @Override
    public List<NotaProduto> consultarTodos() {
        NotaProdutoDAO dao = new NotaProdutoDAO(em);

        return dao.consultarTodos();
    }
}
