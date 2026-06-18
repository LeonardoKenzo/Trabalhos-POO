package atividadePolimorfismo.atividadeEstoque;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Loja {
    // Mapeia Codigo de Barras -> Array contendo [Produto, Quantidade]
    private Map<String, Object[]> estoque = new HashMap<>();

    public void adicionarProduto(Produto p, int quantidade) {
        if (estoque.containsKey(p.getCodigoBarras())) {
            int qtdAtual = (int) estoque.get(p.getCodigoBarras())[1];
            estoque.put(p.getCodigoBarras(), new Object[]{p, qtdAtual + quantidade});
        } else {
            estoque.put(p.getCodigoBarras(), new Object[]{p, quantidade});
        }
    }

    public Produto buscarPorCodigo(String codigo) {
        if (estoque.containsKey(codigo)) return (Produto) estoque.get(codigo)[0];
        return null;
    }

    public boolean vender(String codigo) {
        if (estoque.containsKey(codigo)) {
            int qtdAtual = (int) estoque.get(codigo)[1];
            if (qtdAtual > 0) {
                estoque.put(codigo, new Object[]{estoque.get(codigo)[0], qtdAtual - 1});
                return true;
            }
        }
        return false;
    }

    public void imprimirEstoque() {
        Map<String, Integer> porCategoria = new HashMap<>();
        System.out.println("--- Estoque por Produto ---");
        for (Object[] dados : estoque.values()) {
            Produto p = (Produto) dados[0];
            int qtd = (int) dados[1];
            System.out.println(p.getNome() + " (" + p.getCategoria() + ") - Qtd: " + qtd);
            
            porCategoria.put(p.getCategoria(), porCategoria.getOrDefault(p.getCategoria(), 0) + qtd);
        }
        System.out.println("--- Estoque por Categoria ---");
        for (Map.Entry<String, Integer> entry : porCategoria.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}