package model.beans;

import java.util.Date;

public class Cliente {

    private String cpfCliente;
    private String nomeCliente;
    private char sexoCliente;
    private String emailCliente;
    private String numeroCliente;
    private Date dtNascimento;
    Endereco endereco = new Endereco();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Cliente(String cpfCliente, String nomeCliente, char sexoCliente, String emailCliente, String numeroCliente, Date dtNascimento, Endereco endereco) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.sexoCliente = sexoCliente;
        this.emailCliente = emailCliente;
        this.numeroCliente = numeroCliente;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
    }

    public Cliente(String cpfCliente, String nomeCliente, char sexoCliente, String emailCliente, String numeroCliente, Date dtNascimento) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.sexoCliente = sexoCliente;
        this.emailCliente = emailCliente;
        this.numeroCliente = numeroCliente;
        this.dtNascimento = dtNascimento;
    }

    public Cliente() {
    }
    
    public Cliente(String cpfCliente, String nomeCliente) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public char getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(char sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

}
