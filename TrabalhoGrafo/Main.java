import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GrafoListaAdjacencia grafoLista = new GrafoListaAdjacencia();
        GrafoMatrizAdjacencia grafoMatriz = new GrafoMatrizAdjacencia();
        GrafoPonderadoMatrizAdjacencia grafoPonderado = new GrafoPonderadoMatrizAdjacencia();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String comando = sc.nextLine();
            
            if (comando.isEmpty()) {
                continue;
            }

            String[] partes = comando.split(" ");

            switch (partes[0]) {

                case "i":

                    String v1 = partes[1];
                    String v2 = partes[2];
                    int peso = Integer.parseInt(partes[3]);

                    // cria vértices

                    if (!grafoLista.existeVertice(v1)) {
                        grafoLista.adicionarVertice(v1);
                    }

                    if (!grafoLista.existeVertice(v2)) {
                        grafoLista.adicionarVertice(v2);
                    }

                    if (!grafoMatriz.existeVertice(v1)) {
                        grafoMatriz.adicionarVertice(v1);
                    }

                    if (!grafoMatriz.existeVertice(v2)) {
                        grafoMatriz.adicionarVertice(v2);
                    }

                    if (!grafoPonderado.existeVertice(v1)) {
                        grafoPonderado.adicionarVertice(v1);
                    }

                    if (!grafoPonderado.existeVertice(v2)) {
                        grafoPonderado.adicionarVertice(v2);
                    }

                    // adiciona arestas

                    grafoLista.adicionarAresta(v1, v2);
                    grafoMatriz.adicionarAresta(v1, v2);
                    grafoPonderado.adicionarAresta(v1, v2, peso);

                    break;

                case "d":

                    if (partes.length == 2) {

                        String vertice = partes[1];

                        grafoLista.removerVertice(vertice);
                        grafoMatriz.removerVertice(vertice);
                        grafoPonderado.removerVertice(vertice);

                    } else if (partes.length == 3) {

                        String origem = partes[1];
                        String destino = partes[2];

                        grafoLista.removerAresta(origem, destino);
                        grafoMatriz.removerAresta(origem, destino);
                        grafoPonderado.removerAresta(origem, destino);
                    }

                    break;

                case "p":

                    System.out.println("Lista de Adjacencia");
                    System.out.println(grafoLista.toString());
                    
                    System.out.println("Matriz de Adjacencia");
                    System.out.println(grafoMatriz.toString());

                    System.out.println("Ponderado - Matriz de Adjacencia");
                    System.out.println(grafoPonderado.toString());

                    break;
                }
        }

        sc.close();

    }
}
