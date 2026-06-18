package atividadePolimorfismo;
import java.util.ArrayList;
import java.util.List;

// Classe base
abstract class Contato {
    protected String nome;
    protected String endereco;
    protected String email;

    public Contato(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    public String getNome() { return nome; }

    public String getNome() { return nome; }
    public abstract String getId(); // Retorna CPF ou CNPJ
    public abstract void imprimir();
}
