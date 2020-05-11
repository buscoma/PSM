package misApis;
/**
 * @author mbusco
 * @apiNote Definición Pila
 */
public interface PilaTDA {
	/**
	 * Inicializa Pila
	 */
	void inicializarPila();
	/**
	 * Apila el valor pasado por parametro
	 * @param valor int
	 * @implSpec Requiere inicializarPila()
	 */
	void apilar(int valor);
	/**
	 * Quita el ultimo elemento ingresado en la pila
	 * @implSpec Requiere !pilaVacia()
	 */
	void desapilar();
	/**
	 * Devuelve el valor de tope de pila
	 * @return tope int
	 * @implSpec Requiere !pilaVacia()
	 */
	int tope();
	/**
	 * Retorna verdadero si la pila esta vacia, sino falso
	 * @return pilaVacia boolean
	 * @implSpec Requiere inicializarPila()
	 */
	boolean pilaVacia();
}
