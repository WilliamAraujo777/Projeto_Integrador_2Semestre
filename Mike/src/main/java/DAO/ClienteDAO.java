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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Cliente;
import model.beans.Endereco;

/**
 *
 * @author Pichau
 */
public class ClienteDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";

    public static boolean salvarCliente(Cliente obj) {
        boolean retorno = false;
        Connection conexao = null;
        EnderecoDAO dao = new EnderecoDAO();

        try {
            java.util.Date utilDate = obj.getDtNascimento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            //carregando driver;
            Class.forName("org.sqlite.JDBC");

            //abrindo conexao
            conexao = (Connection) DriverManager.getConnection(url);

            //preparando query para o banco de dados
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO cliente (cpfCliente, nomeCliente, sexoCliente, emailCliente, numeroCliente, dtNascimento) values (?,?,?,?,?,?)");
            //parametros da query 
            sql.setString(1, obj.getCpfCliente());
            sql.setString(2, obj.getNomeCliente());
            sql.setString(3, String.valueOf(obj.getSexoCliente()));
            sql.setString(4, obj.getEmailCliente());
            sql.setString(5, obj.getNumeroCliente());
            sql.setString(6, sqlDate.toString());

            //executa comando sql
            int linhasAfetadas = sql.executeUpdate();

            dao.salvarEndereco(obj.getEndereco(), obj.getCpfCliente());

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

    public static boolean alterarCliente(Cliente obj) {
        boolean retorno = false;
        Connection conexao = null;
        EnderecoDAO dao = new EnderecoDAO();

        try {
            java.util.Date utilDate = obj.getDtNascimento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            //carregando driver;
            Class.forName("org.sqlite.JDBC");

            //abrindo conexao
            conexao = (Connection) DriverManager.getConnection(url);

            //preparando query para o banco de dados
            PreparedStatement sql = conexao.prepareStatement("UPDATE cliente SET nomeCliente = ?, sexoCliente = ?, emailCliente = ?, numeroCliente = ?, dtNascimento = ? WHERE cpfCliente = ?");
            //parametros da query 
            sql.setString(1, obj.getNomeCliente());
            sql.setString(2, String.valueOf(obj.getSexoCliente()));
            sql.setString(3, obj.getEmailCliente());
            sql.setString(4, obj.getNumeroCliente());
            sql.setString(5, sqlDate.toString());
            sql.setString(6, obj.getCpfCliente());

            //executa comando sql
            int linhasAfetadas = sql.executeUpdate();

//            dao.salvarEndereco(obj.getEndereco(), obj.getCpfCliente());
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

    public static ArrayList<Cliente> listar() throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Cliente> lstNotas = new ArrayList<>();
        Connection conexao = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Endereco endereco;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Criando conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpfCliente = endereco.cpfCliente;");

            // Executando o SELECT
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                endereco = new Endereco();
                // Criando um objeto computador para cada linha e adicionando à lista de retorno
                String cpf = rs.getString("cpfCliente");
                String nome = rs.getString("nomeCliente");
                String sexo = rs.getString("sexoCliente");
                String email = rs.getString("emailCliente");
                String dtNascimento = rs.getString("dtNascimento");
                String numero = rs.getString("numeroCliente");
                char sexoChar = sexo.charAt(0);

//                String logadouro = rs.getString("estado");
//                String cep = rs.getString("cep");
//                String bairro = rs.getString("bairro");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
//                String numeroEndereco = rs.getString("numero");
//                String complemento = rs.getString("complemento");

//                endereco.setLogradouro(logadouro);
//                endereco.setCep(cep);
//                endereco.setBairro(bairro);
                endereco.setEstado(estado);
                endereco.setCidade(cidade);
//                endereco.setNumero(numeroEndereco);
//                endereco.setComplemento(complemento);

                Date dataDate = formato.parse(dtNascimento);

                Cliente cliente = new Cliente(cpf, nome, sexoChar, email, numero, dataDate, endereco);

                // Adicionando à lista de retorno
                lstNotas.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o adminstrador!");
        } catch (SQLException ex) {
            throw new SQLException("Erro de SQL, contate o adminstrador!\n" + ex);
        } catch (ParseException ex) {
            throw new ParseException("Erro ao converter a , contate o adminstrador!", 0);

        }
        return lstNotas;
    }

    public static Cliente buscarPorNome(String clienteNome) throws ParseException {
        Cliente retorno = null;
        Endereco endereco;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Connection conexao = null;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT cliente.*, endereco.estado, endereco.cidade FROM cliente INNER JOIN endereco ON cliente.cpfCliente = endereco.cpfCliente WHERE nomeCliente = ?");

            comandoSQL.setString(1, clienteNome);

            // Executando o SQLite
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                endereco = new Endereco();
                // Criando um objeto computador para cada linha e adicionando à lista de retorno
                String cpf = rs.getString("cpfCliente");
                String nome = rs.getString("nomeCliente");
                String sexo = rs.getString("sexoCliente");
                String email = rs.getString("emailCliente");
                String dtNascimento = rs.getString("dtNascimento");
                String numero = rs.getString("numeroCliente");
                char sexoChar = sexo.charAt(0);

                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                endereco.setEstado(estado);
                endereco.setCidade(cidade);

                Date dataDate = formato.parse(dtNascimento);

                retorno = new Cliente(cpf, nome, sexoChar, email, numero, dataDate, endereco);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static boolean excluir(String cpf) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conexão com o banco
            conexao = DriverManager.getConnection(url);

            // DELETE
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cpfCliente = ?");
            comandoSQL.setString(1, cpf);

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
}
