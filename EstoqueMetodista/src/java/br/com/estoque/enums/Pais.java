/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.enums;

import java.io.Serializable;

/**
 *
 * @author icaro
 */
public enum Pais implements Serializable{
    BRASIL("Brasil"),
    EUA("EUA"),
    OUTROS("Outros");
    private String pais;
    private Pais(String pais)
    {
    this.pais=pais;
    }
      @Override
    public String toString() {
        return pais;
    }
   
}
