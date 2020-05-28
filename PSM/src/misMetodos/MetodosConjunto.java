package misMetodos;

import misApis.ConjuntoTDA;
import misImplementaciones.dinamicas.Conjunto;

public class MetodosConjunto {
	
	public ConjuntoTDA elementosUnicos(ConjuntoTDA a, ConjuntoTDA b) {// devuelve en unapila los elementos unicos de a
		// que estan en b
		ConjuntoTDA unicos = new Conjunto();
		unicos.inicializarConjunto();
		int eleccion;
		while (!a.conjuntoVacio()) {
			eleccion = a.elegir();
			if (!b.pertenece(eleccion)) {
				unicos.agregar(eleccion);
			}
			a.sacar(eleccion);
		}
		return unicos;
	}
	
}
