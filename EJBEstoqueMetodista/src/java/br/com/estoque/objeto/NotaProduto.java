/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.objeto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 253746
 */
@Entity
@SequenceGenerator(name = "seqNota",sequenceName = "seqNota",initialValue = 0,allocationSize = 1)
@NamedQueries({@NamedQuery(name = "NotaProduto.consultarTodos",query = "SELECT n FROM NotaProduto n")
,@NamedQuery(name = "NotaProduto.consultarProdutos",query = "SELECT p FROM Produto p,NotaProduto n where n.id=:nNota")})
public class NotaProduto implements Serializable {
    private static final long serialVersionUID = -3645207621300553617L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "seqNota")
    private long id;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private long nNota;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "nota")  
    private List<Produto> produtos;

    public NotaProduto() {
        
    }

    public long getnNota() {
        return nNota;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setnNota(long nNota) {
        this.nNota = nNota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
