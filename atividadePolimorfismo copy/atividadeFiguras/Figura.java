public abstract class Figura {
  protected String corDaFigura;
  protected boolean isPreenchida;

  public Figura(boolean isPreenchida, String corDaFigura) {
    this.isPreenchida = isPreenchida;
    this.corDaFigura = corDaFigura;
  }

  public abstract double calcularArea();
  public abstract double calcularPerimetro();
}