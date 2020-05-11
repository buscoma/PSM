package misApis;
/**
 * @author mbusco
 * @apiNote Definición ColaConPrioridad
 */
public interface ColaConPrioridadTDA {
	/**
	 * Inicializa cola con prioridad
	 */
	void inicializarCola();
	/** 
	 * Encola un elemento segun su prioridad
	 * @param valor int
	 * @param prioridad int
	 * @implSpec Requiere inicializarCola()
	 */
	void encolarConPrioridad(int valor, int prioridad);
	/**
	 * Desencola un elemento de la cola
	 * @implSpec Requiere !colaVacia()
	 */
	void desencolar();
	/**
	 * Retorna el valor del proximo elemento de la cola
	 * @return primero int
	 * @implSpec Requiere !colaVacia()
	 */
	int primero();
	/**
	 * Retorna verdadero si la cola esta vacia, sino falso
	 * @return colaVacia boolean
	 * @implSpec Requiere inicializarCola()
	 */
	boolean colaVacia();
	/**
	 * Retorna el valor de la prioridad del proximo elemento de la cola
	 * @return prioridad int
	 * @implSpec Requiere inicializarCola()
	 */
	int prioridad();
}
