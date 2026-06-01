import java.util.ArrayList;

public abstract class Grafo {
    protected ArrayList<String> vertices;

    public abstract void adicionarVertice(String vertice);
    public abstract void removerVertice(String vertice);
    public abstract void adicionarAresta(String origem, String destino);
    public abstract void removerAresta(String origem, String destino);
    public abstract boolean existeVertice(String vertice);
    public abstract boolean existeAresta(String origem, String destino);
    public abstract int grau(String vertice);
    public abstract int ordem();
    public abstract int tamanho();
    public abstract String toString();
}