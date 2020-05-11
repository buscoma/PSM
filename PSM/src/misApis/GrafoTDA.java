package misApis;

import misApis.ConjuntoTDA;

public interface GrafoTDA {
	void inicializarGrafo();

	void agregarVertice(int paramInt);

	void eliminarVertice(int paramInt);

	ConjuntoTDA vertices();

	void agregarArista(int paramInt1, int paramInt2, int paramInt3);

	void eliminarArista(int paramInt1, int paramInt2);

	boolean existeArista(int paramInt1, int paramInt2);

	int pesoArista(int paramInt1, int paramInt2);
}
