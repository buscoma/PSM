package implementaciones.dinamicas;

import interfaces.ColaTDA;

public class Cola implements ColaTDA {
	public class Nodo{
		int valor;
		Nodo siguiente;
	}
	Nodo primer;
	Nodo ultimo;
	
	public void inicializarCola() {
		primer = new Nodo();
		ultimo = new Nodo();
		primer = null;
		ultimo = null;
	}

	public void encolar(int valor) {
		Nodo nuevo = new Nodo();
		nuevo.valor = valor;
		nuevo.siguiente = primer;
		if (primer == null) {
			ultimo = nuevo;
		}
		primer = nuevo;

	}

	public void desencolar() {
		Nodo actual = primer;
		Nodo anterior = null;
		while(actual != ultimo) {
			anterior = actual;
			actual = actual.siguiente;
		}
		if(anterior == null)
			primer = ultimo = null;
		else {
			anterior.siguiente = null;
			ultimo = anterior;
		}
	}

	public int primero() {
		return primer.valor;
	}

	public boolean colaVacia() {
		return primer == null && ultimo == null;
	}

}
