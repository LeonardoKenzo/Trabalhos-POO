package atividadePolimorfismo.atividadeEstoque;
import java.util.ArrayList;
import java.util.List;

class DVD extends Produto {
    public DVD(String codigoBarras, String nome, int quantidadeEmEstoque) {
        super(codigoBarras, nome, quantidadeEmEstoque);
    }
    @Override
    public String getCategoria() { return "DVDs"; }
}