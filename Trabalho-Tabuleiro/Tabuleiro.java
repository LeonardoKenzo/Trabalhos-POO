public class Tabuleiro {
    private int length;
    private int table[][];

    public Tabuleiro(int length, int table[][]) {
        this.length = length;
        this.table = table;
    }
    
    public boolean up(int linha, int coluna){
        if(isInTable(linha, coluna, length) && isInTable(linha + 1, coluna, length)){
            swapTable(linha, coluna, linha + 1, coluna);
            return true;
        }
        return false;
    }

    public boolean right(int linha, int coluna){
        if(isInTable(linha, coluna, length) && isInTable(linha, coluna - 1, length)){
            swapTable(linha, coluna, linha, coluna - 1);
            return true;
        }
        return false;
    }

    public boolean left(int linha, int coluna){
        if(isInTable(linha, coluna, length) && isInTable(linha, coluna + 1, length)){
            swapTable(linha, coluna, linha, coluna + 1);
            return true;
        }
        return false;
    }

    public boolean down(int linha, int coluna){
        if(isInTable(linha, coluna, length) && isInTable(linha - 1, coluna, length)){
            swapTable(linha, coluna, linha - 1, coluna);
            return true;
        }
        return false;
    }

    public void printTable(){
        for(int linha = 0; linha < length + 1; linha++){
            for(int coluna = 0; coluna < length; coluna++){
                if(coluna == length -1)
                    System.out.println("+------+");
                else
                    System.out.printf("+------");
            }
            if(linha < length){
                for(int coluna = 0; coluna < length; coluna++){
                    System.out.printf("| %3d  ", table[linha][coluna]);
                }
                System.out.println("|");
            }
        }
        System.out.println();
    }

    public boolean isSolved(){
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (table[i][j] != count){
                    return false;
                }
                count++;
            }
        }
        return true;
    }
    
    private boolean isInTable(int linha, int coluna, int length){
        return !(linha >= length || linha < 0 || coluna >= length || coluna < 0);
    }

    private void swapTable(int linha1, int coluna1, int linha2, int coluna2){
        int temp = table[linha1][coluna1];
        table[linha1][coluna1] = table[linha2][coluna2];
        table[linha2][coluna2] = temp;
    }
}
