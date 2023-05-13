/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas.bsantos59
 */
public class ToolCrud {
    
    public List<String> removerMascarasCliente(List<String> camposMascara){
        String regex = "[\\W\\s]";
        List<String> dadosFormatados = new ArrayList<>();
        
        dadosFormatados.add(camposMascara.get(0).replaceAll(regex, ""));
        dadosFormatados.add(camposMascara.get(1).replaceAll(regex, ""));
        dadosFormatados.add(camposMascara.get(2).replaceAll(regex, ""));
        
        return dadosFormatados;
    }
   
}
