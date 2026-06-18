package atividadePolimorfismo;
import java.util.ArrayList;
import java.util.List;

// Subclasse PF
public class PessoaFisica extends Contato {
    private String cpf;
    private String dataNascimento;
    private String estadoCivil;

    public PessoaFisica(String nome, String endereco, String email, String cpf, String dataNascimento, String estadoCivil) {
        super(nome, endereco, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String getId() { return cpf; }

    @Override
    public void imprimir() {
        System.out.println("PF: " + nome + " | CPF: " + cpf);
    }
}