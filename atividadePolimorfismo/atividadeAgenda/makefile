JC = javac
JFLAGS = -g
CLASSES = Contato.java PessoaFisica.java PessoaJuridica.java Agenda.java MainAgenda.java

all: classes

classes: $(CLASSES)
	$(JC) $(JFLAGS) $(CLASSES)

run: classes
	java MainAgenda

clean:
	rm -f *.class