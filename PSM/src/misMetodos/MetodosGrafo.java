package misMetodos;

import misApis.ConjuntoTDA;
import misApis.DiccionarioSimpleTDA;
import misApis.GrafoTDA;
import misImplementaciones.dinamicas.Conjunto;
import misImplementaciones.dinamicas.DiccionarioSimple;;

public class MetodosGrafo {
	
	public DiccionarioSimpleTDA aristasSalientesPorNodo(GrafoTDA grafo) {
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA bkpVertices;
		int unVertice, otroVertice;
		while(!vertices.conjuntoVacio()) {
			bkpVertices = grafo.vertices();
			unVertice = vertices.elegir();
			resultado.agregar(unVertice, 0);
			while(!bkpVertices.conjuntoVacio()) {
				otroVertice = bkpVertices.elegir();
				if(grafo.existeArista(unVertice, otroVertice))
					resultado.agregar(unVertice, resultado.recuperar(unVertice)+1);
				bkpVertices.sacar(otroVertice);
			}
			vertices.sacar(unVertice);
		}
		return resultado;
	}
	
	public DiccionarioSimpleTDA aristasEntrantesPorNodo(GrafoTDA grafo) {
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA bkpVertices;
		int unVertice, otroVertice;
		while(!vertices.conjuntoVacio()) {
			bkpVertices = grafo.vertices();
			unVertice = vertices.elegir();
			resultado.agregar(unVertice, 0);
			while(!bkpVertices.conjuntoVacio()) {
				otroVertice = bkpVertices.elegir();
				if(grafo.existeArista(otroVertice, unVertice))
					resultado.agregar(unVertice, resultado.recuperar(unVertice)+1);
				bkpVertices.sacar(otroVertice);
			}
			vertices.sacar(unVertice);
		}
		return resultado;
	}
	
	
	public ConjuntoTDA verticesAdyacentes(GrafoTDA grafo, int unVertice) {
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA resultado = new Conjunto();
		resultado.inicializarConjunto();
		int otroVertice;
		if (vertices.pertenece(unVertice)) {
			while(!vertices.conjuntoVacio()) {
				otroVertice = vertices.elegir();
				if(grafo.existeArista(unVertice, otroVertice) || grafo.existeArista(otroVertice, unVertice))
					resultado.agregar(otroVertice);
				vertices.sacar(otroVertice);
			}
		}
		return resultado;
	}
	
	public int porcentajeNodosAislados(GrafoTDA grafo) {
		int cantidadTotal = 0, cantidadAislados = 0;
		int unVertice, otroVertice;
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA bkpVertices;
		while(!vertices.conjuntoVacio()) {
			unVertice = vertices.elegir();
			bkpVertices = grafo.vertices();
			while(!bkpVertices.conjuntoVacio()) {
				otroVertice = bkpVertices.elegir();
				if(!grafo.existeArista(unVertice, otroVertice) && !grafo.existeArista(otroVertice, unVertice))
					cantidadAislados+=1;
				bkpVertices.sacar(otroVertice);
			}
			cantidadTotal+=1;
			vertices.sacar(unVertice);
		}
		return (cantidadAislados/cantidadTotal)*100;
	}
}
