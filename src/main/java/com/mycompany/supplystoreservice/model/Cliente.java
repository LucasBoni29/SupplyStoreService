/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.model;

/**
 * Entidade Cliente, responsável por utilizar os valores passados da tabela Cliente
 * @author lucas.bsantos59
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private String endereco;
    private Integer telefone;
    private String email;
    private String sexo;
    private String estadoCivil;
    private Integer dataNascimento;
    
    /**
     * Método construtor da classe {@link Cliente}
     */
    public Cliente(){
        
    }

    /**
     * Método getter do Nome
     * @return Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método setter do Nome
     * @param nome Nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método getter do CPF
     * @return CPF
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Método setter do CPF
     * @param cpf CPF
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Método getter do Endereço
     * @return Endereço
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Método setter do Endereço
     * @param endereco Endereço
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Método getter do Telefone
     * @return Telefone
     */
    public Integer getTelefone() {
        return telefone;
    }

    /**
     * Método setter do Telefone
     * @param telefone Telefone
     */
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    /**
     * Método getter do E-mail
     * @return E-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método setter do E-mail
     * @param email E-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método getter do sexo
     * @return sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Método setter do sexo
     * @param sexo sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Método getter do Estado Civil
     * @return Estado Civil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Método setter do Estado Civil
     * @param estadoCivil Estado Civil
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * Método getter da Data de Nascimento
     * @return Data de Nascimento
     */
    public Integer getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Método setter da Data de Nascimento
     * @param dataNascimento Data de Nascimento
     */
    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
