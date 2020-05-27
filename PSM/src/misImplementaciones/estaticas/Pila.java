package misImplementaciones.estaticas;
import misApis.PilaTDA;

/**
 * @implSpec No debe superar mas de 100 elementos
 */
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
