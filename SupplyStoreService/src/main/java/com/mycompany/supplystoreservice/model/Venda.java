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
  
    private int id;
    private String nomeCliente;
    private String produto;
    private int quantidade;
    private int data;
    
    public Venda(){
        
    }

    public Venda(int id, int quantidade, int data, String nomeCliente, String produto) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.quantidade = quantidade;
        this.data = data;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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
    
    
}
