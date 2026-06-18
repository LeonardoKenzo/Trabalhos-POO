public class MainAgenda 
{
    public static void main(String[] args) 
    {
        Agenda minhaAgenda = new Agenda();
        
        minhaAgenda.inserir(new PessoaJuridica("Rua A", "empresa@mail.com", "Empresa Alpha", "88888", "Alpha SA", "ISENT"));
        minhaAgenda.inserir(new PessoaFisica("Rua B", "bruno@mail.com", "Bruno", "55555", "Solteiro", "12/12/1999"));
        minhaAgenda.inserir(new PessoaFisica("Rua C", "aline@mail.com", "Aline", "22222", "Casada", "01/01/1990"));

        System.out.println("### BASE DESORDENADA ###");
        minhaAgenda.exibirAgenda();

        minhaAgenda.ordena();
        
        System.out.println("\n### BASE ORDENADA ###");
        minhaAgenda.exibirAgenda();
    }
}