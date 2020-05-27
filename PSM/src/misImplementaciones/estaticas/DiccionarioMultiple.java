package misImplementaciones.estaticas;

import misApis.ConjuntoTDA;
import misApis.DiccionarioMultipleTDA;

/**
 * @implSpec No debe superar mas de 100 elementos
 */
public class DiccionarioMultiple implements DiccionarioMultipleTDA {

	class Nodo {
		int clave;
		int[] valores;
		int indexValores;
	}

	Nodo[] vector;
	int index;

	public void inicializarDiccionarioMultiple() {
		vector = new Nodo[100];
		index = 0;
	}

	private int obtenerIndiceDeClave(int clave) {
		int i = 0;
		while (i < index && vector[i].clave != clave) {
			i++;
		}
		if (i == index)
			i = -1;
		return i;
	}

	private int obtenerIndiceDeValor(int clave, int valor) {
		int i = 0;
		int indexValores = vector[i].indexValores;
		while (i < indexValores && vector[i].valores[indexValores] != valor) {
			i++;
		}
		if (i == vector[i].indexValores)
			i = -1;
		return i;
	}

	public void agregar(int clave, int valor) {
		int i = obtenerIndiceDeClave(clave);
		if (i == -1) {
			vector[index] = new Nodo();
			vector[index].clave = clave;
			vector[index].indexValores = 0;
			vector[index].valores = new int[100];
			vector[index].valores[vector[index].indexValores] = valor;
			vector[index].indexValores++;
			index++;
		} else {
			int v = obtenerIndiceDeValor(clave, valor);
			if (v == -1) {
				vector[i].valores[vector[i].indexValores] = valor;
				vector[i].indexValores++;
			}
		}
	}

	public void eliminar(int clave) {
		int i = obtenerIndiceDeClave(clave);
		if (i != -1) {
			vector[i] = vector[index - 1];
			vector[index - 1] = null;
			index--;
		}
	}

	public void eliminarValor(int clave, int valor) {
		int i = obtenerIndiceDeClave(clave);
		int v = obtenerIndiceDeValor(clave, valor);
		if (i != -1 && v != -1) {
			int indexValores = vector[i].indexValores;
			vector[i].valores[v] = vector[i].valores[indexValores - 1];
			vector[i].indexValores--;
		}
	}

	public ConjuntoTDA recuperar(int clave) {
		ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();
		int i = obtenerIndiceDeClave(clave);
		if (i != -1) {
			int indexValores = vector[i].indexValores;
			for (int v = 0; v < indexValores; v++) {
				c.agregar(vector[i].valores[v]);
			}
		}
		return c;
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();
		for (int i = 0; i < index; i++) {
			c.agregar(vector[i].clave);
		}
		return c;
	}
}
