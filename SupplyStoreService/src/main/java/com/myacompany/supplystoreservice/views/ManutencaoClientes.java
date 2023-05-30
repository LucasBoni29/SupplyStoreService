/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.myacompany.supplystoreservice.views;

import com.mycompany.supplystoreservice.dao.ManutencaoClientesDAO;
import com.mycompany.supplystoreservice.utils.Validador;
import com.mycompany.supplystoreservice.model.Cliente;
import com.mycompany.supplystoreservice.utils.ToolCrud;
import com.mycompany.supplystoreservice.utils.TablesCriteria;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas.boni
 */
public final class ManutencaoClientes extends javax.swing.JPanel {
    
    private String acao;

    /**
     * Creates new form ManutencaoClientes
     */
    public ManutencaoClientes() {
        initComponents();
    }

    /**
     * Exibe mensagens do status do CRUD realizado!
     * @param tipoAcao Tipo da ação do CRUD realizada
     */
    private void exibirStatus(String tipoAcao){
        switch (tipoAcao) {
            case "INSERT":
                JOptionPane.showMessageDialog(null,
                        "Registro cadastrado com sucesso!",
                        "Cadastrar registro",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            case "UPDATE":
                JOptionPane.showMessageDialog(null,
                        "Registro alterado com sucesso!",
                        "Alterar registro",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            case "DELETE":
                JOptionPane.showMessageDialog(null,
                        "Registro excluído com sucesso!",
                        "Excluir registro",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }
    }

    /**
     * Método responsável passar as informações e cadastrar os clientes
     */
    private void cadastrar() {
        Cliente cliente = new Cliente();
        ToolCrud toolCrud = new ToolCrud();
        List<String> camposMascara = new ArrayList<>();
        
        cliente.setNome(txtNome.getText());
        camposMascara.add(ftfCpf.getText());
        cliente.setEndereco(txtEndereco.getText());
        camposMascara.add(ftfTelefone.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setSexo(String.valueOf(cbxSexo.getSelectedItem()));
        cliente.setEstadoCivil(String.valueOf(cbxEstadoCivil.getSelectedItem()));
        camposMascara.add(ftfDataNascimento.getText());
        
        camposMascara = toolCrud.removerMascarasCliente(camposMascara);
        
        cliente.setCpf(camposMascara.get(0));
        cliente.setTelefone(Integer.valueOf(camposMascara.get(1)));
        cliente.setDataNascimento(Integer.valueOf(camposMascara.get(2)));
        
        boolean registroExiste = ManutencaoClientesDAO.fncRegistroExiste(cliente.getCpf());
        
        if(registroExiste){
            JOptionPane.showMessageDialog(null,
                    "Registro já inserido na base de dados!", 
                    "Cadastrar registro", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            ManutencaoClientesDAO.salvar(cliente);
            acao = "INSERT";
            buscarValores();
        }
    }

    /**
     * Método responsável por buscar todos os registros da tabela e adicionar no JTable
     */
    private void buscarValores(){
        ArrayList<Cliente> listaClientes = ManutencaoClientesDAO.consultar();
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0);
        for (Cliente item : listaClientes) {
            modelo.addRow(new String[]{String.valueOf(item.getNome()),
                item.getCpf(), item.getEndereco(),
                String.valueOf(item.getTelefone()), item.getEmail(), item.getSexo(),
                item.getEstadoCivil(), String.valueOf(item.getDataNascimento())});
        }
        exibirStatus(acao);
        if(listaClientes.isEmpty()){
            JOptionPane.showMessageDialog(null, 
                    "Nenhum registro encontrado!", 
                    "Consultar registros", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método responsável por consultar os clientes através de filtros
     * @param listaFiltrada Lista com os parâmetros para o filtro
     */
    private void carregarValoresFiltrados(List<Cliente> listaFiltrada){
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setRowCount(0);
        for (Cliente item : listaFiltrada) {
            modelo.addRow(new String[]{String.valueOf(item.getNome()),
                item.getCpf(), item.getEndereco(),
                String.valueOf(item.getTelefone()), item.getEmail(), item.getSexo(),
                item.getEstadoCivil(), String.valueOf(item.getDataNascimento())});
        }
        if(listaFiltrada.isEmpty()){
            JOptionPane.showMessageDialog(null, 
                    "Nenhum registro encontrado!", 
                    "Filtrar registros", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método responsável por limpar os campos da tela
     */
    private void limparCampos(){
        acao = "";
        txtNome.setText("");
        ftfCpf.setText("");
        ftfCpf.setValue(null);
        txtEndereco.setText("");
        ftfTelefone.setText("");
        ftfTelefone.setValue(null);
        txtEmail.setText("");
        ftfDataNascimento.setText("");
        ftfDataNascimento.setValue(null);
        cbxSexo.setSelectedIndex(0);
        cbxEstadoCivil.setSelectedIndex(0);
    }

    /**
     * Método responsável por passar os valores para a entidade Clientes
     * @param entidade Entidade cliente
     * @param model Model da tabela que está sendo feita a operação
     * @param linhaSelecionada Linha do grid selecionada
     * @return entidade {@link Cliente}
     */
    private Cliente passarValores(Cliente entidade, DefaultTableModel model, int linhaSelecionada) {
        ToolCrud toolCrud = new ToolCrud();
        List<String> camposMascara = new ArrayList<>();
        
        // Passando valores da linha selecionada!
        entidade.setNome(model.getValueAt(linhaSelecionada, 0).toString());
        entidade.setCpf(model.getValueAt(linhaSelecionada, 1).toString());
        entidade.setEndereco(model.getValueAt(linhaSelecionada, 2).toString());
        entidade.setTelefone(Integer.valueOf(model.getValueAt(linhaSelecionada, 3).toString()));
        entidade.setEmail(model.getValueAt(linhaSelecionada, 4).toString());
        entidade.setSexo(model.getValueAt(linhaSelecionada, 5).toString());
        entidade.setEstadoCivil(model.getValueAt(linhaSelecionada, 6).toString());
        entidade.setDataNascimento(Integer.valueOf(model.getValueAt(linhaSelecionada, 7).toString()));
        
        // Colocando os valores alterados!
        entidade.setNome(txtNome.getText());
        camposMascara.add(ftfCpf.getValue().toString());
        entidade.setEndereco(txtEndereco.getText());
        camposMascara.add(ftfTelefone.getValue().toString());
        entidade.setEmail(txtEmail.getText());
        entidade.setSexo(String.valueOf(cbxSexo.getSelectedItem()));
        entidade.setEstadoCivil(String.valueOf(cbxEstadoCivil.getSelectedItem()));
        camposMascara.add(ftfDataNascimento.getValue().toString());
        
        //Removendo máscaras
        camposMascara = toolCrud.removerMascarasCliente(camposMascara);

        entidade.setCpf(camposMascara.get(0));
        entidade.setTelefone(Integer.valueOf(camposMascara.get(1)));
        entidade.setDataNascimento(Integer.valueOf(camposMascara.get(2)));
        
        return entidade;
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
        scpTableClientes = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblDataNascimento = new javax.swing.JLabel();
        ftfDataNascimento = new javax.swing.JFormattedTextField();
        cbxSexo = new javax.swing.JComboBox<>();
        lblSexo = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        cbxEstadoCivil = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        ftfTelefone = new javax.swing.JFormattedTextField();
        ftfCpf = new javax.swing.JFormattedTextField();
        btnFiltrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(773, 434));

        panBackground.setPreferredSize(new java.awt.Dimension(773, 434));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Endereço", "Telefone", "E-mail", "Sexo", "Estado civil", "Nascimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        tblClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblClientesKeyReleased(evt);
            }
        });
        scpTableClientes.setViewportView(tblClientes);

        lblNome.setText("Nome");

        txtNome.setName("Nome"); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        lblCpf.setText("CPF");

        lblEndereco.setText("Endereço");

        txtEndereco.setName("Endereço"); // NOI18N
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnderecoKeyTyped(evt);
            }
        });

        lblTelefone.setText("Telefone");

        lblEmail.setText("E-mail");

        txtEmail.setName("E-mail"); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        lblDataNascimento.setText("Data de nascimento");

        try {
            ftfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfDataNascimento.setName("Data de nascimento"); // NOI18N
        ftfDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfDataNascimentoActionPerformed(evt);
            }
        });

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        cbxSexo.setName("Sexo"); // NOI18N

        lblSexo.setText("Sexo");

        lblEstadoCivil.setText("Estado civil");

        cbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Separado", "Divorciado", "Viúvo" }));
        cbxEstadoCivil.setName("Estado civil"); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(255, 215, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(255, 215, 0));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 215, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(255, 215, 0));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelefone.setName("Telefone"); // NOI18N
        ftfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfTelefoneActionPerformed(evt);
            }
        });

        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpf.setName("CPF"); // NOI18N

        btnFiltrar.setBackground(new java.awt.Color(255, 215, 0));
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 215, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBackgroundLayout = new javax.swing.GroupLayout(panBackground);
        panBackground.setLayout(panBackgroundLayout);
        panBackgroundLayout.setHorizontalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBackgroundLayout.createSequentialGroup()
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addGap(139, 139, 139))
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(ftfTelefone)
                                .addGap(44, 44, 44)))
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                .addGap(198, 198, 198))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBackgroundLayout.createSequentialGroup()
                                .addComponent(txtEmail)
                                .addGap(33, 33, 33)))
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(ftfDataNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(lblDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addGap(24, 24, 24)))
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(cbxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(32, 32, 32))
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(lblSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(134, 134, 134))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBackgroundLayout.createSequentialGroup()
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(230, 230, 230))
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(txtNome)
                                .addGap(52, 52, 52)))
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(139, 139, 139))
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(221, 221, 221))
                            .addGroup(panBackgroundLayout.createSequentialGroup()
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBackgroundLayout.createSequentialGroup()
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scpTableClientes, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panBackgroundLayout.createSequentialGroup()
                                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panBackgroundLayout.createSequentialGroup()
                                        .addComponent(lblEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(91, 91, 91))
                                    .addComponent(cbxEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnFiltrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addGap(72, 72, 72)))
                        .addGap(18, 18, 18))))
        );
        panBackgroundLayout.setVerticalGroup(
            panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBackgroundLayout.createSequentialGroup()
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBackgroundLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(panBackgroundLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndereco)
                            .addComponent(ftfCpf))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail)
                    .addComponent(ftfDataNascimento)
                    .addComponent(ftfTelefone)
                    .addComponent(cbxSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEstadoCivil)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(scpTableClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void ftfDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfDataNascimentoActionPerformed

    /**
     * Método responsável por executar a ação do botão 'Cadastrar' ao ser clicado
     * @param evt Ação do evento
     */
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Validador validador = new Validador();
        validador.preechendoArrayList(panBackground);
        validador.proValidarCamposObrigatorios();
        validador.proValidarEmail(txtEmail);
        validador.proValidarData(ftfDataNascimento);
        
        
        if(validador.fncTemMensagem()){
            validador.proMostrarLog();
        }else{
            cadastrar();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    /**
     * Método responsável por executar a ação do botão 'Buscar' ao ser clicado
     * @param evt Ação do evento
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        acao = "";
        buscarValores();
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Método responsável por executar a ação do botão 'Excluir' ao ser clicado
     * @param evt Ação do evento
     */
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblClientes.getSelectedRow() != -1) {
            ManutencaoClientesDAO.excluir(tblClientes);
            acao = "DELETE";
            limparCampos();
            buscarValores();
        }else{
            JOptionPane.showMessageDialog(null, 
                   "Selecione uma linha para efetuar a exclusão!", 
                    "Exclusão de registro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * Método responsável por executar a ação do botão 'Atualizar' ao ser clicado
     * @param evt Ação do evento
     */
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        Validador validador = new Validador();
        validador.preechendoArrayList(panBackground);
        
        if(tblClientes.getSelectedRow() != -1){
            validador.proValidarCamposObrigatorios();
            
            if(validador.fncTemMensagem()){
                validador.proMostrarLog();
            }else{
                Cliente entidade = new Cliente();

                int linhaSelecionada = tblClientes.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
                
                entidade = passarValores(entidade, model, linhaSelecionada);
                
                ManutencaoClientesDAO.alterar(entidade, tblClientes);
                acao = "UPDATE";
                buscarValores();
            }
        }else{
            JOptionPane.showMessageDialog(null, 
                    "Selecione uma linha para efetuar a alteração!", 
                    "Alterar registro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    /**
     * Método responsável por capturar a ação do botõa do teclado no JTable clientes
     * @param evt Ação do evento
     */
    private void tblClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClientesKeyReleased
        TablesCriteria toolTables = new TablesCriteria();
        
        toolTables.preechendoArrayList(panBackground);
        toolTables.proSelecionarItensTabelaCliente(tblClientes);
    }//GEN-LAST:event_tblClientesKeyReleased

    /**
     * Método responsável por capturar a ação do clique do mouse no JTable clientes
     * @param evt
     */
    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        TablesCriteria toolTables = new TablesCriteria();
        
        toolTables.preechendoArrayList(panBackground);
        toolTables.proSelecionarItensTabelaCliente(tblClientes);
    }//GEN-LAST:event_tblClientesMouseClicked

    private void ftfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfTelefoneActionPerformed

    /**
     * Método responsável por executar a ação do botão 'Filtrar' ao ser clicado
     * @param evt Ação do evento
     */
    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        Cliente entidade = new Cliente();
        ToolCrud toolCrud = new ToolCrud();
        List<String> campoMascara = new ArrayList<>();
        
        if(!txtNome.getText().equals("") && ftfCpf.getValue() == null){
            txtNome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            ftfCpf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            entidade.setNome(txtNome.getText());
            
            List<Cliente> listaFiltrada = ManutencaoClientesDAO.filtrar(entidade);
            carregarValoresFiltrados(listaFiltrada);
        }else if(ftfCpf.getValue() != null && txtNome.getText().equals("")){
            
            ftfCpf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            txtNome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            campoMascara.add(ftfCpf.getValue().toString());
            campoMascara = toolCrud.removerMascarasCliente(campoMascara);
            entidade.setCpf(campoMascara.get(0));
            
            List<Cliente> listaFiltrada = ManutencaoClientesDAO.filtrar(entidade);
            carregarValoresFiltrados(listaFiltrada);
        }else if(!txtNome.getText().equals("") && ftfCpf.getValue() != null){
            
            txtNome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            ftfCpf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            entidade.setNome(txtNome.getText());
            campoMascara.add(ftfCpf.getValue().toString());
            campoMascara = toolCrud.removerMascarasCliente(campoMascara);
            entidade.setCpf(campoMascara.get(0));
            
           List<Cliente> listaFiltrada = ManutencaoClientesDAO.filtrar(entidade);
           carregarValoresFiltrados(listaFiltrada);
        }else{
            JOptionPane.showMessageDialog(null, 
                    "Preencha pelo menos um dos campos", 
                    "Filtro", 
                    JOptionPane.INFORMATION_MESSAGE);
            txtNome.setBorder(BorderFactory.createLineBorder(Color.RED));
            ftfCpf.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    /**
     * Método responsável por executar a ação do botão 'Cancelar' ao ser clicado
     * @param evt Ação do evento
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método responsável validar o tamanho máximo do campo 'Nome'
     * @param evt Ação do evento
     */
    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        // TODO add your handling code here:
        
        if(txtNome.getText().length() >= 100){
            evt.consume();
            JOptionPane.showMessageDialog(null,
                    "Máximo de 100 caracteres atingido!",
                    "Validação tamanho!", 
                    JOptionPane.INFORMATION_MESSAGE);
            txtNome.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            txtNome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    /**
     * Método responsável validar o tamanho máximo do campo 'Endereço'
     * @param evt Ação do evento
     */
    private void txtEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoKeyTyped
        // TODO add your handling code here:
        if(txtEndereco.getText().length() >= 200){
            evt.consume();
            JOptionPane.showMessageDialog(null,
                    "Máximo de 200 caracteres atingido!",
                    "Validação tamanho!", 
                    JOptionPane.INFORMATION_MESSAGE);
            txtEndereco.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            txtNome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }//GEN-LAST:event_txtEnderecoKeyTyped

    /**
     * Método responsável validar o tamanho máximo do campo 'E-mail'
     * @param evt Ação do evento
     */
    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
        if(txtEmail.getText().length() >= 200){
            evt.consume();
            JOptionPane.showMessageDialog(null,
                    "Máximo de 100 caracteres atingido!",
                    "Validação tamanho!", 
                    JOptionPane.INFORMATION_MESSAGE);
            txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
        }else{
            txtEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }//GEN-LAST:event_txtEmailKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cbxEstadoCivil;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfDataNascimento;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel panBackground;
    private javax.swing.JScrollPane scpTableClientes;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
    
}
