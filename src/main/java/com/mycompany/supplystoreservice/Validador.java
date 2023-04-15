/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
    
    public static void proValidarCamposObrigatorios(ArrayList<JTextField> txtFields, 
        ArrayList<JComboBox> cbxFields, ArrayList<JFormattedTextField> ftfFields){
        
        for(JTextField obj : txtFields){
            if(obj.getText().equals("")){
                logs.add(obj.getName()+": Preencha o campo!");
                obj.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
        }
        
        for(JComboBox obj : cbxFields){
            if(obj.getSelectedIndex() == -1){
                logs.add(obj.getName()+": Preencha o campo!");
                obj.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
        }
        
        for(JFormattedTextField obj : ftfFields){
            if(obj.getText().equals("")){
                logs.add(obj.getName()+": Preencha o campo!");
                obj.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
        }
        
    }
    
    public static void proValidarCamposNomeCpfAoBuscar(JTextField txtNome, JTextField txtCpf){
        
        if(txtNome.getText().equals("") && txtCpf.getText().equals("")){
            logs.add("Preencha pelo menos um dos campos!");
            txtNome.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtCpf.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        
    }
   
}
