/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.ProdutoDAO.url;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Categoria;
import model.beans.Cliente;
import model.beans.Produto;
import model.beans.Venda;
import model.beans.VendaDescricao;

public class VendaDAO {

    static String url = "jdbc:sqlite:C:/sqlite/mike";

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
                alteraQuantidade(produto);
            }

        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Erro, contate o adminstrador!");
        } catch (SQLException ex) {
            throw new SQLException("Erro de SQL, contate o adminstrador!\n" + ex);
        }
    }

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

    public static VendaDescricao buscarPorVenda(int idVenda) throws ParseException {
        
        Venda venda;
        Produto produto;
        Cliente cliente;
        VendaDescricao retorno = null;

        Connection conexao = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                
        try {
            // Carregando o driver do SQLite
            Class.forName("org.sqlite.JDBC");

            // Conexão com o banco
            conexao = DriverManager.getConnection(url);

            // SELECT
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT a.idProduto, a.qtdProduto,a.precoProduto,b.nomeProduto,d.nomeCliente,d.cpfCliente,c.dtVenda FROM venda_descricao a "
                    + "inner join produto b "
                    + "on a.idProduto = b.idProduto "
                    + "inner join venda c "
                    + "on c.idVenda = a.idVenda "
                    + "inner join cliente d "
                    + "on d.cpfCliente = c.cpfCliente "
                    + "WHERE a.idVenda = ?");

            comandoSQL.setInt(1, idVenda);

            // Executando o SQLite
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                // Para cada linha, cria um objeto computador e adiciona à lista de retorno
                int idProd = rs.getInt("idProduto");
                String nomeProduto = rs.getString("nomeProduto");
                double precoProduto = rs.getDouble("precoProduto");
                int qtdProduto = rs.getInt("qtdProduto");
                String cpfCliente = rs.getString("cpfCliente");
                String nomeCliente = rs.getString("nomeCliente");
                String dtVenda = rs.getString("dtVenda");
                
                java.util.Date dataDate = formato.parse(dtVenda);
                
                produto = new Produto();
                
                produto.setIdProduto(idProd);
                produto.setNomeProduto(nomeProduto);
                produto.setQtdProduto(qtdProduto);
                
                JOptionPane.showMessageDialog(null, produto.getNomeProduto());    

                
                cliente = new Cliente(cpfCliente,nomeCliente);
                venda = new Venda(precoProduto, dataDate, cliente);
                
                
                retorno = new VendaDescricao(venda,produto);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return retorno;
    }

    public static ArrayList<Venda> listar() throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Venda> lstVenda = new ArrayList<>();
        Cliente cliente = new Cliente();
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

                cliente.setCpfCliente(cpfCliente);
                java.util.Date dataDate = formato.parse(data);

                Venda item = new Venda(idVenda, valor, dataDate, cliente);

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

}
