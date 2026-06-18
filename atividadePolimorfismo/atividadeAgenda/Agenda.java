package atividadePolimorfismo;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionar(Contato c) { contatos.add(c); }
    public void remover(Contato c) { contatos.remove(c); }
    
    public void visualizarTodos() {
        for (Contato c : contatos) c.imprimir();
    }

    public Contato pesquisar(String termo) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(termo) || c.getId().equals(termo)) return c;
        }
        return null;
    }

    public void ordena() {
        int n = contatos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (deveTrocar(contatos.get(j), contatos.get(j + 1))) {
                    Contato temp = contatos.get(j);
                    contatos.set(j, contatos.get(j + 1));
                    contatos.set(j + 1, temp);
                }
            }
        }
    }

    private boolean deveTrocar(Contato c1, Contato c2) {
        boolean isC1Fisica = c1 instanceof PessoaFisica;
        boolean isC2Fisica = c2 instanceof PessoaFisica;
        
        if (isC1Fisica && !isC2Fisica) return false;
        if (!isC1Fisica && isC2Fisica) return true;
        
        return c1.getId().compareTo(c2.getId()) > 0;
    }
}