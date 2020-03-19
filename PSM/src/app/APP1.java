package app;

import implementations._static.Pila;
import interfaces.PilaTDA;

public class APP1 {
	public static void main(String[] args) {
		PilaTDA mi_pila = new Pila(); // Create Pila with the implementation
		mi_pila.inicializarPila();
		for(int i=1; i<= 5; i++) {
			System.out.println("Metemos el valor "+ i);
			mi_pila.apilar(i);
		}
		System.out.println("");
		while(!mi_pila.pilaVacia()){
			System.out.println("Sacamos el valor "+ mi_pila.tope());
			mi_pila.desapilar();
		}
		System.out.println("");
		System.out.println("Termine!");
	}
}
