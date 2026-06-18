public class PessoaFisica extends Contato 
{
    private String numeroCpf;
    private String estadoCivil;
    private String dataNasc;

    public PessoaFisica(String endereco, String email, String nome, 
                        String cpf, String estadoCivil, String dataNasc) 
    {
        super(endereco, email, nome);
        this.numeroCpf = cpf;
        this.estadoCivil = estadoCivil;
        this.dataNasc = dataNasc;
    }

    @Override
    public String obterDocumento() 
    { 
        return numeroCpf; 
    }

    @Override
    public void imprimirDetalhes() 
    {
        System.out.println("PF -> " + nomeContato + " | Doc: " + numeroCpf);
    }
}