/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Produto;
import model.beans.Venda;

public class VendaDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";

    public static boolean efetuaVenda(Venda obj, Produto produto) {
        boolean retorno = false;
        Connection conexao = null;

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        listaProdutos.add(produto);

        try {
            java.util.Date utilDate = obj.getDtVenda();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            //carregando driver;
            Class.forName("org.sqlite.JDBC");

            //abrindo conexao
            conexao = (Connection) DriverManager.getConnection(url);

//            //preparando query para o banco de dados;;
//            PreparedStatement sql = conexao.prepareStatement("INSERT INTO venda(valorVenda, statusVenda,dtVenda, cpfCliente)(?,?,?,?)");
//            //parametros da query 
//            sql.setDouble(1, obj.getValorVenda());
//            sql.setString(2, String.valueOf(obj.getStatusVenda()));
//            sql.setString(3, String.valueOf(sqlDate.toString()));
//            sql.setString(4, String.valueOf(obj.getCpfCliente()));
//
//            //executa comando sql
//            int linhasAfetadas = sql.executeUpdate();
            for (Produto cont : listaProdutos) {
                JOptionPane.showMessageDialog(null, cont.getNomeProduto());
            }

//            if (linhasAfetadas > 0) {
//                retorno = true;
//            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

}
