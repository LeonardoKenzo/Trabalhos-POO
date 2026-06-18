import java.util.ArrayList;

public class Agenda 
{
    private ArrayList<Contato> baseDeContatos = new ArrayList<>();

    public void inserir(Contato novo) { 
        baseDeContatos.add(novo); 
    }

    public void excluir(Contato alvo) { 
        baseDeContatos.remove(alvo); 
    }
    
    public Contato buscar(String chave) 
    {
        for (Contato item : baseDeContatos) {
            if (item.getNome().equalsIgnoreCase(chave) || item.obterDocumento().equals(chave)) {
                return item;
            }
        }
        return null;
    }

    public void exibirAgenda() 
    {
        for (Contato item : baseDeContatos) {
            item.imprimirDetalhes();
        }
    }

    // Utilizando o algoritmo Selection Sort desta vez
    public void ordena() 
    {
        int tam = baseDeContatos.size();
        for (int i = 0; i < tam - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < tam; j++) {
                if (vemAntes(baseDeContatos.get(j), baseDeContatos.get(indiceMenor))) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                Contato temp = baseDeContatos.get(i);
                baseDeContatos.set(i, baseDeContatos.get(indiceMenor));
                baseDeContatos.set(indiceMenor, temp);
            }
        }
    }

    private boolean vemAntes(Contato c1, Contato c2) 
    {
        boolean c1EhFisica = c1 instanceof PessoaFisica;
        boolean c2EhFisica = c2 instanceof PessoaFisica;
        
        if (c1EhFisica && !c2EhFisica) return true;
        if (!c1EhFisica && c2EhFisica) return false;
        
        return c1.obterDocumento().compareTo(c2.obterDocumento()) < 0;
    }
}