package misImplementaciones.dinamicas;

import misApis.PilaTDA;

public class Pila implements PilaTDA {

	private class Nodo {
		int valor;
		Nodo siguiente;
	}
	Nodo primer;
	Nodo ultimo;
	
	public void inicializarPila() {
		primer = new Nodo();
		ultimo = new Nodo();
		primer = null;
		ultimo = null;
	}

	public void apilar(int valor) {
		Nodo nuevo = new Nodo();
		nuevo.valor = valor;
		nuevo.siguiente = primer;
		if (primer == null)
			ultimo = nuevo;
		primer = nuevo;
	}

	public void desapilar() {
		if (primer.siguiente != null)
			primer = primer.siguiente;
		else
			primer = ultimo = null;
		
	}

	public int tope() {
		return primer.valor;
	}

	public boolean pilaVacia() {
		return primer == null;
	}

}
