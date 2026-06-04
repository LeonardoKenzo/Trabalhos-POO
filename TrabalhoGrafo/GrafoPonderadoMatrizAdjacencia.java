// Leonardo Kenzo Tanaka - 16882154
// Pedro Teidi de Sá Yamacita - 16897290

import java.util.ArrayList;
import java.util.Collections;

public class GrafoPonderadoMatrizAdjacencia extends Grafo {
    private ArrayList<ArrayList<Integer>> matriz;

    public GrafoPonderadoMatrizAdjacencia(){
        this.matriz = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    @Override
    public void adicionarVertice(String vertice) {
        vertices.add(vertice);

        // Adiciona uma nova coluna para cada linha existente
        for (ArrayList<Integer> linha : matriz){
            linha.add(-1);
        }

        // Adiciona uma nova linha do novo vertice
        ArrayList<Integer> novaLinha = new ArrayList<>();
        for (int i = 0; i < matriz.size() + 1; i++){
            novaLinha.add(-1); // -1 indica ausência de aresta
        }
        matriz.add(novaLinha);
    }

    @Override
    public void removerVertice(String vertice) {

        int index = vertices.indexOf(vertice);
        if (index != -1){

            // Remove a linha correspondente ao vertice
            matriz.remove(index);
            
            // Remove a coluna correspondente ao vertice
            for (ArrayList<Integer> linha : matriz){
                linha.remove(index);
            }

            // Remove o vertice da lista de vertices
            vertices.remove(vertice);
        }
    }

    @Override
    public void adicionarAresta(String origem, String destino) {
        adicionarAresta(origem, destino, 1); // Peso padrão de 1 para arestas não ponderadas
    }

    public void adicionarAresta(String origem, String destino, int peso) {
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);

        if (indexOrigem != -1 && indexDestino != -1){
            matriz.get(indexOrigem).set(indexDestino, peso);
            matriz.get(indexDestino).set(indexOrigem, peso);
        }
    }

    @Override
    public void removerAresta(String origem, String destino) {
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);

        if (indexOrigem != -1 && indexDestino != -1){
            matriz.get(indexOrigem).set(indexDestino, -1);
            matriz.get(indexDestino).set(indexOrigem, -1);
        }
    }
    
    @Override
    public boolean existeVertice(String vertice) {
        return vertices.contains(vertice);
    }

    @Override
    public boolean existeAresta(String origem, String destino) {
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);

        if (indexOrigem != -1 && indexDestino != -1){
            return matriz.get(indexOrigem).get(indexDestino) != -1;
        }

        return false;   
    }

    @Override
    public int grau(String vertice) {
        int index = vertices.indexOf(vertice);

        // Se o vertice existir
        if (index != -1){
            int grau = 0;
            for (int valor : matriz.get(index)){
                if (valor != -1)
                    grau++;
            }
            return grau;
        }

        return -1;// Retorna -1 se o vertice não existir
    }

    @Override
    public int ordem() {
        return vertices.size();
    }

    @Override
    public int tamanho() {
        int tamanho = 0;
        for (ArrayList<Integer> linha : matriz){
            for (int valor : linha){
                if (valor != -1)
                    tamanho++;
            }
        }

        return tamanho / 2; // Cada aresta é contada duas vezes
    }

    @Override
    public String toString() {

        ArrayList<String> arestas = new ArrayList<>();
        ArrayList<String> verticesIsolados = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i + 1; j < vertices.size(); j++) {

                if (matriz.get(i).get(j) != -1) {

                    String v1 = vertices.get(i);
                    String v2 = vertices.get(j);

                    if(v1.compareTo(v2) < 0){
                        arestas.add(
                            "\"" + v1 + "\" -- \"" + v2 + "\" [label=\"" + matriz.get(i).get(j) + "\"];"
                        );
                    }
                    else {
                        arestas.add(
                            "\"" + v2 + "\" -- \"" + v1 + "\" [label=\"" + matriz.get(i).get(j) + "\"];"
                        );
                    }
                }
            }

            boolean isIsolated = true;
            for(int j = 0; j < vertices.size(); j++){
                if(matriz.get(i).get(j) != -1){
                    isIsolated = false;
                    break;
                }
            }

            if(isIsolated){
                verticesIsolados.add(
                    "\"" + vertices.get(i) + "\";"
                );
            }
        }

        Collections.sort(arestas);
        Collections.sort(verticesIsolados);

        StringBuilder sb = new StringBuilder();

        sb.append("graph {\n");

        for(String vertice : verticesIsolados){
            sb.append("    ").append(vertice).append("\n");
        }
        for (String aresta : arestas) {
            sb.append("    ").append(aresta).append("\n");
        }

        sb.append("}");

        return sb.toString();
    }
}