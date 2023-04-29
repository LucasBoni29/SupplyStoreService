/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.dao;

import com.mycompany.supplystoreservice.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.bsantos59
 */
public class ManutencaoClientesDAO {
    
    public static boolean salvar(Cliente entidade){
        
        boolean retorno = false;
        Connection conexao;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/supplystoredservice";
            
            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "");
            
             //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "INSERT INTO \r\n"
                  + "cliente(nrId, dsNome, nrCpf, dsEndereco, nrTelefone, dsEmail, "
                  + "dsSexo, dsEstadoCivil, dtNascimento) \r\n"
                  + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)"); 
            
            comandoSQL.setInt(1, entidade.getId());
            comandoSQL.setString(2, entidade.getNome());
            comandoSQL.setString(3, entidade.getCpf());
            comandoSQL.setString(4, entidade.getEndereco());
            comandoSQL.setInt(5, entidade.getTelefone());
            comandoSQL.setString(6, entidade.getEmail());
            comandoSQL.setString(7, entidade.getSexo());
            comandoSQL.setString(8, entidade.getEstadoCivil());
            comandoSQL.setString(8, entidade.getDataNascimento());
            
            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar o Driver", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao abrir a conexão", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        }
        
        return retorno;
        
    }
    
    
}
