package atividadePolimorfismo.atividadeEstoque;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MainLoja {
    public static void main(String[] args) {
        Loja loja = new Loja();
        
        Livro l1 = new Livro("123", "Java Como Programar");
        CD c1 = new CD("456", "Iron Maiden");
        DVD d1 = new DVD("789", "O Senhor dos Aneis");

        loja.adicionarProduto(l1, 5);
        loja.adicionarProduto(c1, 10);
        loja.adicionarProduto(d1, 2);

        loja.vender("123");
        loja.vender("123");

        loja.imprimirEstoque();
    }
}