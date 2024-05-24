/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Cliente;
import model.beans.Produto;
import model.beans.Venda;
import model.beans.VendaDescricao;
import java.util.Date;
import javax.swing.JOptionPane;

/**
* Classe com o objetivo de conter os codigos que relacionam Cliente e o banco de dados SQL
* @author William Araujo
* @see model.beans.*
*/
public class VendaDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";
    
     /**
        * Método utilizado para adicionar a venda no banco de dados
        * @author William Araujo
        * @see model.beans.*
        * @param venda objeto do tipo VendaDescricao
        */
    public void efetuaVenda(VendaDescricao venda) throws ClassNotFoundException, SQLException {
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
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO venda(valorVenda,dtVenda, cpfCliente, valorDesconto) VALUES(?,?,?,?)");

            //parametros da query 
            sql.setDouble(1, venda.getVenda().getValorVenda());
            sql.setString(2, String.valueOf(sqlDate.toString()));
            sql.setString(3, String.valueOf(venda.getVenda().getCliente().getCpfCliente()));
            sql.setDouble(4, venda.getVenda().getValorDesconto());

            //executa comando sql
            sql.executeUpdate();

            // Obter o ID da venda inserida
            ResultSet rs = sql.getGeneratedKeys();
            int idVenda = 0;
            if (rs.next()) {
                idVenda = rs.getInt(1);
            }

            sql = conexao.prepareStatement("INSERT INTO venda_descricao(idVenda, qtdProduto, precoProduto, nomeProduto, nomeCliente) VALUES(?,?,?,?,?)");

            // Inserir descrição da venda
            for (Produto produto : venda.getListaProdutos()) {
                sql.setInt(1, idVenda);
                sql.setInt(2, produto.getQtdProduto());
                sql.setDouble(3, produto.getPrecoProduto());
                sql.setString(4, produto.getNomeProduto());
                sql.setString(5, venda.getVenda().getCliente().getNomeCliente());
                                sql.executeUpdate();
                alteraQuantidade(produto);
            }

        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o adminstrador!");
        } catch (SQLException ex) {
            throw new SQLException("Erro de SQL, contate o adminstrador!\n" + ex);
        }
    }
    
    /**
        * Método utilizado para alterar a quantidade de produto no banco de dados de acordo com a venda
        * @author William Araujo
        * @see model.beans.*
        * @param obj objeto do tipo Produto
        */
    public static boolean alteraQuantidade(Produto obj) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            // Carrega o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Cria conexão com o banco
            conexao = DriverManager.getConnection(url);

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produto SET qtdProduto = qtdProduto - ? WHERE idProduto = ?");
            comandoSQL.setInt(1, obj.getQtdProduto());
            comandoSQL.setInt(2, obj.getIdProduto());

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
        * Método utilizado para encontrar a venda_descrição de acordo com o id da venda no banco de dados
        * @author William Araujo
        * @see model.beans.*
        */
    public static ArrayList<VendaDescricao>buscarPorVenda(int idVenda) throws ParseException {
        
        Venda venda;
        Produto produto;
        Cliente cliente;

        Connection conexao;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<VendaDescricao> lstVenda = new ArrayList<>();
        
                
        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT a.qtdProduto,a.precoProduto,a.nomeProduto,a.nomeCliente,c.cpfCliente,c.dtVenda, c.valorDesconto FROM venda_descricao a "
                    + "inner join venda c "
                    + "on c.idVenda = a.idVenda "
                    + "WHERE a.idVenda = ?");

            comandoSQL.setInt(1, idVenda);

            // Executando o SQLite
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                // Para cada linha, cria um objeto computador e adiciona à lista de retorno
                String nomeProduto = rs.getString("nomeProduto");
                double precoProduto = rs.getDouble("precoProduto");
                int qtdProduto = rs.getInt("qtdProduto");
                String cpfCliente = rs.getString("cpfCliente");
                String nomeCliente = rs.getString("nomeCliente");
                String dtVenda = rs.getString("dtVenda");
                
                java.util.Date dataDate = formato.parse(dtVenda);
                
                double desconto = rs.getDouble("valorDesconto");
                produto = new Produto();
                
                produto.setNomeProduto(nomeProduto);
                produto.setQtdProduto(qtdProduto);
                                
                cliente = new Cliente(cpfCliente,nomeCliente);
                venda = new Venda(precoProduto, dataDate, cliente);
                venda.setValorDesconto(desconto);
                
                VendaDescricao item = new VendaDescricao(venda,produto);
                lstVenda.add(item);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return lstVenda;
    }
    
    /**
        * Método utilizado para listar todas as vendas do banco de dados
        * @author William Araujo
        * @see model.beans.*
        */
    public static ArrayList<Venda> listar() throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Venda> lstVenda = new ArrayList<>();
        Cliente cliente;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Connection conexao;

        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Criando conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM venda");

            // Executando o SELECT
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                Double valor = rs.getDouble("valorVenda");
                String data = rs.getString("dtVenda");
                String cpfCliente = rs.getString("cpfCliente");
                Double valorDesconto = rs.getDouble("valorDesconto");
                
                cliente = new Cliente();
                cliente.setCpfCliente(cpfCliente);
                java.util.Date dataDate = formato.parse(data);
                                
                Venda item = new Venda(idVenda, valor, dataDate, cliente);
                item.setValorDesconto(valorDesconto);
                lstVenda.add(item);
            }
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o adminstrador!");
        } catch (SQLException ex) {
            throw new SQLException("Erro de SQL, contate o adminstrador!");
        } catch (ParseException ex) {
            throw new ParseException("Erro de SQL, contate o adminstrador!", 0);
        }
        return lstVenda;
    }
    
    /**
        * Método utilizado para encontrar a venda de acordo com a data passada pelo usuario
        * @author William Araujo
     * @param dtInicio
     * @param dtFim
     * @return 
     * @throws java.text.ParseException 
        * @see model.beans.*
        */
    public static ArrayList<Venda>buscarVendaData(java.util.Date dtInicio, java.util.Date dtFim) throws ParseException {
        Connection conexao;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date dataInicio = new java.sql.Date(dtInicio.getTime());
        java.util.Date dataFim = new java.sql.Date(dtFim.getTime());
        ArrayList<Venda> lstVenda = new ArrayList<>();
        Cliente cliente;
        
 
        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dtVenda between ? and ?");

            comandoSQL.setString(1, dataInicio.toString());
            comandoSQL.setString(2, dataFim.toString());
            
            // Executando o SELECT
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                Double valor = rs.getDouble("valorVenda");
                String data = rs.getString("dtVenda");
                String cpfCliente = rs.getString("cpfCliente");
                Double valorDesconto = rs.getDouble("valorDesconto");
                cliente = new Cliente();
                cliente.setCpfCliente(cpfCliente);
                java.util.Date dataDate = formato.parse(data);

                Venda item = new Venda(idVenda, valor, dataDate, cliente);
                item.setValorDesconto(valorDesconto);
                lstVenda.add(item);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return lstVenda;
    }

}
