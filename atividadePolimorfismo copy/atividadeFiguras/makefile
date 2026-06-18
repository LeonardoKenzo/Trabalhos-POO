CC = javac
FLAGS = -g
ARQUIVOS = Figura.java Circulo.java Retangulo.java Quadrado.java MainFiguras.java

all: compilar

compilar:
	$(CC) $(FLAGS) $(ARQUIVOS)

run: compilar
	java MainFiguras

limpar:
	rm -f *.class