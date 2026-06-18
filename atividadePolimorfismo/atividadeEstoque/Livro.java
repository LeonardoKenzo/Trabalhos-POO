package atividadePolimorfismo.atividadeEstoque;
import java.util.ArrayList;
import java.util.List;

class Livro extends Produto {
    public Livro(String codigoBarras, String nome, int quantidadeEmEstoque) {
        super(codigoBarras, nome, quantidadeEmEstoque);
    }
    @Override
    public String getCategoria() { return "Livros"; }
}