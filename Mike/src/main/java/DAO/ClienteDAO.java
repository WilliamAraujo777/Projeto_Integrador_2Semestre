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
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO cliente (cpfCliente,nomeCliente, sexoCliente, emailCliente, numeroCliente, dtNascimento) values(?,?,?,?,?,?)");
            //parametros da query 
            sql.setString(1, obj.getCpfCliente());
            sql.setString(2, obj.getNomeCliente());
            sql.setString(3, obj.getEmailCliente());
            sql.setString(4, String.valueOf(obj.getSexoCliente()));
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

    public static ArrayList<Cliente> listar() throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Cliente> lstNotas = new ArrayList<>();
        Connection conexao;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Criando conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente");

            // Executando o SELECT
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                // Criando um objeto computador para cada linha e adicionando à lista de retorno
                String cpf = rs.getString("cpfCliente");
                String nome = rs.getString("nomeCliente");
                String sexo = rs.getString("sexoCliente");
                String email = rs.getString("emailCliente");
                String dtNascimento = rs.getString("dtNascimento");
                String numero = rs.getString("numeroCliente");
                char sexoChar = sexo.charAt(0);

                Date dataDate = formato.parse(dtNascimento);

                Cliente cliente = new Cliente(cpf, nome, sexoChar, email, numero, dataDate);

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

}
