/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.EJBEstoque;

import br.com.estoque.objeto.NotaProduto;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author icaro
 */
@Local
public interface INotaProdutoBean {

    public void salvar(NotaProduto nota);

    public void remover(NotaProduto nota);
    
    public void alterar(NotaProduto nota);

    public NotaProduto consultarPorNnota(Long nnota);

    public List<NotaProduto> consultarTodos();
    
}
