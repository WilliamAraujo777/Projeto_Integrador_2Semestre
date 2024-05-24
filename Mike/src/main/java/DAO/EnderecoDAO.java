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
* Classe com o objetivo de conter os codigos que relacionam Endereco do cliente e o banco de dados SQL
* @author kaikeCarmona, William Araujo, Vitor
* @see model.beans.*
*/
public class EnderecoDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";
    
    /**
        * Método utilizado para salvar o endereco no banco de dados
        * @author kaikeCarmona, William Araujo, Vitor
        * @see model.beans.*
        * @param obj objeto do tipo Cliente
        */
    public static void salvarEndereco(Endereco obj, String cpf) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection conexao = DriverManager.getConnection(url);
                 PreparedStatement sql = conexao.prepareStatement("INSERT INTO endereco(logradouro,CEP,bairro,cidade,estado,numero,complemento,cpfCliente) VALUES(?,?,?,?,?,?,?,?)")) {

                sql.setString(1, obj.getLogradouro());
                sql.setString(2, obj.getCep());
                sql.setString(3, obj.getBairro());
                sql.setString(4, obj.getCidade());
                sql.setString(5, obj.getEstado());
                sql.setString(6, obj.getNumero());
                sql.setString(7, obj.getComplemento());
                sql.setString(8, cpf);

                sql.executeUpdate();

            } catch (SQLException ex) {
                throw new SQLException("Erro de SQL, contate o administrador!\n" + ex);
            }
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o administrador!");
        }
    }
    
    /**
        * Método utilizado para alterar o endereco no banco de dados
        * @author kaikeCarmona, William Araujo, Vitor
        * @see model.beans.*
        * @param obj objeto do tipo Endereco
        */
    public static boolean alterar(Endereco obj, String cpf) {
        boolean retorno = false;

        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection conexao = DriverManager.getConnection(url);
                 PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE endereco SET logradouro = ?, CEP = ?, bairro = ?, cidade = ?, estado = ?, numero = ?, complemento = ? WHERE cpfCliente = ?")) {

                comandoSQL.setString(1, obj.getLogradouro());
                comandoSQL.setString(2, obj.getCep());
                comandoSQL.setString(3, obj.getBairro());
                comandoSQL.setString(4, obj.getCidade());
                comandoSQL.setString(5, obj.getEstado());
                comandoSQL.setString(6, obj.getNumero());
                comandoSQL.setString(7, obj.getComplemento());
                comandoSQL.setString(8, cpf);

                int linhasAfetadas = comandoSQL.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
     /**
        * Método utilizado para lsitar os enderecos no banco de dados
        * @author kaikeCarmona, William Araujo, Vitor
        * @see model.beans.*
        */
    public static ArrayList<Produto> listar() {
        ArrayList<Produto> lstProdutos = new ArrayList<>();
        Categoria categoria;

        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection conexao = DriverManager.getConnection(url);
                 PreparedStatement comandoSQL = conexao.prepareStatement("SELECT p.idProduto, p.nomeProduto, p.precoProduto, p.qtdProduto, c.nomeCategoria FROM produto p INNER JOIN categoria c ON p.idCategoria = c.idCategoria");
                 ResultSet rs = comandoSQL.executeQuery()) {

                while (rs.next()) {
                    categoria = new Categoria();
                    int idProd = rs.getInt("idProduto");
                    String nomeProd = rs.getString("nomeProduto");
                    double precProd = rs.getDouble("precoProduto");
                    int qtdProd = rs.getInt("qtdProduto");
                    String nomeCategoria = rs.getString("nomeCategoria");
                    categoria.setnomeCategoria(nomeCategoria);

                    Produto item = new Produto(idProd, nomeProd, precProd, qtdProd, categoria);
                    lstProdutos.add(item);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstProdutos;
    }
    
     /**
        * Método utilizado para achar o endereco no banco de dados
        * @author kaikeCarmona, William Araujo, Vitor
        * @see model.beans.*
        */
    public static Endereco obterEnderecoPorCPF(String cpfCliente) throws ClassNotFoundException, SQLException {
        Endereco endereco = null;

        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection conexao = DriverManager.getConnection(url);
                 PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM endereco WHERE cpfCliente = ?")) {

                comandoSQL.setString(1, cpfCliente);

                try (ResultSet rs = comandoSQL.executeQuery()) {
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
                }
            } catch (SQLException ex) {
                throw new SQLException("Erro de SQL, contate o administrador!\n" + ex);
            }
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o administrador!");
        }

        return endereco;
    }
}
