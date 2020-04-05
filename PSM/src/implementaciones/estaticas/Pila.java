package implementaciones.estaticas;
import interfaces.PilaTDA;

// La condición de uso de esta implementación no debe superar los 100 elementos

public class Pila implements PilaTDA {
	
	int [] vector;
	int cantidad;
	
	public void inicializarPila() {
		vector = new int[100];
		cantidad = 0;
	}

	public void apilar(int valor) {
		vector[cantidad] = valor;
		cantidad ++;
	}

	public void desapilar() {
		cantidad --;
	}

	public int tope() {
		return vector[cantidad -1];
	}

	public boolean pilaVacia() {
		return cantidad == 0;
	}

}
