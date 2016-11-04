/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.bean;

import br.com.estoque.DAO.FuncionarioDAO;
import br.com.estoque.objeto.Funcionario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author icaro
 */
@ManagedBean
@SessionScoped
public class FuncionarioBean implements Serializable{

    private Funcionario funcionario = new Funcionario();
    private String nome;
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String logar() throws IOException {
         funcionario = new FuncionarioDAO().buscaPorUsuarioESenha(funcionario.getUsername(), funcionario.getPassword());
        
        if (funcionario != null) {
          
           nome=funcionario.getNome();
           funcionario=new Funcionario();
            return new RedirecionamentoBean().main();
        }
        
        funcionario = new Funcionario();
        return "";
    }
    public String logout(){
    nome = null;
    return new RedirecionamentoBean().index();
    }

    public void validaFuncionario(FacesContext fc, UIComponent component, Object value) throws ValidatorException {

        String valor = value.toString();
        Funcionario func = new Funcionario();
        func.setUsername(valor);
        func.setPassword(funcionario.getPassword());
       
        if (valor.length() < 4) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Os campos Usuario e Senha devem conter pelo menos 4 caracteres", ""));
        } else if (new FuncionarioDAO().buscaPorUsuarioESenha(func.getUsername(),func.getPassword()) == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario e/ou senha invalidos", ""));
        }
    }
  

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
