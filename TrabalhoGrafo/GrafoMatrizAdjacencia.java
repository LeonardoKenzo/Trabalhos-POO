import TrabalhoGrafo.Grafo;
import java.util.ArrayList;

public class GrafoMatrizAdjacencia extends Grafo{
    public GrafoMatrizAdjacencia(){
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
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);

        if (indexOrigem != -1 && indexDestino != -1){
            matriz.get(indexOrigem).set(indexDestino, 1);
            matriz.get(indexDestino).set(indexOrigem, 1);
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
            return matriz.get(indexOrigem).get(indexDestino) == 1;
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
                if (valor == 1)
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
                if (valor == 1)
                    tamanho++;
            }
        }

        return tamanho / 2; // Cada aresta é contada duas vezes
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("graph {\n");
        // Procura a aresta entre os vertices evitando repetições
        for (int i = 0; i < vertices.size(); i++){
            for (int j = i + 1; j < vertices.size(); j++){
                if (matriz.get(i).get(j) == 1){
                    sb.append(" \"").
                    append(vertices.get(i))
                    .append("\" -- \"")
                    .append(vertices.get(j))
                    .append("\";\n");
                }
            }
        }
        sb.append("}");

        return sb.toString();
    }
}
