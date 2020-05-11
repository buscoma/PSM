package misApis;


public interface ABBTDA {
	int raiz();
	  
	ABBTDA hijoIzq();
	  
	ABBTDA hijoDer();
	  
	boolean arbolVacio();
	  
	void inicializarArbol();
	  
	void agregarElem(int paramInt);
	  
	void eliminarElem(int paramInt);
}