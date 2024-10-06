package contando_islas;

import java.util.ArrayList;

public class Isla {
	ArrayList<Nodo> isla;

	public Isla() {
		super();
		this.isla = new ArrayList<>();
	}

	public ArrayList<Nodo> obtenerIsla() {
		return isla;
	}
	
	public void aniaderAIsla(Nodo nodo) {
		this.isla.add(nodo);
	}
	
	public boolean estaEnIsla(Nodo nodo) {
		return isla.contains(nodo);
	}
	
	public static int estaEnConjuntoDeIslas(ArrayList<Isla> conjunto, Nodo nodo) {
		for(int i = 0 ; i<conjunto.size() ; i++)
		{
			if(conjunto.get(i).estaEnIsla(nodo))
				return i;
		}
		return -1;
	}
	
}
