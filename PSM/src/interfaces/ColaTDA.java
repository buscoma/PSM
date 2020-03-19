package interfaces;

public interface ColaTDA {
	void inicializarCola();
	void encolar(int valor); // Precondition: inicializarCola
	void desencolar(); // Precondition: not colaVacia
	int primero(); // Precondition: not colaVacia
	boolean colaVacia(); // Precondition: inicializarCola
}
