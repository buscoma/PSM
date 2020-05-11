package misImplementaciones.dinamicas;

import misApis.ColaTDA;

public class Cola implements ColaTDA {
	
	private class Nodo {
		int valor;
		Nodo siguiente;
	}
	Nodo primer;
	Nodo ultimo;
	
	public void inicializarCola() {
		this.primer = this.ultimo = null;
	}

	public void encolar(int valor) {
		Nodo nuevo = new Nodo();
		nuevo.valor = valor;
		nuevo.siguiente = null;
		if (this.ultimo == null) 
			this.ultimo = this.primer = nuevo;
		else {
			this.ultimo.siguiente = nuevo;
			this.ultimo = nuevo;
		}
	}

	public void desencolar() {
		this.primer = this.primer.siguiente;
		if (this.primer == null)
			this.ultimo = null;
	}

	public int primero() {
		return this.primer.valor;
	}

	public boolean colaVacia() {
		return this.ultimo == null;
	}

}
