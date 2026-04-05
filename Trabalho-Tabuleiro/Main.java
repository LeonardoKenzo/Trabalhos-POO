import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Para ler os inputs

        String entradaNumeros = sc.nextLine();// Le os numeros do tabuleiro

        // Calcula o tamanho do tabuleiro e cria a matriz
        String[] numeros = entradaNumeros.split(" ");
        int quantidade = numeros.length;
        int length = (int) Math.sqrt(quantidade);
        int table[][] = new int[length][length];

        // Preenche a matriz e encontra a posição do 0
        int linhaZero = 0, colunaZero = 0;
        for (int linha = 0; linha < length; linha++) {
            for (int coluna = 0; coluna < length; coluna++) {
                table[linha][coluna] = Integer.parseInt(numeros[linha * length + coluna]);
                if(table[linha][coluna] == 0){
                    linhaZero = linha;
                    colunaZero = coluna;
                }
            }
        }

        // Cria o tabuleiro
        Tabuleiro tabuleiro = new Tabuleiro(length, table);
        tabuleiro.printTable();

        String comandos = sc.nextLine(); // Le os comandos

        // Executa os comandos
        for (char comando : comandos.toCharArray()) {
            switch (comando) {
                case 'u':
                    if(tabuleiro.up(linhaZero, colunaZero))
                        linhaZero++;
                    break;
                case 'd':
                    if(tabuleiro.down(linhaZero, colunaZero))
                        linhaZero--;
                    break;
                case 'l':
                    if(tabuleiro.left(linhaZero, colunaZero))
                        colunaZero++;
                    break;
                case 'r':
                    if(tabuleiro.right(linhaZero, colunaZero))
                        colunaZero--;
                    break;
            }
            tabuleiro.printTable();
        }

        // Verifica se o tabuleiro está resolvido
        if (tabuleiro.isSolved()) {
            System.out.println("Posicao final: true");
        } else {
            System.out.println("Posicao final: false");
        }

        sc.close();
    }
}
