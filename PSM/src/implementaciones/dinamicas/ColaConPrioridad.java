package implementaciones.dinamicas;

import apis.ColaConPrioridadTDA;

public class ColaConPrioridad implements ColaConPrioridadTDA {
	
	private class NodoPrioridad {
		int valor, prioridad;
		NodoPrioridad siguiente;
	}
	NodoPrioridad inicio;
	
	public void inicializarCola() {
		inicio = new NodoPrioridad();
		inicio = null;
	}

	public void encolarConPrioridad(int valor, int prioridad) {
		NodoPrioridad anterior = null, actual = inicio;
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.valor = valor;
		nuevo.prioridad = prioridad;
		nuevo.siguiente = null;
		while(actual!= null && actual.prioridad >= prioridad) {
			anterior = actual;
			actual = actual.siguiente;
		}
		if (anterior == null) {
			nuevo.siguiente = inicio;
			inicio = nuevo;
		} else {
			nuevo.siguiente = actual;
			anterior.siguiente = nuevo;
		}
	}

	public void desencolar() {
		inicio = inicio.siguiente;
	}

	public int primero() {
		return inicio.valor;
	}

	public boolean colaVacia() {
		return inicio == null;
	}

	public int prioridad() {
		return inicio.prioridad;
	}

}
