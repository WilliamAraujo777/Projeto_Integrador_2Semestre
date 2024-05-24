package DAO;

import DAO.EnderecoDAO;
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
* Classe com o objetivo de conter os codigos que relacionam Cliente e o banco de dados SQL
* @author kaikeCarmona, William Araujo, Vitor
* @see model.beans.*
*/
public class ClienteDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";
    
    /**
        * Método utilizado para salvar o cliente no banco de dados
        * @author kaikeCarmona, William Araujo, Vitor
        * @see model.beans.*
        * @param obj objeto do tipo Cliente
        */
    public static boolean salvarCliente(Cliente obj) {
        boolean retorno = false;
        EnderecoDAO dao = new EnderecoDAO();

        try {
            java.util.Date utilDate = obj.getDtNascimento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Carregando driver;
            Class.forName("org.sqlite.JDBC");

            // Usando try-with-resources para gerenciar a conexão e PreparedStatement
            try (Connection conexao = DriverManager.getConnection(url); PreparedStatement sql = conexao.prepareStatement("INSERT INTO cliente (cpfCliente, nomeCliente, sexoCliente, emailCliente, numeroCliente, dtNascimento) values (?,?,?,?,?,?)")) {

                // Parâmetros da query 
                sql.setString(1, obj.getCpfCliente());
                sql.setString(2, obj.getNomeCliente());
                sql.setString(3, String.valueOf(obj.getSexoCliente()));
                sql.setString(4, obj.getEmailCliente());
                sql.setString(5, obj.getNumeroCliente());
                sql.setString(6, sqlDate.toString());

                // Executa comando sql
                int linhasAfetadas = sql.executeUpdate();

                dao.salvarEndereco(obj.getEndereco(), obj.getCpfCliente());

                if (linhasAfetadas > 0) {
                    retorno = true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
    /**
        * Método utilizado para alterar o cliente no banco de dados
        * @author kaikeCarmona, William Araujo, Vitor
        * @see model.beans.*
        * @param obj objeto do tipo Cliente
        */
    public static boolean alterarCliente(Cliente obj) {
        boolean retorno = false;
        EnderecoDAO dao = new EnderecoDAO();

        try {
            java.util.Date utilDate = obj.getDtNascimento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Carregando driver;
            Class.forName("org.sqlite.JDBC");
            
            // Usando try-with-resources para gerenciar a conexão e PreparedStatement
            try (Connection conexao = DriverManager.getConnection(url); PreparedStatement sql = conexao.prepareStatement("UPDATE cliente SET nomeCliente = ?, sexoCliente = ?, emailCliente = ?, numeroCliente = ?, dtNascimento = ? WHERE cpfCliente = ?")) {

                // Parâmetros da query 
                sql.setString(1, obj.getNomeCliente());
                sql.setString(2, String.valueOf(obj.getSexoCliente()));
                sql.setString(3, obj.getEmailCliente());
                sql.setString(4, obj.getNumeroCliente());
                sql.setString(5, sqlDate.toString());
                sql.setString(6, obj.getCpfCliente());
                
                // Executa comando sql
                int linhasAfetadas = sql.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                    dao.alterar(obj.getEndereco(), obj.getCpfCliente());
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
    /**
        * Método utilizado para listar os clientes no banco de dados
        * @author kaikeCarmona, William Araujo, Vitor
        * @see model.beans.*
        */
    public static ArrayList<Cliente> listar() throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Cliente> lstNotas = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Usando try-with-resources para gerenciar a conexão, PreparedStatement e ResultSet
            try (Connection conexao = DriverManager.getConnection(url); PreparedStatement comandoSQL = conexao.prepareStatement("SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpfCliente = endereco.cpfCliente WHERE cliente.cpfCliente <> '0';"); ResultSet rs = comandoSQL.executeQuery()) {

                while (rs.next()) {
                    Endereco endereco = new Endereco();
                    // Criando um objeto cliente para cada linha e adicionando à lista de retorno
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

                    Cliente cliente = new Cliente(cpf, nome, sexoChar, email, numero, dataDate, endereco);

                    // Adicionando à lista de retorno
                    lstNotas.add(cliente);
                }
            } catch (SQLException ex) {
                throw new SQLException("Erro de SQL, contate o administrador!\n" + ex);
            } catch (ParseException ex) {
                throw new ParseException("Erro ao converter a data, contate o administrador!", 0);
            }

        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o administrador!");
        }

        return lstNotas;
    }
    
    /**
        * Método utilizado para achar o cliente no banco de dados
        * @author Vitor
        * @see model.beans.*
        */
    public static Cliente bucarPorCPF(String cpfCliente) throws ParseException {
        Cliente retorno=null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Usando try-with-resources para gerenciar a conexão, PreparedStatement e ResultSet
            try (Connection conexao = DriverManager.getConnection(url); 
                    PreparedStatement comandoSQL = conexao.prepareStatement("SELECT cliente.*, endereco.estado, endereco.cidade FROM cliente INNER JOIN endereco ON cliente.cpfCliente = endereco.cpfCliente WHERE cliente.cpfCliente = ?"); 
                ) {

                comandoSQL.setString(1, cpfCliente);
                 ResultSet rs = comandoSQL.executeQuery();
                while (rs.next()) {
                    Endereco endereco = new Endereco();
                    // Criando um objeto cliente para cada linha e adicionando à lista de retorno
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
            } catch (SQLException ex) {
                
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       return retorno;
        
    }
    
    /**
        * Método utilizado para deletar o cliente no banco de dados
        * @author kaikeCarmona, William Araujo, Vitor
        * @see model.beans.*
        */
    public static boolean excluir(String cpf) {
        boolean retorno = false;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Usando try-with-resources para gerenciar a conexão e PreparedStatement
            try (Connection conexao = DriverManager.getConnection(url); PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cpfCliente = ?")) {

                comandoSQL.setString(1, cpf);

                // Executando o DELETE
                int linhasAfetadas = comandoSQL.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
}
