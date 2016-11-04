/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.bean;

import br.com.EJBEstoque.ILocalArmazenamentoBean;
import br.com.EJBEstoque.INotaProdutoBean;
import br.com.EJBEstoque.IProdutoBean;
import br.com.estoque.objeto.LocalArmazenamento;
import br.com.estoque.objeto.NotaProduto;
import br.com.estoque.objeto.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable {

    private Produto produto = new Produto();//usada para consulta,alteração e exclusão
    private Produto prodCadNota;//usada para cadastro
    private NotaProduto nota;
    private NotaProduto notaCad;
    private List<NotaProduto> notas = new ArrayList<>();
    private List<Produto> produtos;
    private List<LocalArmazenamento> locais = new ArrayList<>();
    private LocalArmazenamento local = new LocalArmazenamento();
    private LocalArmazenamento localCad = new LocalArmazenamento();
    private List<Produto> prodNota = new ArrayList<>();

    private RedirecionamentoBean redirecionamento=new RedirecionamentoBean();
    @EJB
    private INotaProdutoBean notaEJB;
    @EJB
    private IProdutoBean produtoEJB;
    @EJB
    private ILocalArmazenamentoBean localEJB;

    @PostConstruct
    public void Iniciar() {
        notas = notaEJB.consultarTodos();
        produtos = produtoEJB.consultarTodos();
        locais = localEJB.consultarTodos();
        notaCad = new NotaProduto();
        produto = new Produto();
        prodCadNota = new Produto();
        
    }

    public void reset() {
        produto = null;
    }

    public String cadastraProdutoNota() {
        local = new LocalArmazenamento();
        return redirecionamento.cadastroProduto();

    }

    public String voltar() {
        reset();
        nota = null;
        return redirecionamento.main();
    }

    public LocalArmazenamento consultarLocalProduto() {
        try {
            local = localEJB.consultarLocalProduto(produto.getCodigo());
            return local;
        } catch (Exception e) {
            return new LocalArmazenamento();
        }
    }

    public List<Produto> consultarProdutosNota() {
        try {
            produtos = produtoEJB.consultarProdutoPorNota(nota.getnNota());
            return produtos;
        } catch (NullPointerException n) {
            produtos = produtoEJB.consultarTodos();
            return produtos;
        }
    }

    public String cadastrarProdutoNota() {

        prodCadNota.setNota(nota);
        prodCadNota.setLocal(local);
        produtoEJB.alterar(prodCadNota);
        produtos.add(prodCadNota);
        locais.add(local);
        notaCad = new NotaProduto();
        prodCadNota = new Produto();
        local = new LocalArmazenamento();
        return redirecionamento.main();

    }

    public String excluirNota() {
        nota.setProdutos(consultarProdutosNota());
        notaEJB.remover(nota);
        notas.remove(nota);
        return redirecionamento.main();
    }

    public String excluirProduto() {

        produto.setLocal(local);
        produtoEJB.remover(produto);
        return redirecionamento.main();
    }

    public String salvar() {
    
        notaEJB.salvar(notaCad);
        notas.add(notaCad);
        notaCad = new NotaProduto();
        return redirecionamento.main();

    }

    public String atualizarProduto() {

        produto.setLocal(local);
        produtoEJB.alterar(produto);
        local.setProduto(produto);
        localEJB.alterar(local);
        return redirecionamento.main();
    }

    public String atualizarNota() {

        notaEJB.alterar(nota);
        return redirecionamento.main();
    }

    public List<NotaProduto> consultarNotas() {
        return this.notas;
    }

    public List<Produto> consultarProdutos() {
        return this.getProdutos();
    }

    public void validaValorMaiorZero(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        try {
            double valor = Double.parseDouble(value.toString());
            if (valor <= 0) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um valor maior do que zero (0).", ""));
            }
        } catch (NumberFormatException erro) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um número.", ""));
        }
    }
    

    public void validaQuantidadeMaiorZero(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        try {
            double valor = Double.parseDouble(value.toString());
            if (valor <= 0) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe uma quantidade maior do que zero (0).", ""));
            }
        } catch (NumberFormatException erro) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um número.", ""));
        }
    }

    public void validaNnotaUnicoENumero(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        try {
            long valor = Long.parseLong(value.toString());

            for (NotaProduto notaValida : notas) {
                if (notaValida.getnNota() == valor) {
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Número de nota já existente", ""));
                }
            }
        } catch (NumberFormatException erro) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um número.", ""));
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NotaProduto getNota() {
        return nota;
    }

    public void setNota(NotaProduto nota) {
        this.nota = nota;
    }

    public LocalArmazenamento getLocal() {
        return local;
    }

    public void setLocal(LocalArmazenamento local) {
        this.local = local;
    }

    public List<NotaProduto> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaProduto> notas) {
        this.notas = notas;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdNota() {
        return prodNota;
    }

    public void setProdNota(List<Produto> prodNota) {
        this.prodNota = prodNota;
    }

    public List<LocalArmazenamento> getLocais() {
        return locais;
    }

    public void setLocais(List<LocalArmazenamento> locais) {
        this.locais = locais;
    }

    public NotaProduto getNotaCad() {
        return notaCad;
    }

    public void setNotaCad(NotaProduto notaCad) {
        this.notaCad = notaCad;
    }

    public Produto getProdCadNota() {
        return prodCadNota;
    }

    public void setProdCadNota(Produto prodCadNota) {
        this.prodCadNota = prodCadNota;
    }

  

}
