/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.EJBEstoque;

import br.com.estoque.objeto.LocalArmazenamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author icaro
 */
@Local
public interface ILocalArmazenamentoBean {
    public void salvar(LocalArmazenamento local);

    public void remover(LocalArmazenamento local);
    public void alterar(LocalArmazenamento local);

    public LocalArmazenamento consultarPorId(Long id);

    public List<LocalArmazenamento> consultarTodos();
    public LocalArmazenamento consultarLocalProduto(long codigo);
}
