package model.beans;

public class Fornecedor {

    private int idFornecedor;
    private String cnpj;
    private String nome;
    private int idEndereco;

    public Fornecedor(int idFornecedor, String cnpj, String nome, int idEndereco) {
        this.idFornecedor = idFornecedor;
        this.cnpj = cnpj;
        this.nome = nome;
        this.idEndereco = idEndereco;
    }

    public Fornecedor() {
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
}
