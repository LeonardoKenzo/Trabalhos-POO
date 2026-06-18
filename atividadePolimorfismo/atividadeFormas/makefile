JC = javac
JFLAGS = -g
CLASSES = Figura.java Circulo.java Retangulo.java Quadrado.java MainFiguras.java

all: classes

classes: $(CLASSES)
	$(JC) $(JFLAGS) $(CLASSES)

run: classes
	java MainFiguras

clean:
	rm -f *.class