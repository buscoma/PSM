package misImplementaciones.dinamicas;

import misApis.ConjuntoTDA;
import misApis.GrafoTDA;

public class Grafo implements GrafoTDA {

	class NodoVertice {
		int vertice;
		NodoArista iniArista;
		NodoVertice sigVertice;
	}

	class NodoArista {
		int peso;
		NodoVertice destino;
		NodoArista sigArista;
	}
	
	NodoVertice primerVertice;
	
	public void inicializarGrafo() {
		primerVertice = null;
	}

	public void agregarVertice(int v) {
		NodoVertice nuevo = new NodoVertice();
		nuevo.vertice = v;
		nuevo.iniArista = null;
		nuevo.sigVertice = primerVertice;
		primerVertice = nuevo;
	}

	public void eliminarVertice(int v) {
		NodoVertice actual = primerVertice, ant = null;		
		while ( actual != null && actual.vertice != v ) {
			ant = actual;
			actual = actual.sigVertice;
		}		
		if (ant == null)
			primerVertice = primerVertice.sigVertice;
		else
			ant.sigVertice = actual.sigVertice;
	}

	public ConjuntoTDA vertices() {
		ConjuntoTDA verts = new Conjunto();
		verts.inicializarConjunto();
		NodoVertice actualVert = primerVertice;		
		while ( actualVert != null ) {
			verts.agregar(actualVert.vertice);
			actualVert = actualVert.sigVertice;
		}		
		return verts;
	}

	public void agregarArista(int v1, int v2, int peso) {
		NodoVertice origen = primerVertice ;		
		while ( origen.vertice != v1 )
			origen = origen.sigVertice;		
		NodoVertice destino = primerVertice ;
		while ( destino.vertice != v2)
			destino = destino.sigVertice;
		NodoArista nuevo = new NodoArista ();
		nuevo.peso = peso;
		nuevo.destino = destino;
		nuevo.sigArista = origen.iniArista;
		origen.iniArista = nuevo;
	}

	public void eliminarArista(int v1, int v2) {
		NodoVertice origen = primerVertice ;		
		while ( origen.vertice != v1 )
			origen = origen.sigVertice;		

		NodoVertice destino = primerVertice ;
		while ( destino.vertice != v2 )
			destino = destino.sigVertice;

		NodoArista actualArista = origen.iniArista, antArista = null;
		while ( actualArista !=null && 
                    actualArista.destino != destino) {
			antArista = actualArista;
			actualArista = actualArista.sigArista;
		}

		if ( antArista == null)
			origen.iniArista = origen.iniArista.sigArista;
		else
			antArista.sigArista = actualArista.sigArista;
	}

	public boolean existeArista(int v1, int v2) {
		NodoVertice origen = primerVertice ;		
		while ( origen.vertice != v1 )
			origen = origen.sigVertice;		

		NodoVertice destino = primerVertice ;
		while ( destino.vertice != v2 )
			destino = destino.sigVertice;

		NodoArista actualArista = origen.iniArista;
		while ( actualArista !=null && 
                    actualArista.destino != destino)
			actualArista = actualArista.sigArista;
		
		return  ( ( actualArista == null ) ? false : true );

	}

	public int pesoArista(int v1, int v2) {
		NodoVertice origen = primerVertice ;		
		while ( origen.vertice != v1 )
			origen = origen.sigVertice;
		
		NodoVertice destino = primerVertice ;
		while ( destino.vertice != v2 )
			destino = destino.sigVertice;

		NodoArista actualArista = origen.iniArista;
		while ( actualArista.destino != destino)  
			actualArista = actualArista.sigArista;
		
		return actualArista.peso;
	}
}
