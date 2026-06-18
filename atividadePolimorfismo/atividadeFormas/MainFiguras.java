public class MainFiguras {
    public static void main(String[] args) {
        Figura[] figuras = {
            new Circulo("Vermelho", true, 5.0),
            new Retangulo("Azul", false, 4.0, 6.0),
            new Quadrado("Verde", true, 3.0)
        };

        for (Figura f : figuras) {
            System.out.println("Classe: " + f.getClass().getSimpleName() + 
                               " | Area: " + String.format("%.2f", f.getArea()) + 
                               " | Perimetro: " + String.format("%.2f", f.getPerimetro()));
        }
    }
}