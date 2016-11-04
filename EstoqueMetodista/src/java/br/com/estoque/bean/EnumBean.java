/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.bean;

import br.com.estoque.enums.Categoria;
import br.com.estoque.enums.EstadoBrasil;
import br.com.estoque.enums.Pais;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//selection=""
/**
 *
 * @author icaro
 */
@ManagedBean
@ViewScoped
public class EnumBean  implements Serializable{
    public Categoria[] getCategorias()
    {
    return Categoria.values();
    }
    public Pais[] getPais()
    {
    return Pais.values();
    }
     public EstadoBrasil[] getEstados()
    {
    return EstadoBrasil.values();
    }
    
}
