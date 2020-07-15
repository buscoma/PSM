package implementaciones.estatico;

import interfaces.ConjuntoTDA;

public class ConjuntoAcotado implements ConjuntoTDA {

	//La posicion representa la ausencia o presencia de un valor
	//Ejemplo: si en la posicion 5 tenemos un 1 significa que el valor 5 pertenece al mismo
	//Limitaciones espaciales para agregado y eliminado más eficiente (operaciones constantes)
	
	int[] vector;
	
	@Override
	public void inicializarConjunto() {
		vector = new int[100];
		for(int i = 0 ; i < 100 ; i++) {
			vector[i] = 0;
		}
	}

	@Override
	public boolean conjuntoVacio() {
		
		int i = 0;
		
		while(vector[i] != 1) {
			i++;
		}
		
		return vector[i] == 1;
	}

	@Override
	public void agregar(int x) {
		vector[x] = 1;
	}

	@Override
	public int elegir() {
		//El conjunto no debe estar vacio
		int i = 0;
		
		while(vector[i] != 1) {
			i++;
		}
		
		return vector[i];
	}

	@Override
	public void sacar(int x) {
		vector[x] = 0;
	}

	@Override
	public boolean pertenece(int x) {
		return vector[x] == 1;
	}

}
