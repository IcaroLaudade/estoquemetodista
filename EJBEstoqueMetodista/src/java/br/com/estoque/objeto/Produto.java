/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.objeto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seqProd", sequenceName = "seqProd", initialValue = 0, allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "Produto.consultarTodos", query = "select p from Produto p")})
public class Produto implements Serializable {

    private static final long serialVersionUID = -8932351667444603095L;


    public Produto() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProd")
    private long codigo;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date validade;

    @Column(nullable = false)
    private String categoria;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nota",referencedColumnName = "id")
    private NotaProduto nota;
     @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "id_local",referencedColumnName = "id")
    private LocalArmazenamento local;
    /**
     * @return the valor
     */
    
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the validade
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(Date validade) {
        this.validade = validade;
    }

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    //na view ter nome categoria com combo box e data validade com campo de data
    //
    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the nota
     */
    public NotaProduto getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(NotaProduto nota) {
        this.nota = nota;
    }

    /**
     * @return the local
     */
    public LocalArmazenamento getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(LocalArmazenamento local) {
        this.local = local;
    }

    /**
     * @return the local
     */
    // public LocalArmazenamento getLocal() {
    //    return local;
    // }
    /**
     * @param local the local to set
     */
    // public void setLocal(LocalArmazenamento local) {
    //    this.local = local;
    //}
}
