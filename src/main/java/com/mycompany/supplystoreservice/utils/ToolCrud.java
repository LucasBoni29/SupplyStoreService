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
        List<String> camposFormatados = new ArrayList<>();
        
        camposMascara.forEach(obj -> camposFormatados.add(obj.replaceAll(regex, "")));
        camposMascara.forEach(obj -> camposFormatados.add(obj.replaceAll(" ", "")));
        
        return camposFormatados;
    }
   
}
