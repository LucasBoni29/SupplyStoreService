
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
public class TelaSinteticaDAO {
    
     public static ArrayList<Venda> consultarTodasVendas(String data) {
        ArrayList<Venda> listFinal;
        listFinal = new ArrayList<>();
        Connection conexao;
        try {
            // passo 1 carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //passso 2 abrir a conexao 
            String url = "jdbc:mysql://localhost:3306/supplyStore";
            
            conexao = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "SELECT * FROM vendas WHERE data_venda = ?");
            
            comandoSQL.setString(1, data);

            //passo 4 executar o comando SQL 
            ResultSet listVendas = comandoSQL.executeQuery();
            if (listVendas != null) {
                while (listVendas.next()) {
                    Venda entidade = new Venda();

                    entidade.setId(listVendas.getString("id_venda"));
                    entidade.setNomeCliente(listVendas.getString("id_cliente"));
                    entidade.setProduto(listVendas.getString("id_produto"));
                    entidade.setQuantidade(listVendas.getString("quantidade"));
                    entidade.setData(listVendas.getString("data_venda"));

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