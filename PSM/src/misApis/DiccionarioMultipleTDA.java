package misApis;
/**
 * @author mbusco
 * @apiNote Definición DiccionarioMultiple
 */
public interface DiccionarioMultipleTDA {
	/**
	 * Inicializa DiccionarioMultiple
	 */
	void inicializarDiccionarioMultiple();
	/**
	 * Agrega un elemento con el valor pasado por parametro en el conjunto de la clave pasada por parametro
	 * @param clave int
	 * @param valor int
	 * @implSpec Requiere inicializarDiccionarioMultiple()
	 */
	void agregar(int clave, int valor);
	/**
	 * Elimina la clave pasada por parametro
	 * @apiNote Si la clave no existe no hace nada
	 * @param clave int
	 * @implSpec Requiere inicializarDiccionarioMultiple()
	 */
	void eliminar(int clave);
	/**
	 * Devuelve el conjunto de elementos en la clave pasada por parametro
	 * @apiNote Si la clave no existe no hace nada
	 * @param clave int
	 * @return conjunto ConjuntoTDA
	 * @implSpec Requiere que la clave pasada por parametro este entre las claves del diccionario
	 */
	ConjuntoTDA recuperar(int clave);
	/**
	 * Elimina el elemento de valor pasado por parametro de el conjunto de elementos de clave pasada por parametro
	 * @apiNote Si no existe no hace nada
	 * @param clave int
	 * @param valor int
	 * @implSpec Requiere inicializarDiccionarioMultiple()
	 */
	void eliminarValor(int clave, int valor);
	/**
	 * Devuelve el conjunto de claves pertenecientes al diccionario en un conjunto
	 * @apiNote Si el diccionario esta vacío el conjunto que devuelve tambien lo esta
	 * @return claves ConjuntoTDA
	 * @implSpec Requiere inicializarDiccionarioMultiple()
	 */
	ConjuntoTDA claves();
}
