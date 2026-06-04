// Leonardo Kenzo Tanaka - 16882154
// Pedro Teidi de Sá Yamacita - 16897290

import java.util.ArrayList;
import java.util.Collections;

public class GrafoListaAdjacencia extends Grafo {
    private ArrayList<ArrayList<String>> listaAdjacencia;

    public GrafoListaAdjacencia() {
        vertices = new ArrayList<>();
        listaAdjacencia = new ArrayList<>();
    }

    @Override
    public void adicionarVertice(String vertice) {
        if(vertices.contains(vertice)){
            return; // Evita adicionar vértices duplicados
        }
        vertices.add(vertice);
        listaAdjacencia.add(new ArrayList<>());
    }

    @Override
    public void removerVertice(String vertice) {

        int index = vertices.indexOf(vertice);
        if (index != -1){
    
            // Remove a coluna correspondente ao vertice
            for (ArrayList<String> vizinhos : listaAdjacencia){
                vizinhos.remove(vertice);
            }
            
            // Remove o vertice da lista de vertices
            vertices.remove(vertice);
            listaAdjacencia.remove(index);
        }
    }

    @Override
    public void adicionarAresta(String origem, String destino) {
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);

        if (indexOrigem == -1 && indexDestino == -1){
            return;
        }

        if(!listaAdjacencia.get(indexOrigem).contains(destino)){
            listaAdjacencia.get(indexOrigem).add(destino);
        }

        if(!listaAdjacencia.get(indexDestino).contains(origem)){
            listaAdjacencia.get(indexDestino).add(origem);
        }

    }

    @Override
    public void removerAresta(String origem, String destino) {
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);

        if (indexOrigem != -1 && indexDestino != -1){
            listaAdjacencia.get(indexOrigem).remove(destino);
            listaAdjacencia.get(indexDestino).remove(origem);
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
            return listaAdjacencia.get(indexOrigem).contains(destino);
        }

        return false;   
    }

    @Override
    public int grau(String vertice) {
        int index = vertices.indexOf(vertice);

        // Se o vertice existir
        if (index != -1){
            return listaAdjacencia.get(index).size();
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
        for (ArrayList<String> linha : listaAdjacencia){
            tamanho += linha.size();
        }

        return tamanho / 2; // Cada aresta é contada duas vezes
    }

    @Override
    public String toString() {

        ArrayList<String> arestas = new ArrayList<>();
        ArrayList<String> verticesIsolados = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {

            String origem = vertices.get(i);

            if(listaAdjacencia.get(i).isEmpty()){
                verticesIsolados.add(
                    "\"" + origem + "\";"
                );
                continue;
            }

            for (String destino : listaAdjacencia.get(i)) {

                if (origem.compareTo(destino) < 0) {
                    arestas.add(
                        "\"" + origem + "\" -- \"" + destino + "\";"
                    );
                }
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
