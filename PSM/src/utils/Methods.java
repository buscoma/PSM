package utils;

import implementations._static.Pila;
import interfaces.PilaTDA;

public class Methods {
	
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
	
	public void mostrarPila(PilaTDA pila) {
		PilaTDA pilaAuxiliar;
		pilaAuxiliar = new Pila();
		pilaAuxiliar.inicializarPila();
		while (!pila.pilaVacia()) {
			System.out.println(pila.tope());
			pilaAuxiliar.apilar(pila.tope());
			pila.desapilar();
		}
		pasarPilaPila(pilaAuxiliar, pila);
	}

}
