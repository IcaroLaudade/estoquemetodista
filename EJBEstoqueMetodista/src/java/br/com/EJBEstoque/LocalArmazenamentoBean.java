/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.EJBEstoque;

import br.com.estoque.DAO.LocalArmazenamentoDAO;
import br.com.estoque.objeto.LocalArmazenamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author icaro
 */
@Stateless
public class LocalArmazenamentoBean implements ILocalArmazenamentoBean {

    @PersistenceContext(unitName = "EstoquePU")
    private EntityManager em;

    @Override
    public void salvar(LocalArmazenamento local) {

        LocalArmazenamentoDAO dao = new LocalArmazenamentoDAO(em);
        dao.salvar(local);
    }

    @Override
    public void remover(LocalArmazenamento local) {

        LocalArmazenamentoDAO dao = new LocalArmazenamentoDAO(em);
        dao.remover(local);
    }

    @Override
    public void alterar(LocalArmazenamento local) {

        LocalArmazenamentoDAO dao = new LocalArmazenamentoDAO(em);
        dao.alterar(local);
    }

    @Override
    public LocalArmazenamento consultarPorId(Long id) {
        LocalArmazenamentoDAO dao = new LocalArmazenamentoDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public List<LocalArmazenamento> consultarTodos() {
        LocalArmazenamentoDAO dao = new LocalArmazenamentoDAO(em);

        return dao.consultarTodos();
    }
    @Override
    public LocalArmazenamento consultarLocalProduto(long codigo)
    {
    LocalArmazenamentoDAO dao = new LocalArmazenamentoDAO(em);
    return dao.consultarLocalProduto(codigo);
    
    }
}
