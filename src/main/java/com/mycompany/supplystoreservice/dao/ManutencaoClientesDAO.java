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
    
    public static void salvar(Cliente entidade){
        
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
                  + "cliente(dsNome, nrCpf, dsEndereco, nrTelefone, dsEmail, "
                  + "dsSexo, dsEstadoCivil, dtNascimento) \r\n"
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
            
            if(retorno){
                JOptionPane.showMessageDialog(null, 
                    "Registro cadastrado com sucesso!", 
                    "Cadastrar registro", JOptionPane.INFORMATION_MESSAGE);
            }else{
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
    
    public static void filtrar(Cliente entidade, JTable tabela){
        //TODO FAZER ESSA CONSULTA RETORNA RUMA LISTA PARA ATUALIZAR A COLUNA NA CLASSE 'ManutençãoClientes'
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
            
            if(entidade.getNome() == null && entidade.getCpf() != null){
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM cliente WHERE nrCpf = ?");
                comandoSQL.setString(1, entidade.getCpf());
            }else if(entidade.getNome() != null && entidade.getCpf() == null){
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM cliente WHERE dsNome = ?");
                comandoSQL.setString(1, entidade.getNome());
            }else{
                comandoSQL = 
                conexao.prepareStatement("SELECT * FROM cliente "
                        + "WHERE nrCpf = ? AND dsNome = ?");
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
                
                DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
                //Limpo a tabela
                modelo.setRowCount(0);
                //Percorrer a lista e adicionar à tabela
                for (Cliente item : listCliente) {
                    modelo.addRow(new String[]{String.valueOf(item.getNome()),
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
                    "Filtro", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, 
                    "Não foram encontrados registros!", 
                    "Filtro", JOptionPane.WARNING_MESSAGE);
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
    
    public static ArrayList<Cliente> consultar() {
        ArrayList<Cliente> listFinal;
        listFinal = new ArrayList<>();
        Connection conexao;
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/supplystoredservice";
            
            conexao = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "SELECT dsNome, nrCpf, dsEndereco, nrTelefone, dsEmail, "
                  + "dsSexo, dsEstadoCivil, dtNascimento FROM cliente");

            //passo 4 executar o comando SQL 
            ResultSet listCliente = comandoSQL.executeQuery();
            if (listCliente != null) {

                while (listCliente.next()) {
                    Cliente entidade = new Cliente();

                    entidade.setNome(listCliente.getString("Nome"));
                    entidade.setCpf(listCliente.getString("CPF"));
                    entidade.setEndereco(listCliente.getString("Endereço"));
                    entidade.setTelefone(listCliente.getInt("Telefone"));
                    entidade.setEmail(listCliente.getString("E-mail"));
                    entidade.setSexo(listCliente.getString("Sexo"));
                    entidade.setEstadoCivil(listCliente.getString("Estado civil"));
                    entidade.setDataNascimento(listCliente.getInt("Nascimento"));
                    listFinal.add(entidade);
                }
            }
            
            if(listFinal.isEmpty()){
                JOptionPane.showMessageDialog(null, 
                    "Não foi encontrado nenhum registro", 
                    "Consultar registro", JOptionPane.INFORMATION_MESSAGE);
                return listFinal;
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
            String url = "jdbc:mysql://localhost:3306/supplystoredservice";

            conexao = DriverManager.getConnection(url, "root", "");
            //PASSO 3  prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "DELETE FROM cliente WHERE cpf = ?");

            comandoSQL.setInt(1, 
                    Integer.parseInt(tabela.getValueAt(
                            tabela.getSelectedRow(), 1).toString()));
            
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
            String url = "jdbc:mysql://localhost:3306/supplystoredservice";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement comandoSQL = null;
            
            comandoSQL = conexao.prepareStatement(
                "UPDATE cliente SET dsNome = ?, nrCpf = ?, dsEndereco = ?, nrTelefone = ?, dsEmail = ?, "
                  + "dsSexo = ?, dsEstadoCivil = ?, dtNascimento = ? WHERE nrCpf = ?"); 
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
}