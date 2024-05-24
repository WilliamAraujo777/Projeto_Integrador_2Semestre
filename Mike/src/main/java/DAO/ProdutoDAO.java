/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Categoria;
import model.beans.Produto;

/**
* Classe com o objetivo de conter os codigos que relacionam Produto e o banco de dados SQL
* @author kaikeCarmona, William Araujo, Vitor
* @see model.beans.*
*/
public class ProdutoDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";

    /**
     * Método para salvar produto
     *
     * @param obj
     * @return
     */
    public static boolean salvarProduto(Produto obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            //carregando driver;
            Class.forName("org.sqlite.JDBC");

            //abrindo conexao
            conexao = (Connection) DriverManager.getConnection(url);

            //preparando query para o banco de dados
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO produto (nomeProduto, precoProduto, qtdProduto, idCategoria) values(?,?,?,?);");

            // Parametros da query 
            sql.setString(1, obj.getNomeProduto());
            sql.setDouble(2, obj.getPrecoProduto());
            sql.setInt(3, obj.getQtdProduto());
            sql.setInt(4, obj.getCategoria().getidCategoria());
            //executa comando sql
            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    /**
     * Método para alterar dados do produto
     *
     * @param obj
     * @return
     */
    public static boolean alterar(Produto obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            // Carrega o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Cria conexão com o banco
            conexao = DriverManager.getConnection(url);

            // INSERT
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produto SET nomeProduto = ?, precoProduto = ?, qtdProduto = ?, idCategoria = ? WHERE idProduto = ?");
            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setDouble(2, obj.getPrecoProduto());
            comandoSQL.setInt(3, obj.getQtdProduto());
            comandoSQL.setInt(4, obj.getIdCategoria());
            comandoSQL.setInt(5, obj.getIdProduto());

            // Executa o INSERT
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    /**
     * Método para listar os produtos
     *
     * @return
     */
    public static ArrayList<Produto> listar() {
        ArrayList<Produto> lstProdutos = new ArrayList<Produto>();
        Categoria categoria; 
        Connection conexao = null;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Criando conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT p.idProduto, p.nomeProduto, p.precoProduto, p.qtdProduto, c.nomeCategoria FROM produto p INNER JOIN categoria c ON p.idCategoria = c.idCategoria");

            // Executando o SELECT
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                categoria = new Categoria();
                // Criando um objeto produto para cada linha e adicionando à lista de retorno
                int idProd = rs.getInt("idProduto");
                String nomeProd = rs.getString("nomeProduto");
                double precProd = rs.getDouble("precoProduto");
                int qtdProd = rs.getInt("qtdProduto");
                String nomeCategoria = rs.getString("nomeCategoria");
                categoria.setnomeCategoria(nomeCategoria);
                
                Produto item = new Produto(idProd, nomeProd, precProd, qtdProd, categoria);

                // Adicionando à lista de retorno
                lstProdutos.add(item);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstProdutos;
    }

    /**
     * Excluir produto
     *
     * @param idExcluir
     * @return
     */
    public static boolean excluir(int idExcluir) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conexão com o banco
            conexao = DriverManager.getConnection(url);

            // DELETE
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            comandoSQL.setInt(1, idExcluir);

            // Executando o DELETE
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    /**
     * Buscar um produto pelo nome
     *
     * @param id
     * @return
     */
    public static Produto buscaPorId(int id) {
        Produto retorno = null;
        Categoria categoria = new Categoria();

        Connection conexao = null;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement
        ("SELECT p.idProduto, p.nomeProduto, p.precoProduto, p.qtdProduto, c.nomeCategoria FROM produto p INNER JOIN categoria c ON p.idCategoria = c.idCategoria  WHERE p.idProduto = ?");

            comandoSQL.setInt(1, id);

            // Executando o SQLite
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                // Para cada linha, cria um objeto computador e adiciona à lista de retorno
                int idProd = rs.getInt("idProduto");
                String nomeProd = rs.getString("nomeProduto");
                double precProd = rs.getDouble("precoProduto");
                int qtdProd = rs.getInt("qtdProduto");
                String nomeCategoria = rs.getString("nomeCategoria");
                categoria.setnomeCategoria(nomeCategoria);

                retorno = new Produto(idProd, nomeProd, precProd, qtdProd, categoria);

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
}
