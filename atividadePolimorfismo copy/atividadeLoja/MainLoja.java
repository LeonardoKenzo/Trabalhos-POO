public class MainLoja {
    public static void main(String[] args) {
        Loja sistemaLoja = new Loja();
        
        Livro livroJava = new Livro("Java Patterns", "LIV-01");
        CD cdBanda = new CD("Acústico MTV", "CD-02");
        DVD filmeAcao = new DVD("Duro de Matar", "DVD-03");

        sistemaLoja.adicionarProduto(livroJava, 20);
        sistemaLoja.adicionarProduto(cdBanda, 15);
        sistemaLoja.adicionarProduto(filmeAcao, 3);

        // Realizando algumas vendas
        sistemaLoja.vender("LIV-01");
        sistemaLoja.vender("DVD-03");

        sistemaLoja.imprimirEstoque();
    }
}