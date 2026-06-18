package atividadePolimorfismo;
import java.util.ArrayList;
import java.util.List;

// Subclass PJ
public class PessoaJuridica extends Contato {
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;

    public PessoaJuridica(String nome, String endereco, String email, String cnpj, String inscricaoEstadual, String razaoSocial) {
        super(nome, endereco, email);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String getId() { return cnpj; }

    @Override
    public void imprimir() {
        System.out.println("PJ: " + nome + " | CNPJ: " + cnpj);
    }
}