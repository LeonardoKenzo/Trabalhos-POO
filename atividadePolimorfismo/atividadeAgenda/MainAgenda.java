package atividadePolimorfismo;
import java.util.ArrayList;
import java.util.List;


public class MainAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.adicionar(new PessoaJuridica("Empresa B", "Rua Y", "b@b.com", "22222", "IE2", "Empresa B SA"));
        agenda.adicionar(new PessoaFisica("Joao", "Rua X", "joao@a.com", "33333", "01/01/90", "Solteiro"));
        agenda.adicionar(new PessoaFisica("Maria", "Rua Z", "maria@a.com", "11111", "02/02/92", "Casada"));

        System.out.println("--- Antes da Ordenacao ---");
        agenda.visualizarTodos();

        agenda.ordena();
        System.out.println("\n--- Apos a Ordenacao ---");
        agenda.visualizarTodos();
    }
}