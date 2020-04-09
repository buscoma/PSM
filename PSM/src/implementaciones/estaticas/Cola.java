package implementaciones.estaticas;

import apis.ColaTDA;

public class Cola implements ColaTDA {
	int [] vector;
	int cantidad;
	
	public void inicializarCola() {
		vector = new int[5];
		cantidad = 0;
	}

	public void encolar(int valor) {
		vector[cantidad] = valor;
		cantidad++;
	}

	@Override
	public void desencolar() {
		int i = 0;
		while(i < cantidad - 1) {
			vector[i] = vector[i+1];
			i++;
		}
		cantidad--;
	}

	@Override
	public int primero() {
		return vector[0];
	}

	@Override
	public boolean colaVacia() {
		return cantidad == 0;
	}

}
