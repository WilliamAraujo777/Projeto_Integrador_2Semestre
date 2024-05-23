package view;

import DAO.ClienteDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.beans.Cliente;
import model.beans.Endereco;
import util.Validador;

public class CadastroCliente extends JDialog {

    private List<JTextField> camposDeEntrada;

    Cliente alterarCliente = null;
//    Endereco alterarEndereco = null;

    public CadastroCliente(JFrame parent) {
        super(parent, true);
        initComponents();
        apenasNumeros(fieldNumero);
        this.getContentPane().setBackground(new Color(255, 255, 255));
    }

    public CadastroCliente(Cliente obj,JFrame parent) {
        super(parent, true);
        initComponents();
        this.getContentPane().setBackground(new Color(255, 255, 255));

        alterarCliente = obj;

        fieldNome.setText(String.valueOf(alterarCliente.getNomeCliente()));
        fieldCPF.setText(String.valueOf(alterarCliente.getCpfCliente()));
        fieldCPF.setEditable(false);
        cbSexo.setSelectedItem(alterarCliente.getSexoCliente());
        fieldNascimento.setText(String.valueOf(alterarCliente.getDtNascimento()));
        fieldNumero.setText(String.valueOf(alterarCliente.getNumeroCliente()));
        fieldEmail.setText(String.valueOf(alterarCliente.getEmailCliente()));

        fieldLogradouro.setText(String.valueOf(alterarCliente.getEndereco().getLogradouro()));
        fieldCEP.setText(String.valueOf(alterarCliente.getEndereco().getCep()));
        fieldBairro.setText(String.valueOf(alterarCliente.getEndereco().getBairro()));
        fieldNumero.setText(String.valueOf(alterarCliente.getEndereco().getNumero()));
        fieldCidade.setText(String.valueOf(alterarCliente.getEndereco().getCidade()));
        cbEstado.setSelectedItem(alterarCliente.getEndereco().getComplemento());
        fieldComplemento.setText(String.valueOf(alterarCliente.getEndereco().getComplemento()));

        btnAdicionar.setText("Editar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGap = new javax.swing.JPanel();
        panelCliente = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        labelCPF = new javax.swing.JLabel();
        labelRG = new javax.swing.JLabel();
        labelNascimento = new javax.swing.JLabel();
        labelContato = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        fieldEmail = new javax.swing.JTextField();
        cbSexo = new javax.swing.JComboBox<>();
        fieldNascimento = new javax.swing.JFormattedTextField();
        fieldCPF = new javax.swing.JFormattedTextField();
        fieldContato = new javax.swing.JFormattedTextField();
        panelEndereco = new javax.swing.JPanel();
        labelNome1 = new javax.swing.JLabel();
        fieldLogradouro = new javax.swing.JTextField();
        labelCEP = new javax.swing.JLabel();
        labelRG1 = new javax.swing.JLabel();
        fieldBairro = new javax.swing.JTextField();
        labelNascimento1 = new javax.swing.JLabel();
        fieldNumero = new javax.swing.JTextField();
        labelContato1 = new javax.swing.JLabel();
        fieldCidade = new javax.swing.JTextField();
        labelEmail1 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        labelContato2 = new javax.swing.JLabel();
        fieldComplemento = new javax.swing.JTextField();
        fieldCEP = new javax.swing.JFormattedTextField();
        btnAdicionar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        panelGap.setBackground(new java.awt.Color(204, 204, 204));
        panelGap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelGap.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelGapLayout = new javax.swing.GroupLayout(panelGap);
        panelGap.setLayout(panelGapLayout);
        panelGapLayout.setHorizontalGroup(
            panelGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGapLayout.setVerticalGroup(
            panelGapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelCliente.setBackground(new java.awt.Color(255, 255, 255));
        panelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais\n"));

        labelNome.setText("Nome");

        labelCPF.setText("CPF");

        labelRG.setText("Sexo");

        labelNascimento.setText("Data de nascimento");

        labelContato.setText("Telefone p/ contato");

        labelEmail.setText("Email de contato");

        fieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldEmailActionPerformed(evt);
            }
        });

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        try {
            fieldNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            fieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            fieldContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNome)
                                    .addComponent(labelCPF))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addComponent(labelRG)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(fieldNome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addComponent(labelNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE))
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addComponent(fieldNascimento)
                                .addGap(6, 6, 6)))
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addComponent(labelContato)
                                .addGap(81, 81, 81))
                            .addComponent(fieldContato)))
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addComponent(labelEmail)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldEmail))
                .addContainerGap())
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPF)
                    .addComponent(labelRG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNascimento)
                    .addComponent(labelContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelEndereco.setBackground(new java.awt.Color(255, 255, 255));
        panelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereco"));

        labelNome1.setText("Logradouro");

        labelCEP.setText("CEP");

        labelRG1.setText("Bairro");

        labelNascimento1.setText("Número");

        labelContato1.setText("Cidade");

        labelEmail1.setText("UF");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        labelContato2.setText("Complemento");

        try {
            fieldCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnderecoLayout.createSequentialGroup()
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldCEP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEnderecoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(labelCEP)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRG1)
                            .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fieldLogradouro)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 185, Short.MAX_VALUE)
                                .addComponent(fieldNumero, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelNascimento1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(labelEmail1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelContato1)
                                .addComponent(fieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelContato2)
                                .addComponent(fieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(labelNome1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(labelContato2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(fieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCEP)
                            .addComponent(labelRG1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNascimento1)
                            .addComponent(labelContato1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelEmail1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldEmailActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        fieldNome.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldCPF.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldContato.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldEmail.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldLogradouro.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldBairro.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldCidade.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldCEP.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldNumero.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        fieldComplemento.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));

        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        ClienteDAO DAO = new ClienteDAO();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        Validador valida = new Validador();

        try {
            fieldNome = (JTextField) valida.validaTextField(fieldNome);
            fieldCPF = (JFormattedTextField) valida.validaTextField(fieldCPF);
            fieldNascimento = (JFormattedTextField) valida.validaTextField(fieldNascimento);
            fieldContato = (JFormattedTextField) valida.validaTextField(fieldContato);
            fieldEmail = (JTextField) valida.validaTextField(fieldEmail);
            fieldLogradouro = (JTextField) valida.validaTextField(fieldLogradouro);
            fieldCEP = (JFormattedTextField) valida.validaTextField(fieldCEP);
            fieldBairro = (JTextField) valida.validaTextField(fieldBairro);
            fieldNumero = (JTextField) valida.validaTextField(fieldNumero);
            fieldCidade = (JTextField) valida.validaTextField(fieldCidade);
            fieldComplemento = (JTextField) valida.validaTextField(fieldComplemento);

            cliente.setNomeCliente(fieldNome.getText());
            cliente.setCpfCliente(fieldCPF.getText().replace("-", ""));
            cliente.setEmailCliente(fieldEmail.getText());
            cliente.setNumeroCliente(fieldContato.getText().replaceAll("[()-]", ""));
            cliente.setSexoCliente(cbSexo.getSelectedItem().toString().charAt(0));
            cliente.setDtNascimento(formatter.parse(fieldNascimento.getText().replace("/", "-")));

            endereco.setLogradouro(fieldLogradouro.getText());
            endereco.setCep(fieldCEP.getText().replace("-", ""));
            endereco.setBairro(fieldBairro.getText());
            endereco.setNumero(fieldNumero.getText());
            endereco.setCidade(fieldCidade.getText());
            endereco.setEstado(cbEstado.getSelectedItem().toString());
            endereco.setComplemento(fieldComplemento.getText());

            cliente.setEndereco(endereco);

            boolean funcionou = DAO.salvarCliente(cliente);

            if (funcionou == true) {
                JOptionPane.showMessageDialog(fieldComplemento, "Cadastro Realizado com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");

            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(fieldComplemento, "Data de nascimento inválida");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(fieldComplemento, "Prrencha todos os campos obrigatórios!");
        }

        this.dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        inicializarListaCamposDeEntrada();
        obterCamposDeEntradaDoContainer(panelEndereco);
        obterCamposDeEntradaDoContainer(panelCliente);
        limparCamposDeTexto();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void apenasNumeros(JTextField input) {

        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                String value = input.getText();
                int l = value.length();
                if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
                    input.setEditable(true);
                } else {
                    input.setEditable(false);
                }
            }
        });

    }

    private void inicializarListaCamposDeEntrada() {
        camposDeEntrada = new ArrayList<>();
    }

    private void obterCamposDeEntradaDoContainer(Container container) {
        Component[] componentes = container.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField) {
                camposDeEntrada.add((JTextField) componente);
            } else if (componente instanceof Container) {
                obterCamposDeEntradaDoContainer((Container) componente);
            }
        }
    }

    private void limparCamposDeTexto() {
        for (JTextField campo : camposDeEntrada) {
            campo.setText(""); // Limpa o texto do campo
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JTextField fieldBairro;
    private javax.swing.JFormattedTextField fieldCEP;
    private javax.swing.JFormattedTextField fieldCPF;
    private javax.swing.JTextField fieldCidade;
    private javax.swing.JTextField fieldComplemento;
    private javax.swing.JFormattedTextField fieldContato;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldLogradouro;
    private javax.swing.JFormattedTextField fieldNascimento;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldNumero;
    private javax.swing.JLabel labelCEP;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelContato;
    private javax.swing.JLabel labelContato1;
    private javax.swing.JLabel labelContato2;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEmail1;
    private javax.swing.JLabel labelNascimento;
    private javax.swing.JLabel labelNascimento1;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNome1;
    private javax.swing.JLabel labelRG;
    private javax.swing.JLabel labelRG1;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JPanel panelGap;
    // End of variables declaration//GEN-END:variables
}
