/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author lucas.bsantos59
 */
public class Validador {
    
    private final ArrayList<JTextField> txtFields;
    private final ArrayList<JComboBox> cbxFields;
    private final ArrayList<JFormattedTextField> ftfFields;
    private final ArrayList<JSpinner> pinFields;
    public static ArrayList<String> logs;
    
    public Validador(){
        this.txtFields = new ArrayList<>();
        this.cbxFields = new ArrayList<>();
        this.ftfFields = new ArrayList<>();
        this.pinFields = new ArrayList<>();
        this.logs = new ArrayList<>();
    }
    
    public static ArrayList<String> getLogs() {
        return logs;
    }
    
    /**
     * Essa função pega todos os components dentro do JPanel específicado e guarda
     * dentro dos ArrayLists da classe Validador.
     * @param panPanel 
     */
    public void preechendoArrayList(JPanel panPanel){
        
        for (Component component : panPanel.getComponents()) {
            if (component instanceof JFormattedTextField) {
                ftfFields.add((JFormattedTextField) component);
            } else if (component instanceof JComboBox) {
                cbxFields.add((JComboBox) component);
            } else if (component instanceof JTextField){
                txtFields.add((JTextField)component);
            } else if (component instanceof JSpinner){
                pinFields.add((JSpinner)component);
            }
        }
    }
    public void preechendoArrayList(JFrame frmFrame){
        
        for (Component component : frmFrame.getComponents()) {
            if (component instanceof JTextField) {
                txtFields.add((JTextField) component);
            } else if (component instanceof JComboBox) {
                cbxFields.add((JComboBox) component);
            } else if (component instanceof JFormattedTextField){
                ftfFields.add((JFormattedTextField)component);
            } else if (component instanceof JSpinner){
                pinFields.add((JSpinner)component);
            }
        }
    }
    
    public void proValidarCamposObrigatorios(){
        //TODO Fazer a verificação utilizando as variáveis globais em vez de passar por parâmetro
        if(!txtFields.isEmpty()){
            for(JTextField obj : txtFields){
                if(obj.getText().equals("")){
                    logs.add(obj.getName()+": Preencha o campo!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            } 
        }
        
        if(!cbxFields.isEmpty()){
            for(JComboBox obj : cbxFields){
                if(obj.getSelectedIndex() == -1){
                    logs.add(obj.getName()+": Preencha o campo!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            }
        }
        
        if(!ftfFields.isEmpty()){
            for(JFormattedTextField obj : ftfFields){
                if(obj.getValue() == null || obj.getValue().equals("")){
                    logs.add(obj.getName()+": Preencha o campo!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            } 
        }
        
        if(!pinFields.isEmpty()){
            for(JSpinner obj : pinFields){
                if(obj.getValue().equals(0)){
                    logs.add(obj.getName()+": Preencha o campo!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            } 
        }
    }
    
    public void proValidarCamposPreenchidosIncorretamente(){
        
        if(!ftfFields.isEmpty()){
            for(JFormattedTextField obj : ftfFields){
                if(obj.getValue() == null || obj.getValue().equals("")){
                    logs.add(obj.getName()+": Preencha o campo!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            }
        }
    }
    
    public static void proValidarCamposNomeCpfAoBuscar(JTextField txtNome, JTextField txtCpf){
        
        if(txtNome.getText().equals("") && txtCpf.getText().equals("")){
            logs.add("Preencha pelo menos um dos campos!");
            txtNome.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtCpf.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            txtNome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            txtCpf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        
    }
    
    public boolean fncTemMensagem(){
        return !logs.isEmpty();
    }
    
    public void proMostrarLog(){
        StringBuilder mensagemFinal = new StringBuilder();
        for(String mensagem : logs){
            mensagemFinal.append(mensagem);
            mensagemFinal.append("\n");
        }
        
        JOptionPane.showMessageDialog(null, mensagemFinal, "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
    }
   
}
