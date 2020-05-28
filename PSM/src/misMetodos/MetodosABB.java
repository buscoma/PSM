package misMetodos;

import misApis.*;
import misImplementaciones.dinamicas.*;

public class MetodosABB {
	
	public void mostrarOrdenado (ABBTDA arbol){
        if(!arbol.arbolVacio()){
            mostrarOrdenado(arbol.hijoIzq());
            System.out.println(arbol.raiz());
            mostrarOrdenado(arbol.hijoDer());
        }
    }

    public void mostrarPreOrden(ABBTDA arbol){
        if(!arbol.arbolVacio()){
            System.out.println(arbol.raiz());
            mostrarPreOrden(arbol.hijoIzq());
            mostrarPreOrden(arbol.hijoDer());
        }

    }

    public void mostrarPostOrden(ABBTDA arbol){
        if(!arbol.arbolVacio()){
            mostrarPostOrden(arbol.hijoIzq());
            mostrarPostOrden(arbol.hijoDer());
            System.out.println(arbol.raiz());
        }
    }
    
    public int elementosMismoNivel(ABBTDA arbol, int nivel){
        if(arbol.arbolVacio()){
            return 0;
        }else{
            if(nivel == 0){
                return 1;
            }else
                return elementosMismoNivel(arbol.hijoIzq(),nivel-1) + elementosMismoNivel(arbol.hijoDer(),nivel-1);
        }
    }

	public int encontrarValorArbol(ABBTDA arbol,int valor){
	    if(!arbol.arbolVacio()){
	        if(arbol.raiz()>valor){
	            return encontrarValorArbol(arbol.hijoIzq(),valor);
	        }else{
	            if(arbol.raiz()<valor)
	                return encontrarValorArbol(arbol.hijoDer(),valor);
	            else
	                return 1;
	        }
	    }
	    return 0;
	}
    
    public int cantidadElementos(ABBTDA arbol){
        if(!arbol.arbolVacio()){
            return 1 + cantElem(arbol.hijoIzq()) + cantElem(arbol.hijoDer());
        }
        return 0;
    }
    
    private int cantElem(ABBTDA arbol) {
        if(arbol.arbolVacio()){
            return 0;
        }else{
            if(arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()){
                // si es hojas, o sea esta solo
                return 1;
            } else {
                return cantElem(arbol.hijoIzq()) + cantElem(arbol.hijoDer());
            }
        }
    }

    public int AcumImparesElem(ABBTDA arbol) {
        if(arbol.arbolVacio()){
            return 0;
        }else{
            if(arbol.raiz()%2 == 1){
                return arbol.raiz() + AcumImparesElem(arbol.hijoIzq()) + AcumImparesElem(arbol.hijoDer());
            }else{
                return AcumImparesElem(arbol.hijoIzq()) + AcumImparesElem(arbol.hijoDer());
            }
        }
    }

    public int cantElemTotal(ABBTDA arbol) {
        if(arbol.arbolVacio()){
            return 0;
        }
        return 1 + cantElemTotal(arbol.hijoIzq()) + cantElemTotal(arbol.hijoDer());
    }

    public int minimo(ABBTDA arbol) {
        if (arbol.hijoIzq().arbolVacio()) {
            return arbol.raiz();
        } else if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            return arbol.raiz();
        } else {
            return minimo(arbol.hijoIzq());
        }
    }

    public int profundidad(ABBTDA arbol, int valor) {
        if (arbol.raiz() == valor) {
            return 0;
            // si el dato es mayot va a estar en el lado derecho del arbol
        } else if (arbol.raiz() < valor) {
            return 1 + profundidad(arbol.hijoDer(), valor);
        } else {
            // si es menor va a estar a la izq
            return 1 + profundidad(arbol.hijoIzq(), valor);
        }
    }

    public int altura(ABBTDA arbol){
        if(arbol.arbolVacio()){
            return 0;
        }else{
            int alturaDer = altura(arbol.hijoDer());
            int alturaIzq = altura(arbol.hijoIzq());
            if(alturaDer> alturaIzq){
                return alturaDer +1;
            }else{
                return alturaIzq +1;
            }
        }
    }
    
    public int altura2(ABBTDA arbol){
        if(arbol.arbolVacio()){
            return 0;
        }else if(!arbol.hijoDer().arbolVacio() || !arbol.hijoIzq().arbolVacio()){
            int alturaDer = altura(arbol.hijoDer());
            int alturaIzq = altura(arbol.hijoIzq());
            if(alturaDer > alturaIzq){
                return alturaDer +1;
            }else{
                return alturaIzq +1;
            }
        } else {
        	return 0;
        }
    } 

    public int cantHojas(ABBTDA arbol) {
        if(arbol.arbolVacio()){
            return 0;
        }else{
            if(arbol.hijoDer().arbolVacio() && arbol.hijoDer().arbolVacio()){
                return 1;
            }else{
                return cantHojas(arbol.hijoDer()) + cantHojas(arbol.hijoIzq());
            }
        }
    }
    
    public boolean arbolIgual(ABBTDA arbol1, ABBTDA arbol2) {
        if(arbol1.arbolVacio() && arbol2.arbolVacio()){
            return true;
        }else{
            if(arbol1.raiz() == arbol2.raiz()){
                if(arbolIgual(arbol1.hijoDer(),arbol2.hijoDer())){
                    return  arbolIgual(arbol1.hijoIzq(),arbol2.hijoIzq());
                }else
                    return false;
            }else{
                return false;
            }
        }
    }
    
    public ColaTDA ancestros(ABBTDA arbol, int valor) {
    	   ColaTDA cola = new Cola();
    	   cola.inicializarCola();
    	   agregarAncestrosACola(arbol, cola, valor);
    	   return cola;
    }
    
    private void agregarAncestrosACola(ABBTDA arbol, ColaTDA cola, int valor) {
    	if(!arbol.arbolVacio()) {
    		if(arbol.raiz() < valor) {
    			cola.encolar(arbol.raiz());
    			agregarAncestrosACola(arbol.hijoIzq(), cola, valor);
    		} else if(arbol.raiz() > valor) {
    			cola.encolar(arbol.raiz());
    			agregarAncestrosACola(arbol.hijoDer(), cola, valor);
    		}
    	}
    }
    
    
    public void colaConPrioridadDeArbol(ColaConPrioridadTDA cola, ABBTDA arbol) {
    	while(!arbol.arbolVacio()) {
    		int prioridad = arbol.raiz();
    		int valor = altura(arbol.hijoIzq()) - altura(arbol.hijoDer());
    		cola.encolarConPrioridad(valor, prioridad);
    		colaConPrioridadDeArbol(cola, arbol.hijoIzq());
    		colaConPrioridadDeArbol(cola, arbol.hijoDer());
    	}
    }
    
    public   void agregarpreorden(ABBTDA B, ABBTDA A) {
        if (!A.arbolVacio()) {
            B.agregarElem(A.raiz());
            agregarpreorden(B, A.hijoIzq());            
            agregarpreorden(B, A.hijoDer());
        }
    }


    public void rotar(ABBTDA B, ABBTDA A) {
        if (!A.hijoDer().arbolVacio()) {
            B.agregarElem(A.hijoDer().raiz());
            B.agregarElem(A.raiz());
            agregarpreorden(B, A.hijoIzq());
            agregarpreorden(B, A.hijoDer().hijoIzq());
            agregarpreorden(B, A.hijoDer().hijoDer());
        }
    }
    
}
