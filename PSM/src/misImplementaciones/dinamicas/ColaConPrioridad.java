package misImplementaciones.dinamicas;

import misApis.ColaConPrioridadTDA;

public class ColaConPrioridad implements ColaConPrioridadTDA {
	
	private class Nodo {
		int valor, prioridad;
		Nodo siguiente;
	}
	Nodo nodoMayorPrioridad;
	
	public void inicializarCola() {
		this.nodoMayorPrioridad = null;
	}

	public void encolarConPrioridad(int valor, int prioridad) {
		Nodo actual = this.nodoMayorPrioridad, anterior = null;
		Nodo nuevo = new Nodo();
		nuevo.valor = valor;
		nuevo.prioridad = prioridad;
		if (this.nodoMayorPrioridad == null || prioridad > this.nodoMayorPrioridad.prioridad) {
			nuevo.siguiente = this.nodoMayorPrioridad;
			this.nodoMayorPrioridad = nuevo;
		} else {
			while (actual != null && prioridad <= actual.prioridad) {
				anterior = actual;
				actual = actual.siguiente;
			}
			nuevo.siguiente = actual;
			anterior.siguiente = nuevo;
		}
	}

	public void desencolar() {
		this.nodoMayorPrioridad = this.nodoMayorPrioridad.siguiente;
	}

	public int primero() {
		return this.nodoMayorPrioridad.valor;
	}

	public boolean colaVacia() {
		return this.nodoMayorPrioridad == null;
	}

	public int prioridad() {
		return this.nodoMayorPrioridad.prioridad;
	}

}
