/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panels;

import DAO.ProdutoDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.beans.Categoria;
import model.beans.Produto;
import view.CadastroProduto;
import view.TelaPrincipal;

/**
 *
 * @author aroni
 */
public class TelaProdutos extends javax.swing.JPanel {

    /**
     * Creates new form Produtos
     */
    JFrame parent;
    public TelaProdutos(JFrame parent) {
        initComponents();
         atualizarTabela();
         this.parent = parent;
    }
    
    public TelaProdutos() {
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        txtNomeProdFiltro = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(722, 500));

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Quantidade", "Categoria"
            }
        ));
        tblProdutos.setGridColor(new java.awt.Color(255, 255, 255));
        tblProdutos.setShowGrid(false);
        jScrollPane3.setViewportView(tblProdutos);
        tblProdutos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(txtNomeProdFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeProdFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // Verifica se o usuário está procurando por algum processador em específico
        if (txtNomeProdFiltro.getText().strip().equals("")) {
            atualizarTabela();
        } else {
            String nomeProd = txtNomeProdFiltro.getText();

            Produto retorno = ProdutoDAO.buscarPorNome(nomeProd); // Filtrando produtos pelo nome;

            if (retorno != null) {
                DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
                modelo.setRowCount(0);

                modelo.addRow(new String[]{
                    String.valueOf(retorno.getIdProduto()),
                    String.valueOf(retorno.getNomeProduto()),
                    String.valueOf(retorno.getPrecoProduto()),
                    String.valueOf(retorno.getQtdProduto()),
                    String.valueOf(retorno.getIdCategoria())
                });
            }
        }
    }//GEN-LAST:event_btnListarActionPerformed

 

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        CadastroProduto cadastro = new CadastroProduto(parent, this);
        cadastro.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhaSelecionada = tblProdutos.getSelectedRow(); // Recebendo a linha selecionada
        Categoria categoria = new Categoria();
        
        // Recebendo dados da linha selecionada
        if (linhaSelecionada >= 0) {
            DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
            int idProd = Integer.parseInt(modelo.getValueAt(linhaSelecionada, 0).toString());
            String nomeProd = (modelo.getValueAt(linhaSelecionada, 1).toString());
            double precProd = (Double.parseDouble(modelo.getValueAt(linhaSelecionada, 2).toString()));
            int qtdProd = (Integer.parseInt(modelo.getValueAt(linhaSelecionada, 3).toString()));
            
          
            String nomeCategoria = (modelo.getValueAt(linhaSelecionada, 4).toString());
            
            categoria.setnomeCategoria(nomeCategoria);

            Produto alterarProduto = new Produto(idProd, nomeProd, precProd, qtdProd, categoria); // Passando os dados para o construtor que os modifica
            CadastroProduto cadastro = new CadastroProduto(alterarProduto, this.parent, this); // Chama a tela de cadastro no modo de alteração
            cadastro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tblProdutos.getSelectedRow(); // Recebe a linha do usuário

        // Pega os dados da linha selecionada
        if (linhaSelecionada >= 0) {
            DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
            int idExcluir = Integer.parseInt(modelo.getValueAt(linhaSelecionada, 0).toString());

            //Chamar a DAO para excluir
            boolean retorno = ProdutoDAO.excluir(idExcluir);
            if (retorno) {
                JOptionPane.showMessageDialog(this, "Produto Excluido");
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Falha!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public void atualizarTabela() {
        // Chama a DAO para listar as notas
        ArrayList<Produto> produtos = ProdutoDAO.listar();

        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();

        // Limpa as linhas da tabela
        modelo.setRowCount(0);

        // Para cada item na lista de retorno, adiciono uma linha à tabela
        for (Produto item : produtos) {

            modelo.addRow(new String[]{
                String.valueOf(item.getIdProduto()),
                String.valueOf(item.getNomeProduto()),
                String.valueOf(item.getPrecoProduto()),
                String.valueOf(item.getQtdProduto()),
                String.valueOf(item.getCategoria().getnomeCategoria())
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtNomeProdFiltro;
    // End of variables declaration//GEN-END:variables
}
