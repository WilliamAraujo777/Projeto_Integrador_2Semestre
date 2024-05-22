/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panels;

import DAO.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.beans.*;
/**
 *
 * @author William
 */
public class TelaVendas extends javax.swing.JPanel {
    
    public boolean vendaEmAndamento = false;
    
    Produto produto;
    Cliente cliente;
    Venda venda;
    VendaDescricao venda_desc;
    
 
    public TelaVendas() {
        initComponents();
        atualizaTela();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProdutos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        pnlClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnAdicionaProduto = new javax.swing.JButton();
        btnAdicionaCliente = new javax.swing.JButton();
        cbTipoPesquisa = new javax.swing.JComboBox<>();
        cbTipoPesquisaClientes = new javax.swing.JComboBox<>();
        fieldPesquisaProduto = new javax.swing.JTextField();
        fieldPesquisaCliente = new javax.swing.JTextField();
        btnPesquisaProduto = new javax.swing.JButton();
        btnPesquisaCliente = new javax.swing.JButton();
        pnlCarrinho = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        pnlValor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblUsuarioSelecionado = new javax.swing.JLabel();
        btnFinalizaCompra = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();
        pnlDesconto1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAplicaDesconto1 = new javax.swing.JButton();
        btnAplicaDesconto2 = new javax.swing.JButton();
        fieldDesconto = new javax.swing.JTextField();
        checkSemCadastro = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(943, 528));
        setLayout(null);

        pnlProdutos.setBackground(new java.awt.Color(255, 255, 255));

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome Produto", "Quantidade", "Preco"
            }
        ));
        jScrollPane2.setViewportView(tblProdutos);

        javax.swing.GroupLayout pnlProdutosLayout = new javax.swing.GroupLayout(pnlProdutos);
        pnlProdutos.setLayout(pnlProdutosLayout);
        pnlProdutosLayout.setHorizontalGroup(
            pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );
        pnlProdutosLayout.setVerticalGroup(
            pnlProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );

        add(pnlProdutos);
        pnlProdutos.setBounds(6, 0, 453, 225);

        pnlClientes.setBackground(new java.awt.Color(255, 255, 255));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Aniversário"
            }
        ));
        jScrollPane3.setViewportView(tblClientes);

        javax.swing.GroupLayout pnlClientesLayout = new javax.swing.GroupLayout(pnlClientes);
        pnlClientes.setLayout(pnlClientesLayout);
        pnlClientesLayout.setHorizontalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );
        pnlClientesLayout.setVerticalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );

        add(pnlClientes);
        pnlClientes.setBounds(6, 266, 453, 134);

        btnAdicionaProduto.setText("Adicionar >>");
        btnAdicionaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaProdutoActionPerformed(evt);
            }
        });
        add(btnAdicionaProduto);
        btnAdicionaProduto.setBounds(360, 230, 100, 23);

        btnAdicionaCliente.setText("Selecionar");
        btnAdicionaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaClienteActionPerformed(evt);
            }
        });
        add(btnAdicionaCliente);
        btnAdicionaCliente.setBounds(360, 410, 84, 23);

        cbTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nome" }));
        add(cbTipoPesquisa);
        cbTipoPesquisa.setBounds(6, 231, 73, 22);

        cbTipoPesquisaClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF", "Nome" }));
        add(cbTipoPesquisaClientes);
        cbTipoPesquisaClientes.setBounds(6, 406, 72, 22);
        add(fieldPesquisaProduto);
        fieldPesquisaProduto.setBounds(85, 231, 150, 22);
        add(fieldPesquisaCliente);
        fieldPesquisaCliente.setBounds(84, 406, 148, 22);

        btnPesquisaProduto.setText("Buscar");
        add(btnPesquisaProduto);
        btnPesquisaProduto.setBounds(241, 231, 72, 23);

        btnPesquisaCliente.setText("Buscar");
        add(btnPesquisaCliente);
        btnPesquisaCliente.setBounds(238, 406, 72, 23);

        pnlCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        pnlCarrinho.setPreferredSize(new java.awt.Dimension(472, 450));

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Quantidade", "Preco Unidade", "Preco Total"
            }
        ));
        jScrollPane1.setViewportView(tblCarrinho);

        pnlValor.setBackground(new java.awt.Color(255, 255, 255));
        pnlValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Valor Total da Compra");

        fieldTotal.setEnabled(false);

        jLabel3.setText("Usuario Selecionado:");

        lblUsuarioSelecionado.setText("--");

        javax.swing.GroupLayout pnlValorLayout = new javax.swing.GroupLayout(pnlValor);
        pnlValor.setLayout(pnlValorLayout);
        pnlValorLayout.setHorizontalGroup(
            pnlValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuarioSelecionado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlValorLayout.setVerticalGroup(
            pnlValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblUsuarioSelecionado))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout pnlCarrinhoLayout = new javax.swing.GroupLayout(pnlCarrinho);
        pnlCarrinho.setLayout(pnlCarrinhoLayout);
        pnlCarrinhoLayout.setHorizontalGroup(
            pnlCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(pnlValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCarrinhoLayout.setVerticalGroup(
            pnlCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        add(pnlCarrinho);
        pnlCarrinho.setBounds(465, 0, 472, 410);

        btnFinalizaCompra.setText("Finalizar Compra");
        btnFinalizaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaCompraActionPerformed(evt);
            }
        });
        add(btnFinalizaCompra);
        btnFinalizaCompra.setBounds(600, 450, 330, 30);

        btnElimina.setText("<< Eliminar");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });
        add(btnElimina);
        btnElimina.setBounds(470, 410, 100, 23);

        pnlDesconto1.setBackground(new java.awt.Color(255, 255, 255));
        pnlDesconto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Desconto (%)");

        btnAplicaDesconto1.setText("Retirar");

        btnAplicaDesconto2.setText("Aplicar");
        btnAplicaDesconto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicaDesconto2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDesconto1Layout = new javax.swing.GroupLayout(pnlDesconto1);
        pnlDesconto1.setLayout(pnlDesconto1Layout);
        pnlDesconto1Layout.setHorizontalGroup(
            pnlDesconto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesconto1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnAplicaDesconto2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAplicaDesconto1)
                .addContainerGap())
        );
        pnlDesconto1Layout.setVerticalGroup(
            pnlDesconto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesconto1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlDesconto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnAplicaDesconto2)
                    .addComponent(btnAplicaDesconto1)
                    .addComponent(fieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnlDesconto1);
        pnlDesconto1.setBounds(599, 410, 330, 37);

        checkSemCadastro.setText("Sem Cadastro");
        checkSemCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSemCadastroActionPerformed(evt);
            }
        });
        add(checkSemCadastro);
        checkSemCadastro.setBounds(10, 440, 100, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaProdutoActionPerformed
        int linha = tblProdutos.getSelectedRow();

        if (linha != -1) {
            // Obtenha o modelo da tabela para acessar os dados da linha selecionada
            TableModel produtos = tblProdutos.getModel();
            boolean controle = true;

            int idProduto       = Integer.parseInt(produtos.getValueAt(linha, 0).toString());
            String nomeProduto  = produtos.getValueAt(linha, 1).toString();
            int qtdProduto      = Integer.parseInt(produtos.getValueAt(linha, 2).toString());
            double precoProduto = Double.parseDouble(produtos.getValueAt(linha, 3).toString());

            while (controle) {
                try {
                    // Solicita a entrada do usuário
                    String input = JOptionPane.showInputDialog(this, "Insira a quantidade");

                    if (input == null) {
                        JOptionPane.showMessageDialog(this, "Entrada cancelada.");
                        break; // Sai do loop se a entrada for cancelada
                    }

                    int qtdSelecionada = Integer.parseInt(input);

                    if (qtdSelecionada <= 0) {
                        JOptionPane.showMessageDialog(this, "Por favor, insira uma quantidade válida.");
                    } else if (qtdSelecionada <= qtdProduto) {
                        controle = false;//sai do loop
                        addProdutoCarrinho(idProduto, nomeProduto, precoProduto, qtdSelecionada);
                        atualizaQtdProduto(linha, qtdProduto, qtdSelecionada);
                        atualizaPrecoTotal();
                    } else {
                        JOptionPane.showMessageDialog(this, "Você inseriu mais do que consta no estoque.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(this, "Entrada cancelada.");
                    break; // Sai do loop se a entrada for cancelada
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum produto selecionado.");
        }
    }//GEN-LAST:event_btnAdicionaProdutoActionPerformed

    private void btnAdicionaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaClienteActionPerformed
         int linha = tblClientes.getSelectedRow();

         if (linha != -1) {
             
              DefaultTableModel clientes = (DefaultTableModel) tblClientes.getModel();
              String cpfCliente = clientes.getValueAt(linha, 0).toString();
              String nomeCliente = clientes.getValueAt(linha, 1).toString();
              
              cliente = new Cliente(cpfCliente,nomeCliente);
              
              lblUsuarioSelecionado.setText(nomeCliente);
         }else{
           JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada.");
         }  
    }//GEN-LAST:event_btnAdicionaClienteActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        int linha = tblCarrinho.getSelectedRow();
        if (linha != -1) {
            // Obter o modelo da tabela do carrinho
            DefaultTableModel cartTableModel = (DefaultTableModel) tblCarrinho.getModel();

            // Obter o nome e a quantidade do produto que está sendo removido
            int idProduto = Integer.parseInt(cartTableModel.getValueAt(linha, 0).toString());
            String nomeProduto = cartTableModel.getValueAt(linha, 1).toString();
            int qtdRemovida = Integer.parseInt(cartTableModel.getValueAt(linha, 2).toString());
            double precoProduto = Double.parseDouble(cartTableModel.getValueAt(linha, 3).toString());

            // Remover a linha selecionada do carrinho
            cartTableModel.removeRow(linha);

            // Atualizar a quantidade no tblProdutos
            atualizaQtdRemovida(idProduto, nomeProduto, qtdRemovida, precoProduto);

            // Atualizar o preço total
            atualizaPrecoTotal();

        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada.");
        }
    }//GEN-LAST:event_btnEliminaActionPerformed

    private void btnAplicaDesconto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicaDesconto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAplicaDesconto2ActionPerformed

    private void btnFinalizaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaCompraActionPerformed
        efetuaVenda();
    }//GEN-LAST:event_btnFinalizaCompraActionPerformed

    private void checkSemCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSemCadastroActionPerformed
        if(checkSemCadastro.isSelected()) {
            btnAdicionaCliente.setEnabled(false);
            lblUsuarioSelecionado.setText("Compra Sem Cadastro");
        }else{
            btnAdicionaCliente.setEnabled(true);
            lblUsuarioSelecionado.setText("--");
        }
    }//GEN-LAST:event_checkSemCadastroActionPerformed

    private void atualizaQtdRemovida(int id, String nomeProduto, int qtdRemovida, double precoProduto) {
        DefaultTableModel produtos = (DefaultTableModel) tblProdutos.getModel();
        boolean produtoEncontrado = false;

        // Iterar sobre as linhas da tblProdutos para encontrar o produto
        for (int i = 0; i < produtos.getRowCount(); i++) {
            int idProduto = Integer.parseInt(produtos.getValueAt(i, 0).toString());
            if (idProduto == id) {
                int novaQuantidade = Integer.parseInt(produtos.getValueAt(i, 2).toString()) + qtdRemovida;
                produtos.setValueAt(novaQuantidade, i, 2); // Atualizar a quantidade na tabela
                produtoEncontrado = true;
                break;
            }
        }

        // Se o produto não foi encontrado na tblProdutos, adicioná-lo de volta
        if (!produtoEncontrado) {
            produtos.addRow(new Object[]{id, nomeProduto, qtdRemovida, precoProduto});
        }
    }

    private void addProdutoCarrinho(int idProduto, String nomeProduto, double precoProduto, int qtdSelecionada) {
        DefaultTableModel carrinho = (DefaultTableModel) tblCarrinho.getModel();
        boolean existeProduto = false;

        if ((verificaCarrinho())) {
            // Verifica se o produto já está no carrinho
            for (int i = 0; i < carrinho.getRowCount(); i++) {
                String carrinhoProduto = carrinho.getValueAt(i, 1).toString();
                if (carrinhoProduto.equals(nomeProduto)) {
                    // Produto já está no carrinho, então aumenta a quantidade
                    int quantidadeCarrinho = Integer.parseInt(carrinho.getValueAt(i, 2).toString());
                    carrinho.setValueAt(quantidadeCarrinho + qtdSelecionada, i, 2);
                    carrinho.setValueAt(precoProduto * (quantidadeCarrinho + qtdSelecionada), i, 4);
                    existeProduto = true;
                    break;
                }
            }
        }

        if (!existeProduto) {
            // Produto não está no carrinho, então adiciona uma nova linha
            carrinho.addRow(new Object[]{idProduto, nomeProduto, qtdSelecionada, precoProduto, (precoProduto * qtdSelecionada)});
            vendaEmAndamento = true;
        }
    }

    private boolean verificaCarrinho() {
        DefaultTableModel cartTableModel = (DefaultTableModel) tblCarrinho.getModel();
        return cartTableModel.getRowCount() > 0;
    }

    // Método para atualizar a quantidade de produtos na tblProdutos
    private void atualizaQtdProduto(int linha, int qtdProduto, int qtdSelecionada) {
        DefaultTableModel produtosModel = (DefaultTableModel) tblProdutos.getModel();
        int novaQuantidade = qtdProduto - qtdSelecionada;

        if (novaQuantidade > 0) {
            // Atualiza a quantidade no produto
            produtosModel.setValueAt(novaQuantidade, linha, 2);
        } else {
            // Remove a linha da tabela se a quantidade for zero
            produtosModel.removeRow(linha);
        }
    }

    private void atualizaPrecoTotal() {
        DefaultTableModel cartTableModel = (DefaultTableModel) tblCarrinho.getModel();
        double precoTotal = 0.0;

        // passando sobre as linhas do modelo de tabela do carrinho
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            double precoTotalProduto = Double.parseDouble(cartTableModel.getValueAt(i, 4).toString());
            precoTotal += precoTotalProduto;
        }

        fieldTotal.setText(String.format("%.2f", precoTotal));
    }
    
    private void efetuaVenda(){
        
        VendaDAO daovenda = new VendaDAO();
        
        if(lblUsuarioSelecionado.getText().equals("--")){
            JOptionPane.showMessageDialog(this, 
                    "Adicione um cliente a venda, ou selecione 'Sem Cadastro'",
                    "Atenção", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        double valor = Double.parseDouble(fieldTotal.getText().replace(",", "."));
        
        if(valor == 0.00){
            JOptionPane.showMessageDialog(this, 
                    "Adicione produtos no carrinho!",
                    "Atenção", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Date now = new Date();
        
        try{
            venda = new Venda(valor, now,cliente);
            List<Produto> listaProdutos = criarListaProdutos(tblCarrinho);
          
            venda_desc =  new VendaDescricao(venda,listaProdutos);
            
            daovenda.efetuaVenda(venda_desc);    
            
            JOptionPane.showMessageDialog(this, "Venda Realizado com Sucesso!");
            atualizaTela();
            
        } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static List<Produto> criarListaProdutos(JTable tblCarrinho) {
        List<Produto> listaProdutos = new ArrayList<>();
        TableModel model = tblCarrinho.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            int idProduto = Integer.parseInt(model.getValueAt(i, 0).toString());
            int qtdProduto = Integer.parseInt(model.getValueAt(i, 2).toString());
            double precoQuantidade = Double.parseDouble(model.getValueAt(i, 4).toString());

            Produto produto = new Produto(idProduto,precoQuantidade,qtdProduto);
            listaProdutos.add(produto);
        }

        return listaProdutos;
    }
    
    public void atualizaTela(){
        atualizarTabelaCliente();
        atualizarTabelaProduto();
        
        DefaultTableModel carrinho = (DefaultTableModel) tblCarrinho.getModel();
        carrinho.setRowCount(0);
        lblUsuarioSelecionado.setText("--");
        checkSemCadastro.setSelected(false);
        btnAdicionaCliente.setEnabled(true);
        vendaEmAndamento =false;
        atualizaPrecoTotal();   
    }
    
    public void atualizarTabelaCliente() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Chama a DAO para listar os PCs
            ArrayList<Cliente> lstRetorno = ClienteDAO.listar();
            DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();

            // Limpa as linhas da tabela
            modelo.setRowCount(0);

            // Para cada item na lista de retorno, adiciono uma linha à tabela
            for (Cliente item : lstRetorno) {
                modelo.addRow(new String[]{
                    String.valueOf(item.getCpfCliente()),
                    String.valueOf(item.getNomeCliente()),
                    formatoData.format(item.getDtNascimento())
                });
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizarTabelaProduto() {
        try {
            // Chama a DAO para listar os PCs
            ArrayList<Produto> lstRetorno = ProdutoDAO.listar();
            DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();

            // Limpa as linhas da tabela
            modelo.setRowCount(0);

            // Para cada item na lista de retorno, adiciono uma linha à tabela
            for (Produto item : lstRetorno) {
                modelo.addRow(new String[]{
                    String.valueOf(item.getIdProduto()),
                    String.valueOf(item.getNomeProduto()),
                    String.valueOf(item.getQtdProduto()),
                    String.valueOf(item.getPrecoProduto())
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionaCliente;
    private javax.swing.JButton btnAdicionaProduto;
    private javax.swing.JButton btnAplicaDesconto1;
    private javax.swing.JButton btnAplicaDesconto2;
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnFinalizaCompra;
    private javax.swing.JButton btnPesquisaCliente;
    private javax.swing.JButton btnPesquisaProduto;
    private javax.swing.JComboBox<String> cbTipoPesquisa;
    private javax.swing.JComboBox<String> cbTipoPesquisaClientes;
    private javax.swing.JCheckBox checkSemCadastro;
    private javax.swing.JTextField fieldDesconto;
    private javax.swing.JTextField fieldPesquisaCliente;
    private javax.swing.JTextField fieldPesquisaProduto;
    private javax.swing.JTextField fieldTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblUsuarioSelecionado;
    private javax.swing.JPanel pnlCarrinho;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlDesconto1;
    private javax.swing.JPanel pnlProdutos;
    private javax.swing.JPanel pnlValor;
    private javax.swing.JTable tblCarrinho;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}
