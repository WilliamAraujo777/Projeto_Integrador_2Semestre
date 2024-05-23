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
import model.beans.Endereco;
import model.beans.Produto;

/**
 *
 * @author Pichau
 */
public class EnderecoDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";

    /**
     * Método para salvar produto
     *
     * @param obj
     * @return
     */
    public static void salvarEndereco(Endereco obj, String cpf) throws ClassNotFoundException, SQLException {
        boolean retorno = false;
        Connection conexao = null;

        try {
            //carregando driver;
            Class.forName("org.sqlite.JDBC");

            //abrindo conexao
            conexao = (Connection) DriverManager.getConnection(url);

            //preparando query para o banco de dados
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO endereco(logradouro,CEP,bairro,cidade,estado,numero,complemento,cpfCliente) VALUES(?,?,?,?,?,?,?,?)");

            // Parametros da query 
            sql.setString(1, obj.getLogradouro());
            sql.setString(2, obj.getCep());
            sql.setString(3, obj.getBairro());
            sql.setString(4, obj.getCidade());
            sql.setString(5, obj.getEstado());
            sql.setString(6, obj.getNumero());
            sql.setString(7, obj.getComplemento());
            sql.setString(8, cpf);

            //executa comando sql
            sql.executeUpdate();

        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o adminstrador!");
        } catch (SQLException ex) {
            throw new SQLException("Erro de SQL, contate o adminstrador!\n" + ex);
        }
    }

    /**
     * Método para alterar dados do produto
     *
     * @param obj
     * @return
     */
    public static boolean alterar(Endereco obj, String cpf) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            // Carrega o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Cria conexão com o banco
            conexao = DriverManager.getConnection(url);

            // INSERT
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE endereco SET logradouro = ?, CEP = ?, bairro = ?, cidade = ?, estado = ?, numero = ?, complemento = ?, WHERE cpfCliente = ?");
            // Parametros da query 
            comandoSQL.setString(1, obj.getLogradouro());
            comandoSQL.setString(2, obj.getCep());
            comandoSQL.setString(3, obj.getBairro());
            comandoSQL.setString(4, obj.getCidade());
            comandoSQL.setString(5, obj.getEstado());
            comandoSQL.setString(6, obj.getNumero());
            comandoSQL.setString(7, obj.getComplemento());
            comandoSQL.setString(8, cpf);

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

    public static Endereco obterEnderecoPorCPF(String cpfCliente) throws ClassNotFoundException, SQLException {
        boolean retorno = false;
        Connection conexao = null;
        Endereco endereco = null;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conexão com o banco
            conexao = DriverManager.getConnection(url);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM endereco WHERE cpfCliente = ?");

            comandoSQL.setString(1, cpfCliente);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs.next()) {
                endereco = new Endereco();
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setCep(rs.getString("cep"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
            }

        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o adminstrador!");
        } catch (SQLException ex) {
            throw new SQLException("Erro de SQL, contate o adminstrador!\n" + ex);
        }

        return endereco;
    }
}
