package misAplicaciones;

import misApis.ColaTDA;
import misImplementaciones.estaticas.Cola;
import misMetodos.MetodosCola;

public class APP3 {

	public static void main(String[] args) {
		
		ColaTDA cola1 = new Cola();
		ColaTDA cola2 = new Cola();
		
		cola1.inicializarCola();
		cola2.inicializarCola();
		
		MetodosCola m = new MetodosCola();
		
		m.ponerNelementosCola(cola1, 5);
		System.out.println("Tenemos la cola1 con lo siguiente:");
		m.mostrarCola(cola1);
		
		System.out.println("Pasar una Cola a otra");
		m.pasarColaCola(cola1, cola2);
		m.mostrarCola(cola2);
		m.pasarColaCola(cola2, cola1);
		
		System.out.println("Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)");
		m.invertirCola1(cola1);
		m.mostrarCola(cola1);
		m.invertirCola1(cola1);
		
		System.out.println("Invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares)");
		m.invertirCola2(cola1);
		m.mostrarCola(cola1);
		m.invertirCola2(cola1);
		
		System.out.println("Determinar si el final de la Cola C1 coincide o no con la Cola C2.");
		System.out.println("Cola1:");
		m.mostrarCola(cola1);
		m.ponerNelementosCola(cola2, 3);
		System.out.println("Cola2:");
		m.mostrarCola(cola2);
		if(m.compararFinalColas(cola1, cola2))
			System.out.println("Tienen el mismo final");
		else
			System.out.println("No tienen el mismo final");
		m.vaciarCola(cola2);
		m.ponerNelementosCola(cola2, 5);
		System.out.println("Ahora cola2 es:");
		m.mostrarCola(cola2);
		if(m.compararFinalColas(cola1, cola2))
			System.out.println("Tienen el mismo final");
		else 
			System.out.println("No tienen el mismo final");
		m.vaciarCola(cola2);
		
		System.out.println("Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir\n" + 
				"que el primer elemento es igual al último, el segundo igual al penúltimo, etc.");
		cola2.encolar(3);cola2.encolar(2);cola2.encolar(1);cola2.encolar(2);cola2.encolar(3);
		System.out.println("Cola1");
		m.mostrarCola(cola1);
		if(m.colaCapicua(cola1))
			System.out.println("Es capicua");
		else
			System.out.println("No es capicua");
		System.out.println("Cola2");
		m.mostrarCola(cola2);
		if(m.colaCapicua(cola2))
			System.out.println("Es capicua");
		else
			System.out.println("No es capicua");
		m.vaciarCola(cola2);
		
		System.out.println("Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán\n" +
				"inversas, si tienen los mismos elementos pero en orden inverso");
		m.copiarColaCola(cola1, cola2);
		m.invertirCola2(cola2);
		System.out.println("Cola1");
		m.mostrarCola(cola1);
		System.out.println("Cola2");
		m.mostrarCola(cola2);
		if(m.colaInvertidaCola(cola1, cola2)) {
			System.out.println("Es una cola invertida");
		}
	}
	
}