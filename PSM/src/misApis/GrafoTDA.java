package misApis;

public interface GrafoTDA {
	/**
	 * @Tarea: InicializarGrafo: inicializa el grafo.
	 */
	void inicializarGrafo();
	/**
	 *  @Tarea: AgregarVertice: agrega un nuevo vértice v al grafo.
	 *  @Precond.: debe estar inicializado y no existir el vétice.
	 */
	void agregarVertice(int paramInt);
	/**
	 *  @Tarea: EliminarVertice: elimina el vértice v
	 *  @Precond.: debe estar inicializado y existir el vértice.
	 */
	void eliminarVertice(int paramInt);
	/**
	 *  @Tarea: Vertices: devuelve el conjunto de vértices de un 
       *          grafo
	 *  @Precond.: debe estar inicializado.	
	 */
	ConjuntoTDA vertices();
	/**
	 *  @Tarea: AgregarArista: agrega una arista al grafo entre los 
       *          vértices v1 y v2 con el peso dado.
	 *  @Precond.: debe estar inicializado, 
       *            no existir la arista entre los vértices v1 y v2 y 
       *            existir ambos vértices.
	 */ 
	void agregarArista(int paramInt1, int paramInt2, int paramInt3);
	/**
	 *  @Tarea: EliminarArista: elimina la arista entre los 
       *          vértices v1 y v2.
	 *  @Precond.: debe estar inicializado, existir la arista
	 *             entre los vértices v1 y v2
	 */ 
	void eliminarArista(int paramInt1, int paramInt2);
	/**
	 *  @Tarea: ExisteArista: indica si el grafo contiene una arista 	      	 *          entre los vértices v1 y v2.
	 *  @Precond.: debe estar inicializadoy existir ambos vértices.
	 */
	boolean existeArista(int paramInt1, int paramInt2);
	/**
	 *  @Tarea: PesoArista: devuelve el peso de la arista entre los
       *          vértices v1 y v2.
	 *  @Precond.: debe estar inicializado, existir arista entre los 
       *          vértices v1 y v2.
	 */ 
	int pesoArista(int paramInt1, int paramInt2);
}
