package app;

import implementations._static.Pila;
import interfaces.PilaTDA;
import utils.Methods;

public class APP2 {
	
	public static void main(String[] args) {
	
		PilaTDA pila1 = new Pila();
		PilaTDA pila2 = new Pila();
		pila1.inicializarPila();
		pila2.inicializarPila();
		
		Methods m = new Methods();
		
		for (int i=1; i<=5; i++) {
			pila1.apilar(i);
		}
		System.out.println("La pila1 tiene los siguientes valores:");
		m.mostrarPila(pila1);
		
		System.out.println("La pila2 tiene los siguientes valores:");
		m.mostrarPila(pila2);
		
		System.out.println("Copio la pila1 a la pila2");
		m.copiarPilaPila(pila1, pila2);
		
		System.out.println("La pila1 tiene los siguientes valores:");
		m.mostrarPila(pila1);
		
		System.out.println("La pila2 tiene los siguientes valores:");
		m.mostrarPila(pila2);
		
		System.out.println("Termine!");
	}
	
}
