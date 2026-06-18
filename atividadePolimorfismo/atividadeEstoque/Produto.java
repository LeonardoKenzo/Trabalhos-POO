package atividadePolimorfismo.atividadeEstoque;
import java.util.ArrayList;
import java.util.List;

abstract class Produto {
    protected String codigoBarras;
    protected String nome;
    protected int quantidadeEmEstoque;

    public Produto(String codigoBarras, String nome, int quantidadeEmEstoque) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getCodigoBarras() { return codigoBarras; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidadeEmEstoque; }
    
    public void adicionarEstoque(int qtd) { this.quantidadeEmEstoque += qtd; }
    public void subtrairEstoque(int qtd) { this.quantidadeEmEstoque -= qtd; }

    public abstract String getCategoria();
}