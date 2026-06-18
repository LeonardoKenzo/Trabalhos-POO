package atividadePolimorfismo.atividadeEstoque;
import java.util.ArrayList;
import java.util.List;
public abstract class Produto {
    protected String codigoBarras;
    protected String nome;

    public Produto(String codigoBarras, String nome) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
    }
    public String getCodigoBarras() { return codigoBarras; }
    public String getNome() { return nome; }
    public abstract String getCategoria();
}

public class Livro extends Produto {
    public Livro(String codigoBarras, String nome) { super(codigoBarras, nome); }
    @Override public String getCategoria() { return "Livro"; }
}

public class CD extends Produto {
    public CD(String codigoBarras, String nome) { super(codigoBarras, nome); }
    @Override public String getCategoria() { return "CD"; }
}

public class DVD extends Produto {
    public DVD(String codigoBarras, String nome) { super(codigoBarras, nome); }
    @Override public String getCategoria() { return "DVD"; }
}