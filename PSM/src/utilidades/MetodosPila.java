package utilidades;

import implementaciones.estaticas.Pila;
import interfaces.PilaTDA;

public class MetodosPila {
	
	public void mostrarPila(PilaTDA pila) {
		PilaTDA pilaAuxiliar;
		pilaAuxiliar = new Pila();
		pilaAuxiliar.inicializarPila();
		System.out.print("[ ");
		while (!pila.pilaVacia()) {
			System.out.print(pila.tope() + " ");
			pilaAuxiliar.apilar(pila.tope());
			pila.desapilar();
		}
		System.out.println("]");
		pasarPilaPila(pilaAuxiliar, pila);
	}
	
	public void vaciarPila(PilaTDA pila) {
		while(!pila.pilaVacia()) {
			pila.desapilar();
		}
	}
	
	public void ponerNelementosPila(PilaTDA pila, int n) {
		int aux = n;
		while(aux > 0) {
			pila.apilar(aux);
			aux--;
		}
	}
	
	public void pasarPilaPila(PilaTDA origen, PilaTDA destino) {
		while (!origen.pilaVacia()) {
			destino.apilar(origen.tope());
			origen.desapilar();
		}
	}
	
	public void copiarPilaPila(PilaTDA origen, PilaTDA destino) {
		PilaTDA pilaAuxiliar;
		pilaAuxiliar = new Pila();
		pilaAuxiliar.inicializarPila();
		pasarPilaPila(origen, pilaAuxiliar);
		while (!pilaAuxiliar.pilaVacia()) {
			origen.apilar(pilaAuxiliar.tope());
			destino.apilar(pilaAuxiliar.tope());
			pilaAuxiliar.desapilar();
		}
	}
	
	public void invertirPila(PilaTDA pila) {
		PilaTDA pilaAuxiliar;
		pilaAuxiliar = new Pila();
		pilaAuxiliar.inicializarPila();
		while(!pila.pilaVacia()) {
			pilaAuxiliar.apilar(pila.tope());
			pila.desapilar();
		}
		copiarPilaPila(pilaAuxiliar, pila);
	}

	public int contarElementosDePila(PilaTDA pila) {
		int cantidad = 0;
		PilaTDA pilaAuxiliar;
		pilaAuxiliar = new Pila();
		pilaAuxiliar.inicializarPila();
		while(!pila.pilaVacia()) {
			pilaAuxiliar.apilar(pila.tope());
			pila.desapilar();
			cantidad++;
		}
		invertirPila(pilaAuxiliar);
		pasarPilaPila(pilaAuxiliar, pila);
		return cantidad;
		
	}
	
	public int sumarElementosDePila(PilaTDA pila) {
		int suma = 0;
		PilaTDA pilaAuxiliar;
		pilaAuxiliar = new Pila();
		pilaAuxiliar.inicializarPila();
		while(!pila.pilaVacia()) {
			suma += pila.tope();
			pilaAuxiliar.apilar(pila.tope());
			pila.desapilar();
		}
		invertirPila(pilaAuxiliar);
		pasarPilaPila(pilaAuxiliar, pila);
		return suma;
	}
	
	public int calcularPromedioElementosPila(PilaTDA pila) {
		int suma = sumarElementosDePila(pila);
		int cantidad = contarElementosDePila(pila);
		return suma / cantidad;
	}
	
}
