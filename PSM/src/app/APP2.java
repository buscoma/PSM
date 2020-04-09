package app;

import apis.PilaTDA;
import implementaciones.estaticas.Pila;
import utilidades.MetodosPila;

public class APP2 {
	
	public static void main(String[] args) {
	
		PilaTDA pila1 = new Pila();
		PilaTDA pila2 = new Pila();
		pila1.inicializarPila();
		pila2.inicializarPila();
		
		MetodosPila m = new MetodosPila();
		
		m.ponerNelementosPila(pila1, 5);
		System.out.println("Tenemos la pila1 con lo siguiente:");
		m.mostrarPila(pila1);
		
		System.out.println("Pasar una Pila a otra (dejándola en orden inverso)");
		m.pasarPilaPila(pila1, pila2);
		m.mostrarPila(pila2);
		m.pasarPilaPila(pila2, pila1);
		
		System.out.println("Copiar una Pila en otra (dejándola en el mismo orden que la original)");
		m.copiarPilaPila(pila1, pila2);
		m.mostrarPila(pila2);
		m.vaciarPila(pila2);
		
		System.out.println("Invertir el contenido de una Pila.");
		m.invertirPila(pila1);
		m.mostrarPila(pila1);
		m.invertirPila(pila1);
		
		System.out.println("Contar los elementos de una Pila");
		System.out.println("Pila1 tiene " + m.contarElementosDePila(pila1) + " elementos");
		
		System.out.println("Sumar los elementos de una Pila");
		System.out.println("La suma de los elementos de pila1 es " + m.sumarElementosDePila(pila1));
		
		System.out.println("Calcular el promedio de los elementos de una Pila");
		System.out.println("El promedio de los elementos de pila1 es " + m.calcularPromedioElementosPila(pila1));
		
	}
	
}
