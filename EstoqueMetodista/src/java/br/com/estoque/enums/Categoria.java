/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.enums;

import java.io.Serializable;

/**
 *
 * @author 238123
 */
public enum Categoria implements Serializable{
    DOMESTICO("Artigos domésticos"),
    CIGARROS("Cigarro e semelhantes"),
    DOCE("Doce"),
    CONGELADOS("Congelados"),
    FRIOS("Frios"),
    INDUSTRIALIZADO("Industrializado"),
    MEDICAMENTO("Medicamento"),
    LIMPEZA("Produto de limpeza"),               
    NATURAL("Frutas,legumes e verduras"),
    ALCOOLICA("Bebida alcoolica"),
    ENERGETICO("Energetico"),
    BEBIDA("Outras bebidas"),    
    OUTROS("Outros");
    private String categoria;
    private Categoria(String categoria)
    {
    this.categoria=categoria;
    }
      @Override
    public String toString() {
        return categoria;
    }
}
