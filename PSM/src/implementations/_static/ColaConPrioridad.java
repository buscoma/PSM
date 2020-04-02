package implementations._static;

import interfaces.ColaConPrioridadTDA;

public class ColaConPrioridad implements ColaConPrioridadTDA {
	class Elem{
		int valor, prioridad;
	}
	Elem []vector;
	int cantidad;

	public void inicializarCola() {
		vector = new Elem[100];
		cantidad = 0;
		
	}

	public void acolarConPrioridad(int valor, int valor_prioridad) {
		int i = cantidad -1;
		while(i >= 0 && vector[i].prioridad >= valor_prioridad) {
			vector[i + 1] = vector[i];
			i--;
		}
		vector[i+1] = new Elem();
		vector[i+1].valor = valor;
		vector[i+1].prioridad = valor_prioridad;
		cantidad++;
	}

	public void desencolar() {
		cantidad--;
	}

	public int primero() {
		return vector[cantidad-1].valor;
	}

	public boolean colaVacia() {
		return cantidad == 0;
	}

	public int prioridad() {
		return vector[cantidad-1].prioridad;
	}

}
