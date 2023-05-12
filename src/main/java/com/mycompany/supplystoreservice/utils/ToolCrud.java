/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.utils;

import com.mycompany.supplystoreservice.model.Cliente;

/**
 *
 * @author lucas.bsantos59
 */
public class ToolCrud {
    
    public Cliente removerMascarasCliente(Cliente entidade){
        String regex = "[\\W\\s]";
        
        entidade.setCpf(entidade.getCpf().replaceAll(regex, ""));
        entidade.setTelefone(Integer.parseInt(String.valueOf(
                entidade.getTelefone()).replaceAll(regex, "")));
        entidade.setDataNascimento(Integer.parseInt(String.valueOf(entidade.getDataNascimento()).replaceAll(regex, "")));
        
        return entidade;
    }
   
}
