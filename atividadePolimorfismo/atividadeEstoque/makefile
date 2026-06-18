JC = javac
JFLAGS = -g
CLASSES = Produto.java Livro.java CD.java DVD.java Loja.java MainLoja.java

all: classes

classes: $(CLASSES)
	$(JC) $(JFLAGS) $(CLASSES)

run: classes
	java MainLoja

clean:
	rm -f *.class