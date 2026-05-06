import math
from Tabuleiro import Tabuleiro

def main():
    # Lê os números do tabuleiro
    entrada_numeros = input()

    numeros = entrada_numeros.split()
    quantidade = len(numeros)
    length = int(math.sqrt(quantidade))

    # Cria a matriz
    table = [[0 for _ in range(length)] for _ in range(length)]

    # Preenche a matriz e encontra o 0
    linha_zero, coluna_zero = 0, 0
    for linha in range(length):
        for coluna in range(length):
            valor = int(numeros[linha * length + coluna])
            table[linha][coluna] = valor
            if valor == 0:
                linha_zero, coluna_zero = linha, coluna

    # Cria o tabuleiro
    tabuleiro = Tabuleiro(length, table)
    tabuleiro.print_table()

    # Lê os comandos
    comandos = input()

    # Executa os comandos
    for comando in comandos:
        if comando == 'u':
            if tabuleiro.up(linha_zero, coluna_zero):
                linha_zero += 1
        elif comando == 'd':
            if tabuleiro.down(linha_zero, coluna_zero):
                linha_zero -= 1
        elif comando == 'l':
            if tabuleiro.left(linha_zero, coluna_zero):
                coluna_zero += 1
        elif comando == 'r':
            if tabuleiro.right(linha_zero, coluna_zero):
                coluna_zero -= 1

        tabuleiro.print_table()

    # Verifica se está resolvido
    print(f"Posicao final: {tabuleiro.is_solved()}")


if __name__ == "__main__":
    main()