public class Circulo extends Figura {
    private double raio;

    public Circulo(String cor, boolean filled, double raio) {
        super(cor, filled);
        this.raio = raio;
    }

    @Override
    public double getArea() { return Math.PI * raio * raio; }

    @Override
    public double getPerimetro() { return 2 * Math.PI * raio; }
}