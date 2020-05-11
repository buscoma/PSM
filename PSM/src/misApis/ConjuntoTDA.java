package misApis;
/**
 * @author mbusco
 * @apiNote Definición Conjunto
 */
public interface ConjuntoTDA {
	/**
	 * Inicializa cola con prioridad
	 */
	void inicializarConjunto();
	/**
	 * Agrega un elemento al conjunto con el valor pasado por parametro
	 * @apiNote Si existe no hace nada
	 * @param valor int
	 * @implSpec Requiere inicializarConjunto()
	 */
	void agregar(int valor);
	/**
	 * Saca el elemento de valor pasado por parametro del conjunto
	 * @apiNote Si no existe no hace nada
	 * @param valor
	 * @implSpec Requiere inicializarConjunto()
	 */
	void sacar(int valor);
	/**
	 * Devuelve el valor de uno de los elementos del conjunto
	 * @apiNote El valor que devuelve es uno random
	 * @return valor int
	 * @implSpec Requiere !conjuntoVacio()
	 */
	int elegir();
	/**
	 * Retorna verdadero si el conjunto esta vacio, sino falso
	 * @return conjuntoVacio boolean
	 * @implSpec Requiere inicializarConjunto()
	 */
	boolean conjuntoVacio();
	/**
	 * Retorna verdadero si el elemento de valor dado pertenece al conjunto
	 * @param valor int
	 * @return pertenece boolean
	 * @implSpec Requiere inicializarConjunto()
	 */
	boolean pertenece(int valor); // Precondition: inicializarConjunto
}
