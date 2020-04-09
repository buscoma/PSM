package apis;
/**
 * @author mbusco
 * @apiNote Definición Cola
 */
public interface ColaTDA {
	/**
	 * Inicializa cola
	 */
	void inicializarCola();
	/** 
	 * Encola un elemento
	 * @param valor int
	 * @implSpec Requiere inicializarCola()
	 */
	void encolar(int valor);
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
}
