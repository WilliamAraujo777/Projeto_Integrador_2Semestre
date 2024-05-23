package model.beans;

public class Produto {

    private int idProduto;
    private String nomeProduto;
    private double precoProduto;
    private int qtdProduto;
    private int idCategoria;
    Categoria categoria = new Categoria();

    public Produto(int idProduto, double precoProduto, int qtdProduto) {
        this.idProduto = idProduto;
        this.precoProduto = precoProduto;
        this.qtdProduto = qtdProduto;
    }
    
    public Produto(int idProduto, String nomeProduto, double precoProduto, int qtdProduto, Categoria categoria) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.qtdProduto = qtdProduto;
        this.categoria = categoria;
    }

    public Produto(int idProduto, int qtdProduto) {
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
    }

    public Produto(String nomeProduto, double precoProduto, int qtdProduto, Categoria categoria) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.qtdProduto = qtdProduto;
        this.categoria = categoria;
    }

    public Produto() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = (char) idCategoria;
    }

}
