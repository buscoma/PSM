package interfaces;

public interface ConjuntoTDA {
	void inicializarConjunto();
	void agregar(int valor); // Precondition: inicializarConjunto / Description: if exists do nothing
	void sacar(int valor); // Precondition: inicializarConjunto / Description: if exists, if not do nothing
	int elegir(); // Precondition: not conjuntoVacio / Description: return random element
	boolean conjuntoVacio(); // Precondition: inicializarConjunto
	boolean pertenece(int valor); // Precondition: inicializarConjunto
}
