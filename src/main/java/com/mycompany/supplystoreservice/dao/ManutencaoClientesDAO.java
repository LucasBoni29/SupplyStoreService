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
    
    //TODO TESTAR TODAS AS FUNÇÕES COM A BASE DE DADOS!
    
    public static void salvar(Cliente entidade){
        
        boolean retorno = false;
        Connection conexao;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/supplyStore";
            
            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "");
            
             //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "INSERT INTO \r\n"
                  + "clientes(nome_cli, cpf, endereco, telefone, email, "
                  + "sexo, estado_civil, data_nascimento) \r\n"
                  + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)"); 
            
            comandoSQL.setString(1, entidade.getNome());
            comandoSQL.setString(2, entidade.getCpf());
            comandoSQL.setString(3, entidade.getEndereco());
            comandoSQL.setInt(4, entidade.getTelefone());
            comandoSQL.setString(5, entidade.getEmail());
            comandoSQL.setString(6, entidade.getSexo());
            comandoSQL.setString(7, entidade.getEstadoCivil());
            comandoSQL.setInt(8, entidade.getDataNascimento());
            
            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
            if(!retorno){
                JOptionPane.showMessageDialog(null, 
                    "Não foi possível cadastrar o registro!", 
                    "Cadastrar registro", JOptionPane.INFORMATION_MESSAGE);
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
    }
    
    public static List<Cliente> filtrar(Cliente entidade){
        //TODO FAZER ESSA CONSULTA RETORNA RUMA LISTA PARA ATUALIZAR A COLUNA NA CLASSE 'ManutençãoClientes'
        List<Cliente> listCliente = new ArrayList<>();
        Connection conexao;
        
        try {
            //Passo 1 Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3308/supplyStore";
            conexao = DriverManager.getConnection(url,"root","");
            
            //Passo 3 - Preparar o comando SQL
            
            PreparedStatement comandoSQL = null;
            
            if(entidade.getNome() == null && entidade.getCpf() != null){
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM clientes WHERE cpf = ?");
                comandoSQL.setString(1, entidade.getCpf());
            }else if(entidade.getNome() != null && entidade.getCpf() == null){
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM clientes WHERE nome_cli LIKE ?");
                comandoSQL.setString(1, "%" +entidade.getNome() + "%");
            }else{
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM clientes "
                        + "WHERE cpf = ? AND nome_cli = ?");
                comandoSQL.setString(1, entidade.getCpf());
                comandoSQL.setString(2, entidade.getNome());
            }
            
            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                //Percorro o resultset ("tabela" na memória)
                //e passo os valores a um objeto
                while(rs.next()){
                    Cliente obj = new Cliente();
                    obj.setNome(rs.getString("nome_cli"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setTelefone(rs.getInt("telefone"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSexo(rs.getString("sexo"));
                    obj.setEstadoCivil(rs.getString("estado_civil"));
                    obj.setDataNascimento(rs.getInt("data_nascimento"));
                    
                    listCliente.add(obj);
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
        return listCliente;
    }
    
    public static ArrayList<Cliente> consultar() {
        ArrayList<Cliente> listFinal;
        listFinal = new ArrayList<>();
        Connection conexao;
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3308/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "SELECT nome_cli, cpf, endereco, telefone, email, "
                  + "sexo, estado_civil, data_nascimento FROM clientes");

            //passo 4 executar o comando SQL 
            ResultSet listCliente = comandoSQL.executeQuery();
            if (listCliente != null) {

                while (listCliente.next()) {
                    Cliente entidade = new Cliente();

                    entidade.setNome(listCliente.getString("nome_cli"));
                    entidade.setCpf(listCliente.getString("cpf"));
                    entidade.setEndereco(listCliente.getString("endereco"));
                    entidade.setTelefone(listCliente.getInt("telefone"));
                    entidade.setEmail(listCliente.getString("email"));
                    entidade.setSexo(listCliente.getString("sexo"));
                    entidade.setEstadoCivil(listCliente.getString("estado_civil"));
                    entidade.setDataNascimento(listCliente.getInt("data_nascimento"));
                    listFinal.add(entidade);
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar o Driver", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao abrir conexão", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        }
        return listFinal;
    }
    
    public static void excluir(JTable tabela) {
        Connection conexao;
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        try {
            // passo 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "");
            //PASSO 3  prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "DELETE FROM clientes WHERE cpf = ?");

            comandoSQL.setString(1, tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            
            int linhasAfetadas = comandoSQL.executeUpdate();

            if(linhasAfetadas > 0){
                model.removeRow(tabela.getSelectedRow());
                JOptionPane.showMessageDialog(null, 
                "Registro excluído com sucesso!", 
                "Excluir registro", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, 
                "Nenhum registro foi excluído", 
                "Excluir registro!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar o Driver", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao abrir conexão", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void alterar(Cliente entidade, JTable tabel) {
        boolean retorno = false;
        Connection conexao;
        try {
            //Passo 1 - Carregaro o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/supplyStore";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement comandoSQL = null;
            
            comandoSQL = conexao.prepareStatement(
                "UPDATE clientes SET nome_cli = ?, cpf = ?, endereco = ?, telefone = ?, email = ?, "
                  + " sexo = ?, estado_civil = ?, data_nascimento = ? WHERE cpf = ?"); 
            comandoSQL.setString(1, entidade.getNome());
            comandoSQL.setString(2, entidade.getCpf());
            comandoSQL.setString(3, entidade.getEndereco());
            comandoSQL.setInt(4, entidade.getTelefone());
            comandoSQL.setString(5, entidade.getEmail());
            comandoSQL.setString(6, entidade.getSexo());
            comandoSQL.setString(7, entidade.getEstadoCivil());
            comandoSQL.setInt(8, entidade.getDataNascimento());
            comandoSQL.setString(9, entidade.getCpf());
            

            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
            
            if(retorno){
                JOptionPane.showMessageDialog(null, 
                    "Alteração realizada com sucesso!", 
                    "Alterar", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, 
                    "Não foi possível realizar a alteração!", 
                    "Alterar", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar o Driver", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao abrir conexão", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static boolean fncRegistroExiste(String cpf){
        ArrayList<Cliente> listFinal;
        listFinal = new ArrayList<>();
        Connection conexao;
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3308/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "SELECT nome_cli, cpf, endereco, telefone, email, "
                  + "sexo, estado_civil, data_nascimento FROM clientes WHERE cpf = ?");
            
            comandoSQL.setString(1, cpf);

            //passo 4 executar o comando SQL 
            ResultSet listCliente = comandoSQL.executeQuery();
            if (listCliente != null) {

                while (listCliente.next()) {
                    Cliente entidade = new Cliente();

                    entidade.setNome(listCliente.getString("nome_cli"));
                    entidade.setCpf(listCliente.getString("cpf"));
                    entidade.setEndereco(listCliente.getString("endereco"));
                    entidade.setTelefone(listCliente.getInt("telefone"));
                    entidade.setEmail(listCliente.getString("email"));
                    entidade.setSexo(listCliente.getString("sexo"));
                    entidade.setEstadoCivil(listCliente.getString("estado_civil"));
                    entidade.setDataNascimento(listCliente.getInt("data_nascimento"));
                    listFinal.add(entidade);
                }
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar o Driver", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao abrir conexão", 
                    "Conexão com a base", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, 
                "Consulta realizada com sucesso!", 
                "Consulta", 
                JOptionPane.INFORMATION_MESSAGE);
        return !listFinal.isEmpty();
    }
}