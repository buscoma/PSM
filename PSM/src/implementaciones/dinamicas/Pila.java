package implementaciones.dinamicas;

import interfaces.PilaTDA;

public class Pila implements PilaTDA {

	public class Nodo{
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
		if (ultimo == null)
			primer = ultimo = nuevo;
		else
			ultimo.siguiente = nuevo;
	}

	public void desapilar() {
		
		Nodo anterior = primer;
		Nodo siguienteNodo = primer.siguiente;
		while (anterior != null) {
			anterior = siguienteNodo;
			siguienteNodo = siguienteNodo.siguiente;
		}
		
			
		
	}

	public int tope() {
		return ultimo.valor;
	}

	public boolean pilaVacia() {
		return primer == null && ultimo == null;
	}

}
