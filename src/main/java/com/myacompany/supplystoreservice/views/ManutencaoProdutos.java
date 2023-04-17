/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.myacompany.supplystoreservice.views;

import com.mycompany.supplystoreservice.Validador;
import com.mycompany.supplystoreservice.menu.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author gusta
 */
public class ManutencaoProdutos extends javax.swing.JPanel {

    /**
     * Creates new form ProdutoPane
     */
    public ManutencaoProdutos() {
        initComponents();
    }

    public void comprar() {

        Produto produtos = new Produto();

<<<<<<< Updated upstream:src/main/java/com/myacompany/supplystoreservice/views/ManutencaoProdutos.java
        DefaultTableModel dtmCarrinho = (DefaultTableModel) tblCarrinho.getModel();
=======
        DefaultTableModel dtmCarrinho = new DefaultTableModel();
        dtmCarrinho.addColumn("Id");
        dtmCarrinho.addColumn("Nome");
        dtmCarrinho.addColumn("Quantidade");
        dtmCarrinho.addColumn("Valor");

        //Defina sua estrutura com a estrutura tmClientes;
        tblCarrinho.setModel(dtmCarrinho );

        //Limpo a tabela, excluindo todas as linhas para depois mostrar os dados novamente
        //dtmCarrinho .setRowCount(0);
        
>>>>>>> Stashed changes:src/main/java/com/mycompany/supplystoreservice/menu/ManutencaoProdutos.java
        
        produtos.setId(cbxProduto.getSelectedIndex());
        produtos.setNome(String.valueOf(cbxProduto.getSelectedItem()));
        produtos.setQuantidade(pinQuantidade.getComponentCount());
        
        String searchTerm = "valorProcurado";
        int searchColumn = 3; // Coluna onde o valor deve ser procurado

        TableModel model = tblEstoque.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            Object value = model.getValueAt(row, searchColumn);
            if (cbxProduto.getSelectedIndex() == row) {
                double valor = (double) model.getValueAt(row, searchColumn);
                break;
                }
            if (searchTerm.equals(value.toString())) {
                // Valor encontrado na linha row, coluna searchColumn
                // Faça o que precisar aqui
                break;
            }
        }
        

        Object[] dados = {produtos.getId(), produtos.getNome(), produtos.getQuantidade()};
        
        dtmCarrinho.addRow(dados);


        //Defino o tamanho para cada coluna
        //tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50); //ID
        //tblClientes.getColumnModel().getColumn(1).setPreferredWidth(300); // Nome
        //tblClientes.getColumnModel().getColumn(2).setPreferredWidth(100); //CPF
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBackground = new javax.swing.JPanel();
        lblCarrinho = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        scpCarrinho = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        lblProduto = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox<>();
        lblQuantidade = new javax.swing.JLabel();
        pinQuantidade = new javax.swing.JSpinner();
        btnComprar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblEstoque = new javax.swing.JLabel();
        scpValor = new javax.swing.JScrollPane();
        tblValorTotal = new javax.swing.JTable();
        scpEstoque = new javax.swing.JScrollPane();
        tblEstoque = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(773, 434));

        panBackground.setPreferredSize(new java.awt.Dimension(773, 434));

        lblCarrinho.setText("Carrinho");

        btnExcluir.setText("Excluir");
        btnExcluir.setName("Excluir"); // NOI18N

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpCarrinho.setViewportView(tblCarrinho);

        lblProduto.setText("Produto:");

        cbxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100% Whey Refil 900 g", "Creatina 300 g", "Coqueteleira 700 ml", "Power Protein Bar 90 g" }));
        cbxProduto.setName("Produto"); // NOI18N
        cbxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Quantidade:");

        pinQuantidade.setName("Quantidade"); // NOI18N

        btnComprar.setText("Comprar");
        btnComprar.setName("Comprar"); // NOI18N
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setName("Cancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblEstoque.setText("Estoque");

        tblValorTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpValor.setViewportView(tblValorTotal);

        tblEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "100% Whey Refil 900 g",  new Integer(20),  new Double(149.99)},
                { new Integer(2), "Creatina 300 g",  new Integer(10),  new Double(115.99)},
                { new Integer(3), "Coqueteleira 700 ml",  new Integer(35),  new Double(29.99)},
                { new Integer(4), "Power Protein Bar 90 g",  new Integer(20),  new Double(99.99)}
            },
            new String [] {
                "Id", "Nome", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEstoque.setName(""); // NOI18N
        scpEstoque.setViewportView(tblEstoque);

        btnAlterar.setText("Alterar");
        btnAlterar.setName("Alterar"); // NOI18N

        javax.swing.GroupLayout panBackgroundLayout = new javax.swing.GroupLayout(panBackground);
        panBackground.setLayout(panBackgroundLayout);
        panBackgroundLayout.setHorizontalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panBackgroundLayout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pinQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnComprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(lblEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpEstoque)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBackgroundLayout.createSequentialGroup()
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(scpCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(lblCarrinho)
                                .addGap(258, 258, 258)))
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBackgroundLayout.createSequentialGroup()
                                .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scpValor, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panBackgroundLayout.setVerticalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto)
                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade)
                    .addComponent(pinQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(lblEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlterar)
                        .addComponent(btnExcluir))
                    .addComponent(lblCarrinho, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scpCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpValor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProdutoActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        Validador validador = new Validador();
        validador.preechendoArrayList(panBackground);
        validador.proValidarCamposObrigatorios();
        
        if(validador.fncTemMensagem()){
            validador.proMostrarLog();
        }else{
            comprar();
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cbxProduto;
    private javax.swing.JLabel lblCarrinho;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JPanel panBackground;
    private javax.swing.JSpinner pinQuantidade;
    private javax.swing.JScrollPane scpCarrinho;
    private javax.swing.JScrollPane scpEstoque;
    private javax.swing.JScrollPane scpValor;
    private javax.swing.JTable tblCarrinho;
    private javax.swing.JTable tblEstoque;
    private javax.swing.JTable tblValorTotal;
    // End of variables declaration//GEN-END:variables
}
