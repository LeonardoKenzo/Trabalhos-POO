public abstract class Figura {
    protected String cor;
    protected boolean filled;

    public Figura(String cor, boolean filled) {
        this.cor = cor;
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimetro();
}