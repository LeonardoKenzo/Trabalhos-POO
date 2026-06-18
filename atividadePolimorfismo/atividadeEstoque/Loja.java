package atividadePolimorfismo.atividadeEstoque;
import java.util.ArrayList;
import java.util.List;

class Loja {
    private List<Produto> estoque = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        Produto existente = buscarPorCodigo(p.getCodigoBarras());
        if (existente != null) {
            existente.adicionarEstoque(p.getQuantidade());
        } else {
            estoque.add(p);
        }
    }

    public Produto buscarPorCodigo(String codigo) {
        for (Produto p : estoque) {
            if (p.getCodigoBarras().equals(codigo)) return p;
        }
        return null;
    }

    public void venderProduto(String codigo, int quantidade) {
        Produto p = buscarPorCodigo(codigo);
        if (p != null && p.getQuantidade() >= quantidade) {
            p.subtrairEstoque(quantidade);
            System.out.println("Venda realizada: " + p.getNome());
        } else {
            System.out.println("Estoque insuficiente ou produto não encontrado.");
        }
    }

    public void verificarEstoque() {
        System.out.println("--- RELATÓRIO DE ESTOQUE ---");
        int totalLivros = 0, totalCDs = 0, totalDVDs = 0;

        for (Produto p : estoque) {
            System.out.println(p.getNome() + " (" + p.getCategoria() + "): " + p.getQuantidade() + " unidades.");
            
            // Contabilização por categoria 
            switch (p.getCategoria()) {
                case "Livros": totalLivros += p.getQuantidade(); break;
                case "CDs": totalCDs += p.getQuantidade(); break;
                case "DVDs": totalDVDs += p.getQuantidade(); break;
            }
        }
        
        System.out.println("\nResumo por Categoria:");
        System.out.println("Livros: " + totalLivros);
        System.out.println("CDs: " + totalCDs);
        System.out.println("DVDs: " + totalDVDs);
    }
}