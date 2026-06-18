public class PessoaJuridica extends Contato 
{
    private String numeroCnpj;
    private String razaoSocial;
    private String inscEstadual;

    public PessoaJuridica(String endereco, String email, String nome, 
                          String cnpj, String razaoSocial, String inscEstadual) 
    {
        super(endereco, email, nome);
        this.numeroCnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscEstadual = inscEstadual;
    }

    @Override
    public String obterDocumento() 
    { 
        return numeroCnpj; 
    }

    @Override
    public void imprimirDetalhes() 
    {
        System.out.println("PJ -> " + nomeContato + " | Doc: " + numeroCnpj);
    }
}