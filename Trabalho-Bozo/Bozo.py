from random import Random

class Dice:
    DICE = {
        1: ["+-----+",
            "|     |",
            "|  *  |",
            "|     |",
            "+-----+"],

        2: ["+-----+",
            "|*    |",
            "|     |",
            "|    *|",
            "+-----+"],

        3: ["+-----+",
            "|*    |",
            "|  *  |",
            "|    *|",
            "+-----+"],

        4: ["+-----+",
            "|*   *|",
            "|     |",
            "|*   *|",
            "+-----+"],

        5: ["+-----+",
            "|*   *|",
            "|  *  |",
            "|*   *|",
            "+-----+"],

        6: ["+-----+",
            "|* * *|",
            "|     |",
            "|* * *|",
            "+-----+"],
    }

    def __init__(self, seed):
        self.dice_rngs = []

        if seed != 0:
            rd = Random()
            rd.seed(seed)

            for _ in range(5):
                sub_seed = rd.randint(1, 10000)
                self.dice_rngs.append(Random(sub_seed))
        else:
            for _ in range(5):
                self.dice_rngs.append(Random())
        self.dice = self.roll()

    def roll(self):
        return [rng.randint(1, 6) for rng in self.dice_rngs]

    def reroll(self, dice, indexes):
        indexes = sorted(indexes)
        
        for i in indexes:
            if 0 <= i < 5:
                dice[i] = self.dice_rngs[i].randint(1, 6)
        return dice

    def render(self, dice):
        print("1          2          3          4          5")
        for i in range(5):
            print("    ".join(self.DICE[dice[j]][i] for j in range(5)))

class Board:
    def __init__(self):
        self.slots = ["(" + str(i) + ")" for i in range(1, 11)]

    def display(self):
        s = self.slots
        print(f"{s[0]:^4}   |   {s[6]:^4}   |  {s[3]:^4}")
        print("-------|----------|-------")
        print(f"{s[1]:^4}   |   {s[7]:^4}   |  {s[4]:^4}")
        print("-------|----------|-------")
        print(f"{s[2]:^4}   |   {s[8]:^4}   |  {s[5]:^4}")
        print("-------|----------|-------")
        print(f"       |   {s[9]:^4}   |")
        print("       +----------+\n")

    def place(self, pos, value):
        if self.slots[pos - 1] != "(" + str(pos) + ")":
            return False
        self.slots[pos - 1] = str(value)
        return True

    def score(self):
        return sum(int(x) for x in self.slots if x.isdigit())


class BozoGame:
    def __init__(self, seed=0):
        self.dice = Dice(seed)
        self.board = Board()

    def play_round(self, round_number):
        print(f"****** Rodada {round_number}")

        input("Pressione ENTER para lançar os dados\n")

        dice = self.dice.roll()
        self.dice.render(dice)

        for _ in range(2):
            choice = input(
                "\nDigite os números dos dados que quiser TROCAR. Separados por espaços.\n"
            )

            indexes = InputHandler.parse_indexes(choice)
            if indexes:
                dice = self.dice.reroll(dice, indexes)

            self.dice.render(dice)
        
        print("\n\n\n")
        self.board.display()

        while True:
            try:
                pos_input = input("Escolha a posição que quer ocupar com essa jogada ===> ")
                pos = InputHandler.parse_position(pos_input)
                if pos is not None:
                    pontuacao = self.get_score(pos, dice)
                    if self.board.place(pos, pontuacao):
                        print("\n\n")
                        self.board.display()
                        break
                print("Valor inválido. Posição ocupada ou inexistente.")
            except:
                print("Entrada inválida.")

    def get_score(self, pos, dice):
        if 1 <= pos <= 6:
            return dice.count(pos) * pos
        elif pos == 7:
            counts = [dice.count(x) for x in range(1, 7)]
            if (3 in counts and 2 in counts) or (5 in counts):
                return 15
            return 0
        elif pos == 8:
            if sorted(set(dice)) in [[1, 2, 3, 4, 5], [2, 3, 4, 5, 6]]:
                return 20
            return 0
        elif pos == 9:
            counts = [dice.count(x) for x in range(1, 7)]
            if any(c >= 4 for c in counts):
                return 30
            return 0
        elif pos == 10:
            counts = [dice.count(x) for x in range(1, 7)]
            if 5 in counts:
                return 40
            return 0
        return 0

    def play(self):
        self.board.display()

        for i in range(1, 11):
            self.play_round(i)

        print("***********************************")
        print("***")
        print("*** Seu escore final foi:", self.board.score())
        print("***")
        print("***********************************")

class InputHandler:
    @staticmethod
    def parse_indexes(text, max_value=5):
        try:
            numbers = []
            for part in text.split():
                if part.isdigit():
                    n = int(part)
                    # Verifica o limite E se o índice já não foi adicionado (evita repetidos)
                    if 1 <= n <= max_value and (n - 1) not in numbers:
                        numbers.append(n - 1)
            return numbers
        except:
            return []

    @staticmethod
    def parse_position(text):
        try:
            if text.strip().isdigit():
                return int(text)
        except:
            pass
        return None