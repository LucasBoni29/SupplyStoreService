/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.model;

/**
 *
 * @author gusta
 */
public class Produto {
    
    private int id;
    private int idCarrinho;
    private String idBusca;
    private String nome;
    private int quantidade;
    private double valor;
    private String cpf;
    
    public Produto(String nome, int quantidade, double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    
    public Produto(String nome, int quantidade, double valor, String cpf, int id) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.cpf = cpf;
        this.id = id;
    }

    public Produto(int id, int idCarrinho, String nome, int quantidade, double valor, String cpf) {
        this.id = id;
        this.idCarrinho = idCarrinho;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.cpf = cpf;
    }
    
    public Produto (int id, String nome, int quantidade, double valor){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Produto(String idBusca, String nomeCarrinho, int quantidadeCarrinho, double valorProdutoCarrinho, String cpf) {
        
       this.idBusca=idBusca;
       this.nome=nomeCarrinho;
       this.quantidade = quantidadeCarrinho;
       this.valor=valorProdutoCarrinho;
       this.cpf =cpf;
    }
            

    
    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Produto() {
       
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
        
}



    