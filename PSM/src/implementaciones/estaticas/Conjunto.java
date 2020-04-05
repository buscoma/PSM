package implementaciones.estaticas;

import interfaces.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	int [] vector;
	int cantidad;

	public void inicializarConjunto() {
		vector = new int[100];
		cantidad = 0;
	}

	public void agregar(int valor) {
		if (! this.pertenece(valor)) {
			vector[cantidad] = valor;
			cantidad++;
		}
	}

	public void sacar(int valor) {
		if (this.pertenece(valor)) {
			int i = 0;
			while (i < cantidad && vector[i] != valor)
				i++;
			vector[i] = vector[cantidad-1];
			cantidad--;
		}
	}

	public int elegir() {
		return vector[cantidad-1];
	}

	public boolean conjuntoVacio() {
		return cantidad == 0;
	}

	public boolean pertenece(int valor) {
		int i = 0;
		while (i <= cantidad && vector[i] != valor)
			i++;
		return i < cantidad;
	}

}
