package model.beans;

import java.util.Date;

public class Venda {

    private int idVenda;
    private double valorVenda;
    private double valorDesconto;
    private char statusVenda;

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
    private Date dtVenda;
    Cliente cliente;

    public Venda(double valorVenda, Date dtVenda, Cliente cliente) {
        this.valorVenda = valorVenda;
        this.dtVenda = dtVenda;
        this.cliente = cliente;
    }

    
    public Venda(int idVenda, double valorVenda, Date dtVenda, Cliente cliente) {
        this.idVenda = idVenda;
        this.valorVenda = valorVenda;
        this.dtVenda = dtVenda;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public Venda(int idVenda, double valorVenda, char statusVenda, Date dtVenda, String cpfCliente) {
        this.idVenda = idVenda;
        this.valorVenda = valorVenda;
        this.statusVenda = statusVenda;
        this.dtVenda = dtVenda;
    }

    public Venda() {
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public char getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(char statusVenda) {
        this.statusVenda = statusVenda;
    }

}
