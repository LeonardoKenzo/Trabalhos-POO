CC = javac
FLAGS = -g
ARQUIVOS = Contato.java PessoaFisica.java PessoaJuridica.java Agenda.java MainAgenda.java

all: compilar

compilar:
	$(CC) $(FLAGS) $(ARQUIVOS)

run: compilar
	java MainAgenda

limpar:
	rm -f *.class