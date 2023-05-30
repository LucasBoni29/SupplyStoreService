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

    public static ArrayList<Produto> buscarTudo() {

        ArrayList<Produto> retorno = new ArrayList<>();

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM produtos");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
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

    public static boolean salvarEstoque(Produto obj) {

        boolean retorno = false;

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produtos "
                    + "(nome_produto, quantidade, valor )VALUES (? , ?, ?)");

            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setInt(2, obj.getQuantidade());
            comandoSQL.setDouble(3, obj.getValor());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em salvar");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em salvar");
        }

        return retorno;

    }

    public static boolean alterarEstoque(Produto obj) {

        boolean retorno = false;

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produtos\n"
                    + "SET nome_produto = ?, quantidade = ?, valor = ?\n"
                    + "WHERE id_produto = ?;");

            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setInt(2, obj.getQuantidade());
            comandoSQL.setDouble(3, obj.getValor());
            comandoSQL.setInt(4, obj.getId());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em alterar");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em alterar");
        }

        return retorno;
    }

    public static boolean excluirEstoque(Produto obj) {

        boolean retorno = false;

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("delete from produtos where id_produto = ?");

            comandoSQL.setInt(1, obj.getId());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em excluir");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em excluir");
        }

        return retorno;
    }

    public static boolean cpfEstoque(Produto obj) {

        boolean retorno = false;

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("select * from clientes where cpf = ?");

            comandoSQL.setInt(1, obj.getId());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em cpf");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em cpf");
        }

        return retorno;
    }

    public static ArrayList<Produto> attCliente() {

        ArrayList<Produto> retorno = new ArrayList<>();

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT cpf FROM clientes");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    Produto obj = new Produto();

                    obj.setCpf(rs.getString("cpf"));

                    retorno.add(obj);

                }
            }

            if (retorno.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "O campo cliente está vazio",
                        "Cliente vazio",
                        JOptionPane.INFORMATION_MESSAGE);
                return retorno;
            } else {
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

    public static ArrayList<Produto> attProdutos() {

        ArrayList<Produto> retorno = new ArrayList<>();

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT id_produto FROM produtos");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    Produto obj = new Produto();

                    obj.setNome(rs.getString("id_produto"));

                    retorno.add(obj);

                }
            }

            if (retorno.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "O campo cliente está vazio",
                        "Cliente vazio",
                        JOptionPane.INFORMATION_MESSAGE);
                return retorno;
            } else {
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

    public static ArrayList<Produto> buscarCarrinho() {

        ArrayList<Produto> retorno = new ArrayList<>();

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(""
                            + "SELECT id_compra, "
                            + "fk_cpf_cliente, "
                            + "fk_id_produto,"
                            + "nome_produto_carrinho,"
                            + "qtd_carrinho,"
                            + "valor_produto_carrinho "
                            + "FROM carrinho ");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    Produto obj = new Produto();

                    obj.setId(rs.getInt("id_compra"));
                    obj.setNome(rs.getString("nome_produto_carrinho"));
                    obj.setQuantidade(rs.getInt("qtd_carrinho"));
                    obj.setValor(rs.getDouble("valor_produto_carrinho"));

                    retorno.add(obj);

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {

            System.out.println(ex);
        }

        return retorno;

    }

    public static boolean SalvarfProdutoCarrinho(Produto obj, String id) {

        boolean retorno = false;

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO carrinho "
                    + "(fk_cpf_cliente, fk_id_produto, nome_produto_carrinho, qtd_carrinho, valor_produto_carrinho) "
                    + "VALUES (?, ?, ?, ?, ?);");

            comandoSQL.setString(1, obj.getCpf());
            comandoSQL.setInt(2, Integer.parseInt(id));
            comandoSQL.setString(3, buscaNome(id));
            comandoSQL.setInt(4, obj.getQuantidade());
            comandoSQL.setDouble(5, obj.getValor());
   
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return retorno;
    }

    public static double buscarValor(String id) {
        
        ResultSet rs; 
        double retorno = 0;
        

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement(
                                        
                    "SELECT valor from produtos left join "
                            + "carrinho on (produtos.id_produto = carrinho.fk_id_produto) "
                            + "where id_produto = ?;");
            
            comandoSQL.setString(1, id);
            rs = comandoSQL.executeQuery();
           
            if (rs != null) {

                while (rs.next()) {
                    Produto obj1 = new Produto();

                    obj1.setValor(rs.getDouble("valor"));

                    retorno = obj1.getValor();

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return retorno;
    }


    public static boolean excluirCarrinho(Produto obj) {

        boolean retorno = false;

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("delete from carrinho where id_compra = ?");

            comandoSQL.setInt(1, obj.getId());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em excluirCarrinho");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em excluirCarrinho");
        }

        return retorno;
    }

    public static boolean alterarCarrinho(Produto obj) {

        boolean retorno = false;

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE carrinho SET nome_produto_carrinho = ?, qtd_carrinho = ?, valor_produto_carrinho = ? WHERE id_compra = ?);");


            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setInt(2, obj.getQuantidade());
            comandoSQL.setDouble(3, obj.getValor());
            comandoSQL.setInt(4, obj.getId());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em alterarCarrinho");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return retorno;
    }

    public static boolean alterarEstoque() {

        boolean retorno = false;

        Connection conexao = null;

        Produto obj = new Produto();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produtos SET nome_produto = ?,"
                    + "quantidade = ?,valor = ? WHERE id_produto = ?");

            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setInt(2, obj.getQuantidade());
            comandoSQL.setDouble(3, obj.getValor());
            comandoSQL.setInt(4, obj.getId());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em alterarEstoque");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão em alterarEstoque");
        }

        return retorno;
    }

    public static String buscaNome(String id) {

        ArrayList<Produto> retorno = new ArrayList<>();
        
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/supplyStore";

            conexao = DriverManager.getConnection(url, "root", "root");

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT nome_produto FROM produtos where id_produto = ?;");

            comandoSQL.setInt(1, Integer.parseInt(id));

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    Produto obj = new Produto();

                    obj.setNome(rs.getString("nome_produto"));
                    
                    retorno.add(obj);

                }
            }

            }catch (ClassNotFoundException ex) {
            System.out.println("Erro no drive em buscarNome");
        }catch (SQLException ex) {
            System.out.println("Erro na conexão em buscarNome");
        }
        
            String nome = retorno.get(0).getNome();

            return nome;

        }

    }

