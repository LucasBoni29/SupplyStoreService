/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.dao;

import com.mycompany.supplystoreservice.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
                  + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
            
            comandoSQL.setInt(1, entidade.getId());
            comandoSQL.setString(2, entidade.getNome());
            comandoSQL.setString(3, entidade.getCpf());
            comandoSQL.setString(4, entidade.getEndereco());
            comandoSQL.setInt(5, entidade.getTelefone());
            comandoSQL.setString(6, entidade.getEmail());
            comandoSQL.setString(7, entidade.getSexo());
            comandoSQL.setString(8, entidade.getEstadoCivil());
            comandoSQL.setInt(9, entidade.getDataNascimento());
            
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
    
    public static void findAllByNomeAndCpf(String nome, Object cpf, JTable tabel){
        List<Cliente> listCliente = new ArrayList<>();
        Connection conexao;
        boolean achouRegistro = false;
        
        try {
            //Passo 1 Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/supplystoredservice";
            conexao = DriverManager.getConnection(url,"root","");
            
            //Passo 3 - Preparar o comando SQL
            
            PreparedStatement comandoSQL = null;
            
            if(nome != null && !"".equals(nome) && cpf != null && !cpf.equals("")){
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM cliente WHERE nrCpf = ? "
                        + "AND dsNome = ?");
                comandoSQL.setString(1, String.valueOf(cpf));
                comandoSQL.setString(2, nome);
            }else if(nome != null && !"".equals(nome)){
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM cliente WHERE dsNome = ?");
                comandoSQL.setString(1, nome);
            }else if(cpf != null && !cpf.equals("")){
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM cliente WHERE nrCpf = ?");
                comandoSQL.setString(1, String.valueOf(cpf));
            }
            
            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                //Percorro o resultset ("tabela" na memória)
                //e passo os valores a um objeto
                while(rs.next()){
                    Cliente obj = new Cliente();
                    obj.setId(rs.getInt("nrId"));
                    obj.setNome(rs.getString("dsNome"));
                    obj.setCpf(rs.getString("nrCpf"));
                    obj.setEndereco(rs.getString("dsEndereco"));
                    obj.setTelefone(rs.getInt("nrTelefone"));
                    obj.setEmail(rs.getString("dsEmail"));
                    obj.setSexo(rs.getString("dsSexo"));
                    obj.setEstadoCivil(rs.getString("dsEstadoCivil"));
                    obj.setDataNascimento(rs.getInt("dtNascimento"));
                    
                    listCliente.add(obj);
                    achouRegistro = true;
                }
                
                DefaultTableModel modelo = (DefaultTableModel)tabel.getModel();
                //Limpo a tabela
                modelo.setRowCount(0);
                //Percorrer a lista e adicionar à tabela
                for (Cliente item : listCliente) {
                    modelo.addRow(new String[]{String.valueOf(item.getId()),
                                               String.valueOf(item.getNome()),
                                               String.valueOf(item.getCpf()),
                                               String.valueOf(item.getEndereco()),
                                               String.valueOf(item.getTelefone()),
                                               String.valueOf(item.getEmail()),
                                               String.valueOf(item.getSexo()),
                                               String.valueOf(item.getEstadoCivil()),
                                               String.valueOf(item.getDataNascimento())
                                            });
                }
                
                if(achouRegistro){
                    JOptionPane.showMessageDialog(null, 
                    "Consulta realizada com sucesso!", 
                    "Consulta", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, 
                    "Não foram encontrados registros!", 
                    "Consulta", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar o Driver", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao abrir a conexão!", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        }
    }
}
