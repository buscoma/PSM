package utils;

import implementations._static.Cola;
import implementations._static.Pila;
import interfaces.ColaTDA;
import interfaces.PilaTDA;

public class Methods {
	
	
	//METODOS DE PILA
	
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
	
	
	// METODOS DE COLA
	
	
	public void mostrarCola(ColaTDA cola) {
		ColaTDA colaAuxiliar;
		colaAuxiliar = new Cola();
		colaAuxiliar.inicializarCola();
		System.out.print("[ ");
		while (!cola.colaVacia()) {
			System.out.print(cola.primero() + " ");
			colaAuxiliar.encolar(cola.primero());
			cola.desencolar();
		}
		System.out.println("]");
		pasarColaCola(colaAuxiliar, cola);
	}
	
	public void vaciarCola(ColaTDA cola) {
		while(!cola.colaVacia()) {
			cola.desencolar();
		}
	}
	
	public void ponerNelementosCola(ColaTDA cola, int n) {
		int aux = n;
		while(aux > 0) {
			cola.encolar(aux);
			aux--;
		}
	}
	
	public void copiarColaCola(ColaTDA origen, ColaTDA destino) {
		ColaTDA colaAuxiliar = new Cola();
		colaAuxiliar.inicializarCola();
		while(!origen.colaVacia()) {
			colaAuxiliar.encolar(origen.primero());
			destino.encolar(origen.primero());
			origen.desencolar();
		}
		pasarColaCola(colaAuxiliar, origen);
	}
	
	public void pasarColaCola(ColaTDA origen, ColaTDA destino) {
		while (!origen.colaVacia()) {
			destino.encolar(origen.primero());
			origen.desencolar();
		}
	}
	
	public void invertirCola1(ColaTDA cola) {
		PilaTDA pilaAuxiliar;
		pilaAuxiliar = new Pila();
		pilaAuxiliar .inicializarPila();
		while(!cola.colaVacia()) {
			pilaAuxiliar.apilar(cola.primero());
			cola.desencolar();
		}
		while(!pilaAuxiliar.pilaVacia()) {
			cola.encolar(pilaAuxiliar.tope());
			pilaAuxiliar.desapilar();
		}
	}
	
	public void invertirCola2(ColaTDA cola) {
		int cantidad = 0;
		ColaTDA colaAuxiliar1 = new Cola();
		ColaTDA colaAuxiliar2 = new Cola();
		colaAuxiliar1.inicializarCola();
		colaAuxiliar2.inicializarCola();
		while(!cola.colaVacia()) {
			colaAuxiliar1.encolar(cola.primero());
			cola.desencolar();
			cantidad++;
		}
		int ultimo_elemento;
		while(cantidad > 0){
			do {
				ultimo_elemento = colaAuxiliar1.primero();
				colaAuxiliar1.desencolar();
				if(!colaAuxiliar1.colaVacia()) {
					colaAuxiliar2.encolar(ultimo_elemento);
				}
			}while(!colaAuxiliar1.colaVacia());
			cola.encolar(ultimo_elemento);
			pasarColaCola(colaAuxiliar2, colaAuxiliar1);	
			cantidad--;
		}		
	}
	
	public boolean compararFinalColas(ColaTDA cola1, ColaTDA cola2) {
		return !cola1.colaVacia() && !cola2.colaVacia() && cola1.primero() == cola2.primero();
	} 
	
	public boolean colaCapicua(ColaTDA cola) {
		ColaTDA colaAuxiliar1 = new Cola();
		ColaTDA colaAuxiliar2 = new Cola();
		colaAuxiliar1.inicializarCola();
		colaAuxiliar2.inicializarCola();
		copiarColaCola(cola, colaAuxiliar1);
		copiarColaCola(cola, colaAuxiliar2);
		invertirCola2(colaAuxiliar2);
		while(!colaAuxiliar1.colaVacia()){
			if(colaAuxiliar1.primero() == colaAuxiliar2.primero()) {
				colaAuxiliar1.desencolar();
				colaAuxiliar2.desencolar();
			} else
				return false;
		}
		return true;
	}
	
	public boolean colaInvertidaCola(ColaTDA cola1, ColaTDA cola2) {
		ColaTDA colaAuxiliar1 = new Cola();
		ColaTDA colaAuxiliar2 = new Cola();
		colaAuxiliar1.inicializarCola();
		colaAuxiliar2.inicializarCola();
		copiarColaCola(cola1, colaAuxiliar1);
		copiarColaCola(cola2, colaAuxiliar2);
		invertirCola2(colaAuxiliar2);
		while(!colaAuxiliar1.colaVacia() && !colaAuxiliar2.colaVacia()) {
			if(colaAuxiliar1.primero() != colaAuxiliar2.primero())
				return false;
			colaAuxiliar1.desencolar();
			colaAuxiliar2.desencolar();
		}
		return true;	
	}
}
