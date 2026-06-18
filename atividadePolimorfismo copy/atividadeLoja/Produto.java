public abstract class Produto {
    protected String nomeProduto;
    protected String codBarras;

    public Produto(String nomeProduto, String codBarras) {
        this.nomeProduto = nomeProduto;
        this.codBarras = codBarras;
    }
    
    public abstract String tipoProduto();
    
    public String getCodBarras() { return codBarras; }
    public String getNomeProduto() { return nomeProduto; }
}

public class Livro extends Produto {
    public Livro(String nome, String cod) { super(nome, cod); }
    @Override public String tipoProduto() { return "Categoria: Livros"; }
}

public class CD extends Produto {
    public CD(String nome, String cod) { super(nome, cod); }
    @Override public String tipoProduto() { return "Categoria: CDs"; }
}

public class DVD extends Produto {
    public DVD(String nome, String cod) { super(nome, cod); }
    @Override public String tipoProduto() { return "Categoria: DVDs"; }
}