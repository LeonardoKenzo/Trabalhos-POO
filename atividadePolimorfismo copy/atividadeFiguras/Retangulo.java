public class Retangulo extends Figura {
  protected double alt;
  protected double larg;

  public Retangulo(boolean isPreenchida, String corDaFigura, double alt, double larg) {
    super(isPreenchida, corDaFigura);
    this.alt = alt;
    this.larg = larg;
  }

  @Override
  public double calcularPerimetro() {
    return 2.0 * (alt + larg);
  }

  @Override
  public double calcularArea() {
    return alt * larg;
  }
}

