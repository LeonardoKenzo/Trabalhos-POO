from Bozo import BozoGame


def main():
    seed = int(input("Digite a semente (zero para aleatório): "))
    game = BozoGame(seed)
    game.play()


if __name__ == "__main__":
    main()