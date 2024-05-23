package model.beans;
import java.util.List;

public class VendaDescricao {

    private Venda venda; 
    private List<Produto> listaProdutos;
    Produto produto = new Produto();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public VendaDescricao() {
    
    }
    public VendaDescricao(Venda venda, List<Produto> listaProdutos) {
        this.venda = venda;
        this.listaProdutos = listaProdutos;
    }
    
    public VendaDescricao(Venda venda, Produto produto) {
        this.venda = venda;
        this.produto = produto;
    }
    
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
