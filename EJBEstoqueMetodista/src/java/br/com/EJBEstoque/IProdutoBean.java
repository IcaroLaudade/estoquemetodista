/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.EJBEstoque;

import br.com.estoque.objeto.Produto;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author icaro
 */
@Local
public interface IProdutoBean {
     public void salvar(Produto produto);

    public void remover(Produto produto);
    
    public void alterar(Produto produto);

    public Produto consultarPorId(Long id);

    public List<Produto> consultarTodos();
    public List<Produto> consultarProdutoPorNota(long id);
}
