package atividadePolimorfismo.atividadeEstoque;
import java.util.ArrayList;
import java.util.List;

class CD extends Produto {
    public CD(String codigoBarras, String nome, int quantidadeEmEstoque) {
        super(codigoBarras, nome, quantidadeEmEstoque);
    }
    @Override
    public String getCategoria() { return "CDs"; }
}
