/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supplystoreservice.dao;

import com.mycompany.supplystoreservice.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class ManutencaoProdutosDAO {
    
    public static ArrayList<Produto> buscarTudo () {
        
         ArrayList<Produto> retorno = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = 
                    conexao.prepareStatement("SELECT * FROM produtos");
              
           
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){

                while(rs.next()){
                    Produto obj = new Produto();
                    
                    obj.setId(rs.getInt("id_produto"));
                    obj.setNome(rs.getString("nome_produto"));
                    obj.setQuantidade(rs.getInt("quantidade"));
                    obj.setValor(rs.getDouble("valor"));
                    
                    retorno.add(obj);
                
                }
            }
                    
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em buscarTudo");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em buscarTudo");
        }
        
        return retorno;
         
     }
    
    public static boolean salvarEstoque(Produto obj){
        
        boolean retorno = false;
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = conexao.prepareStatement ("INSERT INTO produtos "
                    + "(nome_produto, quantidade, valor )VALUES (? , ?, ?)");
           
        
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setInt(2, obj.getQuantidade());
            comandoSQL.setDouble(3, obj.getValor());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em salvar");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em salvar");
        }
        
        return retorno;
        
    }
    
    public static boolean alterarEstoque(Produto obj){
        
        boolean retorno = false;
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = conexao.prepareStatement ("UPDATE produtos\n" +
        "SET nome_produto = ?, quantidade = ?, valor = ?\n" +
        "WHERE id_produto = ?;");
           

            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setInt(2, obj.getQuantidade());
            comandoSQL.setDouble(3, obj.getValor());
            comandoSQL.setInt(4, obj.getId());
            
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em alterar");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em alterar");
        }
        
        return retorno;
    }
    
    public static boolean excluirEstoque(Produto obj){
        
        boolean retorno = false;
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = conexao.prepareStatement ("delete from produtos where id_produto = ?");
           
            comandoSQL.setInt(1, obj.getId());            
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em excluir");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em excluir");
        }
        
        return retorno;
    }
    
    public static boolean cpfEstoque(Produto obj){
        
        boolean retorno = false;
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = conexao.prepareStatement ("select * from clientes where cpf = ?");
           
            comandoSQL.setInt(1, obj.getId());            
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em cpf");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em cpf");
        }
        
        return retorno;
    }
    
    
    public static ArrayList<Produto> attCliente () {
        
         ArrayList<Produto> retorno = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = 
                    conexao.prepareStatement("SELECT cpf FROM clientes");
              
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){

                while(rs.next()){
                    Produto obj = new Produto();
           
                    obj.setCpf(rs.getString("cpf"));
                                        
                    retorno.add(obj);
                
                }
            }
                    
            if (retorno.isEmpty()){
                JOptionPane.showMessageDialog(null, 
                            "O campo cliente está vazio",
                            "Cliente vazio",
                            JOptionPane.INFORMATION_MESSAGE);
                return retorno;
            }else{
                JOptionPane.showMessageDialog(null, 
                            "Lista de cliente carrega",
                            "Cliente ok",
                            JOptionPane.INFORMATION_MESSAGE);
                
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em attCliente");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em attCliente");
        }
        
        return retorno;
         
     }
    
    public static ArrayList<Produto> attProdutos () {
        
         ArrayList<Produto> retorno = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = 
                    conexao.prepareStatement("SELECT nome_produto FROM produtos");
              
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){

                while(rs.next()){
                    Produto obj = new Produto();
           
                    obj.setNome(rs.getString("nome_produto"));
                                        
                    retorno.add(obj);
                
                }
            }
                    
            if (retorno.isEmpty()){
                JOptionPane.showMessageDialog(null, 
                            "O campo cliente está vazio",
                            "Cliente vazio",
                            JOptionPane.INFORMATION_MESSAGE);
                return retorno;
            }else{
                JOptionPane.showMessageDialog(null, 
                            "Lista de cliente carrega",
                            "Cliente ok",
                            JOptionPane.INFORMATION_MESSAGE);
                
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em attProduto");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em attProduto");
        }
        
        return retorno;
         
     }
    
    
    public static ArrayList<Produto> buscarCarrinho(){
        
       ArrayList<Produto> retorno = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = 
                    conexao.prepareStatement("SELECT * FROM carrinho");
              
           
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){

                while(rs.next()){
                    Produto obj = new Produto();
                    
                    obj.setId(rs.getInt("id_carrinho"));
                    obj.setNome(rs.getString("produto_carrinho"));
                    obj.setQuantidade(rs.getInt("qtd_carrinho"));
                    obj.setValor(rs.getDouble("valor_carrinho"));
        
                    retorno.add(obj);
                
                }
            }
                    
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em buscarCarrinho");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em buscarCarrinho");
        }
        
        return retorno;
          
    }
    
    public static boolean SalvarfProdutoCarrinho(Produto obj){
        
        boolean retorno = false;
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://127.0.0.1:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "root");
            
            PreparedStatement comandoSQL = conexao.prepareStatement ("INSERT INTO carrinho "
                    + "(produto_carrinho,qtd_carrinho,valor_carrinho )VALUES (? , ?, ?)");
            
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setInt(2, obj.getQuantidade());
            comandoSQL.setDouble(3, obj.getValor());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em salvarCarrinho");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em salvarCarrinho");
        }
        
        return retorno;
    }
    
}
    
    

