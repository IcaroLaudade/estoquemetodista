/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.objeto;

/**
 *
 * @author 253746
 */
public class Funcionario {
    private String username;
    private String password;
    private String nome;
    public Funcionario()
    {
    }
    
    public Funcionario(String username,String password,String nome)
    {
    this.username=username;
    this.password=password;
    this.nome=nome;
    }
    public void setUsername(String email)
    {
    this.username=email;
    }
    public String getUsername()
    {
    return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
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
