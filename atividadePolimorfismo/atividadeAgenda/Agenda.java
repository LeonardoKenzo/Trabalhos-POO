package atividadePolimorfismo;
import java.util.ArrayList;
import java.util.List;

class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionar(Contato c) { contatos.add(c); }

    public void remover(Contato c) { contatos.remove(c); }

    public Contato buscarPorNome(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        }
        return null;
    }

    public void visualizarTodos() {
        for (Contato c : contatos) {
            System.out.println(c.toString());
        }
    }

    // Bubble Sort
    public void ordena() {
        int n = contatos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Contato c1 = contatos.get(j);
                Contato c2 = contatos.get(j + 1);

                boolean deveTrocar = false;
                
                // Pessoa Física vem antes de Jurídica
                if (!c1.isPessoaFisica() && c2.isPessoaFisica()) {
                    deveTrocar = true;
                } 
                // Se forem do mesmo tipo, ordena por CPF/CNPJ
                else if (c1.isPessoaFisica() == c2.isPessoaFisica()) {
                    if (c1.getIdentificador().compareTo(c2.getIdentificador()) > 0) {
                        deveTrocar = true;
                    }
                }

                if (deveTrocar) {
                    contatos.set(j, c2);
                    contatos.set(j + 1, c1);
                }
            }
        }
    }
}