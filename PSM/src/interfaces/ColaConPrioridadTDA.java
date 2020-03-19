package interfaces;

public interface ColaConPrioridadTDA {
	void inicializarCola(); 
	void acolarConPrioridad(int valor, int valor_prioridad); // Precondition: inicializarCola
	void desencolar(); // Precondition: not colaVacia
	int primero(); // Precondition: not colaVacia
	boolean colaVacia(); // Precondition: inicializarCola
	int prioridad(); // Precondition: inicializarCola
}
