CC = javac
FLAGS = -g
ARQUIVOS = Produto.java Livro.java CD.java DVD.java Loja.java MainLoja.java

all: compilar

compilar:
	$(CC) $(FLAGS) $(ARQUIVOS)

run: compilar
	java MainLoja

limpar:
	rm -f *.class