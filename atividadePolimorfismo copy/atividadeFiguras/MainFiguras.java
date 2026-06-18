public class MainFiguras {
  public static void main(String[] args) {
    Figura[] vetorFiguras = new Figura[] {
      new Retangulo(false, "Cinza", 8.0, 4.0),
      new Quadrado(true, "Branco", 5.0),
      new Circulo(true, "Rosa", 2.5)
    };

    for (Figura fig : vetorFiguras) {
      System.out.printf("A forma %s possui %.2f de área e %.2f de perímetro.\n", 
                        fig.getClass().getSimpleName(), 
                        fig.calcularArea(), 
                        fig.calcularPerimetro());
    }
  }
}