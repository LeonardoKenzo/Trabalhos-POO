public abstract class Contato 
{
    protected String enderecoContato;
    protected String emailContato;
    protected String nomeContato;

    public Contato(String endereco, String email, String nome) 
    {
        this.enderecoContato = endereco;
        this.emailContato = email;
        this.nomeContato = nome;
    }

    public abstract void imprimirDetalhes();
    public abstract String obterDocumento();
    
    public String getNome() 
    { 
        return nomeContato; 
    }
}