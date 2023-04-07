/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author lucas.bsantos59
 */
public class Validador {
    
   public static ArrayList<String> logs = new ArrayList<>();

    public static ArrayList<String> getLogs() {
        return logs;
    }
    
    public static void ValidarCamposPesquisa(JTextField txtNome, JTextField txtCpf) throws Exception{
        
        if(txtNome.getText().isEmpty() && txtCpf.getText().isEmpty()){
            logs.add("Preencha pelo menos um dos campos!");
        }
        
        if(txtCpf.getText().length() < 11){
            logs.add("CPF: Preencha o campo!");
        }
        
    }
   
}
