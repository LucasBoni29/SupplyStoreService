/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.model;


/**
 *
 * @author Manzano
 */
public class Venda {
  
    private String id;
    private String nomeCliente;
    private String produto;
    private String quantidade;
    private String data;
    
    public Venda(){
        
    }

    public Venda(String id, String quantidade, String data, String nomeCliente, String produto) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.quantidade = quantidade;
        this.data = data;
        this.produto = produto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

   
    
}
