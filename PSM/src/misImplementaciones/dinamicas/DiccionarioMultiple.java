package misImplementaciones.dinamicas;

import misApis.ConjuntoTDA;
import misApis.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {		
	class NodoClave{
		int clave;
		NodoValor inicioVal;
		NodoClave sigClave;
	}
	
	class NodoValor{
		int valor;
		NodoValor sigValor;
	}
	NodoClave inicioClave;

	public void inicializarDiccionarioMultiple() {
		inicioClave = null;
	}
	
	public ConjuntoTDA claves() {
		ConjuntoTDA resultado = new Conjunto();
		resultado.inicializarConjunto();		
		NodoClave actual = inicioClave;
		while (actual != null) {
			resultado.agregar(actual.clave);
			actual = actual.sigClave;
		}				
		return resultado;
	}
	
	private NodoClave buscarClave(int clave) {
		NodoClave actual = inicioClave;
		while (actual != null && actual.clave != clave)
			actual = actual.sigClave;
		return actual;		
	}

	public ConjuntoTDA recuperar(int clave) {	
		ConjuntoTDA resultado = new Conjunto();
		resultado.inicializarConjunto();		
		NodoClave actualClave = buscarClave(clave);	
		if (actualClave != null) {
			NodoValor actual = actualClave.inicioVal;
			while (actual != null) {
				resultado.agregar(actual.valor);
				actual = actual.sigValor;
			}				
		}		
		return resultado;
	}	
	
	private NodoValor buscarValor(NodoValor inicio, int valor) {
		NodoValor actual = inicio;
		while (actual != null && actual.valor != valor)
			actual = actual.sigValor;
		return actual;		
	}
	
	public void agregar(int clave, int valor) {
		NodoClave actualClave = buscarClave(clave);
		if (actualClave == null) {
			NodoClave nuevoClave = new NodoClave();
			nuevoClave.clave = clave;
			nuevoClave.inicioVal = null;
			nuevoClave.sigClave = inicioClave;
			inicioClave = nuevoClave;
			actualClave = nuevoClave;
		};
		NodoValor actualValor = buscarValor(actualClave.inicioVal, valor);
		if (actualValor == null) {
			NodoValor nuevoValor = new NodoValor();
			nuevoValor.valor = valor;
			nuevoValor.sigValor = actualClave.inicioVal;
			actualClave.inicioVal = nuevoValor;			
		}
	}	

	public void eliminar(int clave) {
		NodoClave actual = inicioClave, ant = null;
		while (actual != null && actual.clave != clave) {
			ant = actual;
			actual = actual.sigClave;
		}
		if (actual != null)
			if (ant == null)
				inicioClave = inicioClave.sigClave;
			else
				ant.sigClave = actual.sigClave;
	}

	public void eliminarValor(int clave, int valor) {
		NodoClave actualClave = buscarClave(clave);
		if (actualClave != null){
			NodoValor actual = actualClave.inicioVal, ant = null;
			while (actual != null && actual.valor != valor) {
				ant = actual;
				actual = actual.sigValor;
			}
			if (actual != null) {
				if (ant == null)
					actualClave.inicioVal = actualClave.inicioVal.sigValor;
				else
					ant.sigValor = actual.sigValor;
				if (actualClave.inicioVal == null)
					eliminar(actualClave.clave);
			}								
		}
	}

}
