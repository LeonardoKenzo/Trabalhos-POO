import java.util.HashMap;

public class Loja {
    
    // Classe interna auxiliar para gerenciar o saldo
    private class InfoEstoque {
        Produto item;
        int quantidadeEmEstoque;

        InfoEstoque(Produto item, int quantidadeEmEstoque) {
            this.item = item;
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }
    }

    private HashMap<String, InfoEstoque> mapaDeEstoque;

    public Loja() {
        this.mapaDeEstoque = new HashMap<>();
    }

    public void adicionarProduto(Produto prod, int qtd) {
        String chave = prod.getCodBarras();
        if (mapaDeEstoque.containsKey(chave)) {
            mapaDeEstoque.get(chave).quantidadeEmEstoque += qtd;
        } else {
            mapaDeEstoque.put(chave, new InfoEstoque(prod, qtd));
        }
    }

    public boolean vender(String codBuscado) {
        if (mapaDeEstoque.containsKey(codBuscado)) {
            InfoEstoque info = mapaDeEstoque.get(codBuscado);
            if (info.quantidadeEmEstoque > 0) {
                info.quantidadeEmEstoque--;
                return true;
            }
        }
        return false;
    }

    public Produto buscarPorCodigo(String codBuscado) {
        if (mapaDeEstoque.containsKey(codBuscado)) {
            return mapaDeEstoque.get(codBuscado).item;
        }
        return null;
    }

    public void imprimirEstoque() {
        HashMap<String, Integer> totaisPorTipo = new HashMap<>();
        
        System.out.println("========== ITENS DISPONÍVEIS ==========");
        for (InfoEstoque info : mapaDeEstoque.values()) {
            Produto p = info.item;
            System.out.println("=> " + p.getNomeProduto() + " | Saldo: " + info.quantidadeEmEstoque);
            
            String categoria = p.tipoProduto();
            totaisPorTipo.put(categoria, totaisPorTipo.getOrDefault(categoria, 0) + info.quantidadeEmEstoque);
        }
        
        System.out.println("\n========== TOTAIS CATEGORIAS ==========");
        for (String cat : totaisPorTipo.keySet()) {
            System.out.println(cat + " -> " + totaisPorTipo.get(cat) + " un.");
        }
    }
}