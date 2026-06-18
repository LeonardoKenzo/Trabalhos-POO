public class Circulo extends Figura {
  private double valorRaio;

  public Circulo(boolean isPreenchida, String corDaFigura, double valorRaio) {
    super(isPreenchida, corDaFigura);
    this.valorRaio = valorRaio;
  }

  @Override
  public double calcularPerimetro() {
    return Math.PI * 2.0 * valorRaio;
  }

  @Override
  public double calcularArea() {
    return Math.PI * valorRaio * valorRaio;
  }
}