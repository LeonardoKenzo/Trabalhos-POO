class Tabuleiro:
    def __init__(self, length, table):
        self.length = length
        self.table = table

    def up(self, linha, coluna):
        if self.is_in_table(linha, coluna) and self.is_in_table(linha + 1, coluna):
            self.swap_table(linha, coluna, linha + 1, coluna)
            return True
        return False

    def right(self, linha, coluna):
        if self.is_in_table(linha, coluna) and self.is_in_table(linha, coluna - 1):
            self.swap_table(linha, coluna, linha, coluna - 1)
            return True
        return False

    def left(self, linha, coluna):
        if self.is_in_table(linha, coluna) and self.is_in_table(linha, coluna + 1):
            self.swap_table(linha, coluna, linha, coluna + 1)
            return True
        return False

    def down(self, linha, coluna):
        if self.is_in_table(linha, coluna) and self.is_in_table(linha - 1, coluna):
            self.swap_table(linha, coluna, linha - 1, coluna)
            return True
        return False

    def print_table(self):
        for linha in range(self.length + 1):
            for coluna in range(self.length):
                if coluna == self.length - 1:
                    print("+------+" , end="\n")
                else:
                    print("+------", end="")
            if linha < self.length:
                for coluna in range(self.length):
                    if self.table[linha][coluna] == 0:
                        print("|      ", end="")
                    else:
                        print(f"| {self.table[linha][coluna]:3d}  ", end="")
                print("|")
        print()

    def is_solved(self):
        count = 0
        for i in range(self.length):
            for j in range(self.length):
                if self.table[i][j] != count:
                    return False
                count += 1
        return True

    def is_in_table(self, linha, coluna):
        return not (linha >= self.length or linha < 0 or coluna >= self.length or coluna < 0)

    def swap_table(self, linha1, coluna1, linha2, coluna2):
        self.table[linha1][coluna1], self.table[linha2][coluna2] = (
            self.table[linha2][coluna2],
            self.table[linha1][coluna1],
        )