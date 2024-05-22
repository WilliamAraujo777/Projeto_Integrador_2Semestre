package model.beans;

import java.util.Date;
import java.util.List;

public class VendaDescricao {

    private Venda venda; 
    private List<Produto> listaProdutos;
    private Date dtVenda;
    private double precoProduto;
    private double qtdProduto;
    
    
    public VendaDescricao() {
    
    }
    public VendaDescricao(Venda venda, List<Produto> listaProdutos) {
        this.venda = venda;
        this.listaProdutos = listaProdutos;
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
