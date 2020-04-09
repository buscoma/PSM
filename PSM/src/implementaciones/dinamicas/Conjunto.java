package implementaciones.dinamicas;

import apis.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

	private class Nodo{
		int valor;
		Nodo siguiente;
	}
	Nodo primer;
	
	public void inicializarConjunto() {
		primer = new Nodo();
		primer = null;
	}

	public void agregar(int valor) {
		if (!this.pertenece(valor)) {
			Nodo nuevo = new Nodo();
			nuevo.valor = valor;
			nuevo.siguiente = primer;
			primer = nuevo;
		}
	}

	public void sacar(int valor) {
		Nodo actual = primer, anterior = null;
		while(actual!= null && actual.valor != valor) {
			anterior = actual;
			actual = actual.siguiente;
		}
		if(anterior != null) {
			anterior.siguiente = actual.siguiente;
		}else
			primer = null;
	}

	public int elegir() {
		return primer.valor;
	}

	public boolean conjuntoVacio() {
		return primer == null;
	}

	public boolean pertenece(int valor) {
		Nodo actual = primer;
		while(actual != null) {
			if(actual.valor == valor)
				return true;
			actual = actual.siguiente;
		}
		return false;
	}

}
