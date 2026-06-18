package atividadePolimorfismo;
import java.util.ArrayList;
import java.util.List;

// Subclasse PF
class PessoaFisica extends Contato{
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
    public String getIdentificador() { return cpf; }

    @Override
    public boolean isPessoaFisica() { return true; }
}
