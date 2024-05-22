package model.beans;

public class Categoria {

    private int idCategoria;
    private String nomeCategoria;

    public Categoria(int idCategoria, String nomeCategoria){
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria() {
    }


    public int getidCategoria() {
        return idCategoria;
    }

    public void setidCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getnomeCategoria() {
        return nomeCategoria;
    }

    public void setnomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

}
