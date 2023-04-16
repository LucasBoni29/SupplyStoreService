/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.utils;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas.boni
 */
public class ToolTables {
    
    private final ArrayList<JTextField> txtFields;
    private final ArrayList<JComboBox> cbxFields;
    private final ArrayList<JFormattedTextField> ftfFields;
    private final ArrayList<JSpinner> pinFields;
    
    public ToolTables(){
        this.txtFields = new ArrayList<>();
        this.cbxFields = new ArrayList<>();
        this.ftfFields = new ArrayList<>();
        this.pinFields = new ArrayList<>();
    }
    
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
    
    public void proExcluirRegistro(JTable table){
        //Resgato o índice da linha selecionada
        int indiceLinha = table.getSelectedRow();
        if(indiceLinha != -1){
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            int opcao = JOptionPane.showConfirmDialog(null, 
                    "Tem certeza que deseja excluir o registro?", 
                    "Excluir registro", 
                    YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if(opcao == JOptionPane.YES_NO_OPTION){
                //Passo o indice da linha a ser removida
                model.removeRow(indiceLinha);
                
                JOptionPane.showMessageDialog(null, 
                        "Registro excluído com sucesso!", 
                        "Registro excluído", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, 
                    "Selecione uma linha da tabela para excluir!", 
                    "Validações", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void proEditarRegistro(JTable tabela){
        if(tabela.getSelectedRow() != -1){
            if(!txtFields.isEmpty()){
                for(JTextField obj : txtFields){
                    switch (obj.getName()) {
                        case "Nome":
                            tabela.setValueAt(obj.getText(), tabela.getSelectedRow(), 0);
                            break;
                        case "Endereço":
                            tabela.setValueAt(obj.getText(), tabela.getSelectedRow(), 2);
                            break;
                        case "E-mail":
                            tabela.setValueAt(obj.getText(), tabela.getSelectedRow(), 4);
                            break;
                        default:
                            break;
                    }
                }
            }
            
            if(!ftfFields.isEmpty()){
                for(JFormattedTextField obj : ftfFields){
                    switch (obj.getName()) {
                        case "CPF":
                            tabela.setValueAt(obj.getValue(), tabela.getSelectedRow(), 1);
                            break;
                        case "Telefone":
                            tabela.setValueAt(obj.getValue(), tabela.getSelectedRow(), 3);
                            break;
                        case "Data de nascimento":
                            tabela.setValueAt(obj.getValue(), tabela.getSelectedRow(), 7);
                            break;
                        default:
                            break;
                    }
                }
            }
            
            if(!cbxFields.isEmpty()){
                for(JComboBox obj : cbxFields){
                    switch (obj.getName()){
                        case "Estado civil":
                            String estadoCivilSelecionado = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 6));
                            tabela.setValueAt(estadoCivilSelecionado, tabela.getSelectedRow(), 6);
                            break;
                        case "Sexo":
                            String sexoSelecionado = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 5));
                            tabela.setValueAt(sexoSelecionado, tabela.getSelectedRow(), 5);
                            break;
                        default:
                            break;
                    }
                }
            }
            
            JOptionPane.showMessageDialog(null, 
                    "Registro editado com sucesso!", 
                    "Registro editado", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,
                    "Não foi possível capturar a seleção do registro na tabela!",
                "Selecionar registro na tabela", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void proSelecionarItensTabelaCliente(JTable tabela){
        if(tabela.getSelectedRow() != -1){
            if(!txtFields.isEmpty()){
                for(JTextField obj : txtFields){
                    switch (obj.getName()) {
                        case "Nome":
                            obj.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
                            break;
                        case "Endereço":
                            obj.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
                            break;
                        case "E-mail":
                            obj.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
                            break;
                        default:
                            break;
                    }
                }
            }
            
            if(!ftfFields.isEmpty()){
                for(JFormattedTextField obj : ftfFields){
                    switch (obj.getName()) {
                        case "CPF":
                            obj.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                            break;
                        case "Telefone":
                            obj.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
                            break;
                        case "Data de nascimento":
                            obj.setText(tabela.getValueAt(tabela.getSelectedRow(), 7).toString());
                            break;
                        default:
                            break;
                    }
                }
            }
            
            if(!cbxFields.isEmpty()){
                for(JComboBox obj : cbxFields){
                    switch (obj.getName()){
                        case "Estado civil":
                          String estadoCivilSelecionado = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 6));
                            obj.setSelectedItem(estadoCivilSelecionado);
                            break;
                        case "Sexo":
                            String sexoSelecionado = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 5));
                            obj.setSelectedItem(sexoSelecionado);
                            break;
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,
                    "Não foi possível capturar a seleção do registro na tabela!",
                "Selecionar registro na tabela", JOptionPane.ERROR_MESSAGE);
        }
    }
}
