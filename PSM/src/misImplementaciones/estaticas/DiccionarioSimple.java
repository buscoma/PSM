package misImplementaciones.estaticas;

import misApis.ConjuntoTDA;
import misApis.DiccionarioSimpleTDA;
import misImplementaciones.estaticas.DiccionarioMultiple.Nodo;

/**
 * @implSpec No debe superar mas de 100 elementos
 */
public class DiccionarioSimple implements DiccionarioSimpleTDA {

	class Nodo {
		int clave;
		int valor;
	}

	Nodo[] vector;
	int cantidad;
	
	public void inicializarDiccionarioSimple() {
		vector = new Nodo[100];
		cantidad = 0;
	}

	public void agregar(int clave, int valor) {
		int i = 0;
		while (i<cantidad && vector[i].clave != clave)
			i+=1;
		if (i==cantidad) {
			vector[i] = new Nodo();
			vector[i].clave = clave;
			vector[i].valor = valor;
			cantidad += 1;
		} else
			vector[i].valor = valor;
	}

	public void eliminar(int clave) {
		int i = 0;
		while (i<cantidad && vector[i].clave != clave)
			i+=1;
		if (i<cantidad) {
			vector[i] = vector[cantidad-1];
			cantidad-=1;
		}
	}

	public int recuperar(int clave) {
		return vector[clave].valor;
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();
		for (int i = 0; i < cantidad; i++) {
			c.agregar(vector[i].clave);
		}
		return c;
	}

}
