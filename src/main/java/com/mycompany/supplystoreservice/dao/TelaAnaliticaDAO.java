
package com.mycompany.supplystoreservice.dao;

import com.mycompany.supplystoreservice.model.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Manzano
 */
public class TelaAnaliticaDAO {
    
     public static ArrayList<Venda> consultarTodasVendas() {
        ArrayList<Venda> listFinal;
        listFinal = new ArrayList<>();
        Connection conexao;
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3308/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "SELECT * FROM vendas");

            //passo 4 executar o comando SQL 
            ResultSet listVendas = comandoSQL.executeQuery();
            if (listVendas != null) {

                while (listVendas.next()) {
                    Venda entidade = new Venda();

                    entidade.setId(listVendas.getInt("id"));
                    entidade.setNomeCliente(listVendas.getString("nome_cliente"));
                    entidade.setQuantidade(listVendas.getInt("quantidade"));
                    entidade.setData(listVendas.getDate("Data"));

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
}
