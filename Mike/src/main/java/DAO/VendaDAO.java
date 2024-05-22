/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.List;
import model.beans.Produto;
import model.beans.Venda;
import model.beans.VendaDescricao;

public class VendaDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";

    public void efetuaVenda(VendaDescricao venda)throws ClassNotFoundException, SQLException  {
        boolean retorno = false;
        Connection conexao = null;

        try {
            java.util.Date utilDate = venda.getVenda().getDtVenda();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            //carregando driver;
            Class.forName("org.sqlite.JDBC");

            //abrindo conexao
            conexao = (Connection) DriverManager.getConnection(url);

            //preparando query para o banco de dados;
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO venda(valorVenda,dtVenda, cpfCliente) VALUES(?,?,?)");
            
            
            //parametros da query 
            sql.setDouble(1, venda.getVenda().getValorVenda());
            sql.setString(2, String.valueOf(sqlDate.toString()));
            sql.setString(3, String.valueOf(venda.getVenda().getCliente().getCpfCliente()));
            
            //executa comando sql
            sql.executeUpdate();
            
            // Obter o ID da venda inserida
            ResultSet rs = sql.getGeneratedKeys();
            int idVenda = 0;
            if (rs.next()) {
                idVenda = rs.getInt(1);
            }
            
            sql = conexao.prepareStatement("INSERT INTO venda_descricao(idVenda,idProduto, qtdProduto, precoProduto) VALUES(?,?,?,?)");
            
            // Inserir descrição da venda
            for (Produto produto : venda.getListaProdutos()) {
                sql.setInt(1, idVenda);
                sql.setInt(2, produto.getIdProduto());
                sql.setInt(3, produto.getQtdProduto());
                sql.setDouble(4, produto.getPrecoProduto());
                sql.executeUpdate();
            }
            
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o adminstrador!");
        } catch (SQLException ex) {
            throw new SQLException("Erro de SQL, contate o adminstrador!");
        }
    }
}
