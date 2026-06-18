public class Retangulo extends Figura {
    protected double largura;
    protected double altura;

    public Retangulo(String cor, boolean filled, double largura, double altura) {
        super(cor, filled);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double getArea() { return largura * altura; }

    @Override
    public double getPerimetro() { return 2 * (largura + altura); }
}

