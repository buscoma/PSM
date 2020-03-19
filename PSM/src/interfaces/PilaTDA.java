package interfaces;

public interface PilaTDA {
	void inicializarPila();
	void apilar(int valor); // Precondition: inicializarPila
	void desapilar(); // Precondition: not pilaVacia
	int tope(); // Precondition: not pilaVacia
	boolean pilaVacia(); // Precondition: inicializarPila
}
