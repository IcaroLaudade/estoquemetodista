/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author icaro
 */
@ManagedBean
@RequestScoped
public class RedirecionamentoBean implements Serializable{

    public String cadastroNota() {
        return "/CadastroNota?faces-redirect=true"; 
    }
    public String cadastroProduto()
    {
     return "/CadastroProduto?faces-redirect=true";
    }

    public String index() {
        return "/index?faces-redirect=true";
    }

    public String atualizaNotaRedirecionamento() {
        return "/AtualizaNota?faces-redirect=true";
    }

    public String atualizaProdutoRedirecionamento() {
        return "/AtualizaProduto?faces-redirect=true";
    }

    public String main() {
        return "/Main?faces-redirect=true";
    }

}
