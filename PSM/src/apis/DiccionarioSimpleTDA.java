package apis;
/**
 * @author mbusco
 * @apiNote Definición DiccionarioSimple
 */
public interface DiccionarioSimpleTDA {
	/**
	 * Inicializa DiccionarioSimple
	 */
	void inicializarDiccionarioSimple();
	/**
	 * Agrega un elemento con el valor pasado por parametro en la clave pasada por parametro
	 * @param clave int
	 * @param valor int
	 * @implSpec Requiere inicializarDiccionarioSimple()
	 */
	void agregar(int clave, int valor);
	/**
	 * Elimina la clave pasada por parametro
	 * @apiNote Si la clave no existe no hace nada
	 * @param clave int
	 * @implSpec Requiere inicializarDiccionarioSimple()
	 */
	void eliminar(int clave);
	/**
	 * Devuelve valor del elementos en la clave pasada por parametro
	 * @apiNote Si la clave no existe no hace nada
	 * @param clave int
	 * @return valor int
	 * @implSpec Requiere que la clave pasada por parametro este entre las claves del diccionario
	 */
	int recuperar(int clave);
	/**
	 * Devuelve el conjunto de claves pertenecientes al diccionario en un conjunto
	 * @apiNote Si el diccionario esta vacío el conjunto que devuelve tambien lo esta
	 * @return claves ConjuntoTDA
	 * @implSpec Requiere inicializarDiccionarioSimple()
	 */
	ConjuntoTDA claves(); // Precondition: inicializarDiccionarioSimple
}
