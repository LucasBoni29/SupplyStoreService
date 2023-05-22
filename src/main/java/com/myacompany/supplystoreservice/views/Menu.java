/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.myacompany.supplystoreservice.views;

import com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme;
import com.myacompany.supplystoreservice.views.ManutencaoClientes;
import com.myacompany.supplystoreservice.views.MenuSobreNos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;

/**
 *
 * @author lucas.boni
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form CadastroClientes
     */
    public Menu() {
        initComponents();
        initSystelesComponents();
        setDate();
        initHome();
    }
    
    private void initSystelesComponents() {
        lblMensagem.putClientProperty( "FlatLaf.style" , "fonte: 14 $light.font" );
        lblMensagem.setForeground(Color.black);
        lblTituloMenu.putClientProperty("FlatLaf.style", "fonte: 24 $h3.regular.font");
        lblTituloMenu.setForeground(Color.white);
        lblData.putClientProperty("FlatLaf.style", "fonte: 24 $h3.regular.font");
        lblData.setForeground(Color.white);
        lblNomeLoja.putClientProperty("FlatLaf.style", "fonte: 24 $h1.regular.font");
        lblNomeLoja.setForeground(Color.white);
    }
    
    private void setDate() {
        LocalDate hoje = LocalDate.now();
        Locale localidadeBrasileira = new  Locale("pt", "BR");
        lblData.setText(hoje.format(DateTimeFormatter.ofPattern("'Data de hoje: ' EEEE dd 'de' MMMM 'de' yyyy", localidadeBrasileira)));
    }
    
    private void initHome(){
        //TODO: Fazer aparecer a tela principal ao abrir a tela, aqui!
    }
    
    private void showJPanel(JPanel panManutencaoClientes){
        panManutencaoClientes.setSize(773, 434);
        panManutencaoClientes.setLocation(0,0);
        
        panConteudoMenu.removeAll();
        panConteudoMenu.add(panManutencaoClientes, BorderLayout.CENTER);
        panConteudoMenu.revalidate();
        panConteudoMenu.repaint();
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
        panMenus = new javax.swing.JPanel();
        lblNomeLoja = new javax.swing.JLabel();
        spLinha = new javax.swing.JSeparator();
        btnHome = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        panTituloMenu = new javax.swing.JPanel();
        lblTituloMenu = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        panConteudoMenu = new javax.swing.JPanel();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panBackground.setBackground(new java.awt.Color(255, 255, 255));

        panMenus.setBackground(new java.awt.Color(86, 86, 86));
        panMenus.setPreferredSize(new java.awt.Dimension(270, 640));

        lblNomeLoja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeLoja.setText("SupplyStored");

        btnHome.setBackground(new java.awt.Color(255, 215, 0));
        btnHome.setText("Home");
        btnHome.setBorderPainted(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(255, 215, 0));
        btnCliente.setText("Manutenção de clientes");
        btnCliente.setBorderPainted(false);
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCliente.setIconTextGap(13);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnProduto.setBackground(new java.awt.Color(255, 215, 0));
        btnProduto.setText("Manutenção de produtos");
        btnProduto.setBorderPainted(false);
        btnProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProduto.setIconTextGap(13);
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMenusLayout = new javax.swing.GroupLayout(panMenus);
        panMenus.setLayout(panMenusLayout);
        panMenusLayout.setHorizontalGroup(
            panMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenusLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblNomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panMenusLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(spLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panMenusLayout.setVerticalGroup(
            panMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenusLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblNomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(spLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMenusLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panMenusLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        panTituloMenu.setBackground(new java.awt.Color(169, 169, 169));
        panTituloMenu.setPreferredSize(new java.awt.Dimension(750, 150));

        lblTituloMenu.setText("Tela Principal");

        lblData.setText("Data de hoje: {dayname} {daytime} de {month} de {year}");

        javax.swing.GroupLayout panTituloMenuLayout = new javax.swing.GroupLayout(panTituloMenu);
        panTituloMenu.setLayout(panTituloMenuLayout);
        panTituloMenuLayout.setHorizontalGroup(
            panTituloMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTituloMenuLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(panTituloMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panTituloMenuLayout.setVerticalGroup(
            panTituloMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTituloMenuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblTituloMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panConteudoMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panConteudoMenuLayout = new javax.swing.GroupLayout(panConteudoMenu);
        panConteudoMenu.setLayout(panConteudoMenuLayout);
        panConteudoMenuLayout.setHorizontalGroup(
            panConteudoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        panConteudoMenuLayout.setVerticalGroup(
            panConteudoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        lblMensagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMensagem.setText("SupplyStored");

        javax.swing.GroupLayout panBackgroundLayout = new javax.swing.GroupLayout(panBackground);
        panBackground.setLayout(panBackgroundLayout);
        panBackgroundLayout.setHorizontalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(panTituloMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE))
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addComponent(panMenus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panConteudoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panBackgroundLayout.setVerticalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panTituloMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panConteudoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panMenus, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        showJPanel(new MenuSobreNos());
        lblTituloMenu.setText("Tela Principal");
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
        showJPanel(new ManutencaoClientes());
        lblTituloMenu.setText("Manutenção de Clientes");
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        // TODO add your handling code here:
        showJPanel(new ManutencaoProdutos());
        lblTituloMenu.setText("Manutenção de Produtos");
    }//GEN-LAST:event_btnProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /**
         * Colocando design da dependência FlatLight
         */
        FlatMaterialDesignDarkIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnProduto;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblNomeLoja;
    private javax.swing.JLabel lblTituloMenu;
    private javax.swing.JPanel panBackground;
    private javax.swing.JPanel panConteudoMenu;
    private javax.swing.JPanel panMenus;
    private javax.swing.JPanel panTituloMenu;
    private javax.swing.JSeparator spLinha;
    // End of variables declaration//GEN-END:variables

   
}
