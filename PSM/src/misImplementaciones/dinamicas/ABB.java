package misImplementaciones.dinamicas;
import misApis.ABBTDA;

public class ABB implements ABBTDA {

	class NodoABB {
		int valor;
		ABBTDA izq;
		ABBTDA der;
	}

	NodoABB arbol;

	public int raiz() {
		return this.arbol.valor;
	}

	public ABBTDA hijoIzq() {
		return this.arbol.izq;
	}

	public ABBTDA hijoDer() {
		return this.arbol.der;
	}

	public boolean arbolVacio() {
		return this.arbol == null;
	}

	public void inicializarArbol() {
		this.arbol = null;
	}

	public void agregarElem(int valor) {
		if (this.arbol == null) {
			this.arbol = new NodoABB();
			this.arbol.izq = new ABB();
			this.arbol.izq.inicializarArbol();
			this.arbol.der = new ABB();
			this.arbol.der.inicializarArbol();
			this.arbol.valor = valor;
		} else if (this.arbol.valor > valor) {
			this.arbol.izq.agregarElem(valor);
		} else if (this.arbol.valor < valor) {
			this.arbol.der.agregarElem(valor);
		}
	}

	public void eliminarElem(int valor) {
		if (this.arbol == null)
			return;
		if (this.arbol.valor == valor) {
			if (this.arbol.der.arbolVacio() && this.arbol.izq.arbolVacio()) {
				this.arbol = null;
			} else if (!this.arbol.der.arbolVacio()) {
				this.arbol.valor = menorDeMayores(this.arbol.der);
				this.arbol.der.eliminarElem(this.arbol.valor);
			} else if (!this.arbol.izq.arbolVacio()) {
				this.arbol.valor = mayorDeMenores(this.arbol.izq);

				this.arbol.izq.eliminarElem(this.arbol.valor);
			}

		} else if (this.arbol.valor > valor) {
			this.arbol.izq.eliminarElem(valor);
		} else if (this.arbol.valor < valor) {
			this.arbol.der.eliminarElem(valor);
		}
	}

	private int menorDeMayores(ABBTDA arbol) {
		if (arbol.hijoDer().arbolVacio()) {
			return arbol.raiz();
		}
		return menorDeMayores(arbol.hijoDer());
	}

	private int mayorDeMenores(ABBTDA arbol) {
		if (arbol.hijoIzq().arbolVacio()) {
			return arbol.raiz();
		}
		return mayorDeMenores(arbol.hijoIzq());
	}

}
