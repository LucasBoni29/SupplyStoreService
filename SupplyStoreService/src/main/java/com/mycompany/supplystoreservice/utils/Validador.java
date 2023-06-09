/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.utils;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * Classe utilitária responsável por validar todas as telas que contenham campos
 * @author lucas.bsantos59
 */
public class Validador {
    
    private final ArrayList<JTextField> txtFields;
    private final ArrayList<JComboBox> cbxFields;
    private final ArrayList<JFormattedTextField> ftfFields;
    private final ArrayList<JSpinner> pinFields;
    public static ArrayList<String> logs;
    
    /**
     * Método construtor da classe {@link Validador}
     */
    public Validador(){
        this.txtFields = new ArrayList<>();
        this.cbxFields = new ArrayList<>();
        this.ftfFields = new ArrayList<>();
        this.pinFields = new ArrayList<>();
        this.logs = new ArrayList<>();
    }
    
    /**
     * Método responsável por pegar todos os logs
     * @return Uma lista de String contendo todos os logs
     */
    public static ArrayList<String> getLogs() {
        return logs;
    }
    
    /**
     * Essa função pega todos os components dentro do JPanel específicado e guarda
     * dentro dos ArrayLists da classe Validador.
     * @param panPanel JPanel da tela que contém todos os campos
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
    
    /**
     * Essa função pega todos os components dentro do JFrame específicado e guarda
     * dentro dos ArrayLists da classe Validador.
     * @param frmFrame JFrame da tela que contém todos os campos
     */
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
    
    /**
     * Método responsável por validar todos os campos obrigatórios da tela
     */
    public void proValidarCamposObrigatorios(){
        if(!txtFields.isEmpty()){
            for(JTextField obj : txtFields){
                if(obj.getText().equals("")){
                    logs.add(obj.getName()+": Preencha o campo corretamente!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            } 
        }
        
        if(!cbxFields.isEmpty()){
            for(JComboBox obj : cbxFields){
                if(obj.getSelectedIndex() == -1){
                    logs.add(obj.getName()+": Preencha o campo corretamente!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            }
        }
        
        if(!ftfFields.isEmpty()){
            for(JFormattedTextField obj : ftfFields){
                if(obj.getValue() == null || obj.getValue().equals("")){
                    logs.add(obj.getName()+": Preencha o campo corretamente!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            } 
        }
        
        if(!pinFields.isEmpty()){
            for(JSpinner obj : pinFields){
                if(obj.getValue().equals(0)){
                    logs.add(obj.getName()+": Preencha o campo corretamente!");
                    obj.setBorder(BorderFactory.createLineBorder(Color.RED));
                }else{
                    obj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            } 
        }
    }
    
    /**
     * Método responsável por validar campos de e-mail
     * @param txtEmail Campo de texto que guarda o e-mail
     */
    public void proValidarEmail(JTextField txtEmail){
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        if(!txtEmail.getText().isEmpty()){
            Matcher matcher = pattern.matcher(txtEmail.getText());
            
            if(!matcher.matches()){
                logs.add("E-mail inválido! Não corresponde a expressão regular "
                        + "'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'");
                txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
            }else{
                txtEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
    }
    
    /**
     * Método responsável por validar os campos Nome e CPF ao tentar utilizar a busca
     * por filtro da tela {@link ManutencaoClientes}
     * @param txtNome Campo que contenha o Nome
     * @param ftfCpf Campo que contenha o CPF
     */
    public void proValidarCamposNomeCpfAoBuscar(JTextField txtNome, JFormattedTextField ftfCpf){
        if(txtNome.getText().equals("") && ftfCpf.getValue() == null){
            logs.add("Preencha corretamente os campos Nome ou Cpf para a devida busca!");
            txtNome.setBorder(BorderFactory.createLineBorder(Color.RED));
            ftfCpf.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            txtNome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            ftfCpf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    
    /**
     * Método responsável por validar um campo que tenha data no formato 'dd/MM/yyyy'
     * @param data Camnpo que contenha a data
     */
    public void proValidarData(JFormattedTextField data) {
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        sdfData.setLenient(false); // não permite datas inválidas como 31/02/2023
        boolean dataInvalida = false;
        
        try {
            Date dataNascimento;
            dataNascimento = sdfData.parse(data.getText());
            Calendar cal;
            cal = Calendar.getInstance();
            cal.setTime(dataNascimento);

            int ano = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH) + 1;
            int dia = cal.get(Calendar.DAY_OF_MONTH);

            // Verifica se o ano é válido
            Calendar anoAtual = Calendar.getInstance();
            int anoMaximo = anoAtual.get(Calendar.YEAR);
            if (ano > anoMaximo || ano < 1900) {
                dataInvalida = true;
            }

            // Verifica se o mês está entre 1 e 12
            if (mes < 1 || mes > 12) {
                dataInvalida = true;
            }

            // Verifica se o dia está dentro do intervalo válido para o mês e ano especificados
            int diasNoMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            if(dia < 1 || dia > diasNoMes){
                dataInvalida = true;
            }
            
            if(!dataInvalida){
                data.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }else{
                logs.add("Data inválida!");
                data.setBorder(BorderFactory.createLineBorder(Color.RED));
            }
        } catch (ParseException e) {
            logs.add("Data inválida!");
            data.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
    }
    
    /**
     * Método responsável por verificar se foi gerado alguma mensagem de validação
     * @return Status se tem ou não tem mensagem de validação gerada
     */
    public boolean fncTemMensagem(){
        return !logs.isEmpty();
    }
    
    /**
     * Método responsável por mostrar todas as mensagens de validação geradas
     */
    public void proMostrarLog(){
        StringBuilder mensagemFinal = new StringBuilder();
        for(String mensagem : logs){
            mensagemFinal.append(mensagem);
            mensagemFinal.append("\n");
        }
        
        JOptionPane.showMessageDialog(null, mensagemFinal, "Validações", JOptionPane.WARNING_MESSAGE);
    }
   
}
