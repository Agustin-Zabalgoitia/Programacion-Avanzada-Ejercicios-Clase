package metro;

public class UnionFind {
	//Vector de representantes
	private int[] representantes;
	
	public UnionFind(int longitud) {
		if(longitud <= 0)
			throw new IllegalArgumentException("La longitud del vector de representantes debe ser mayor a cero");
		
		this.representantes = new int[longitud];
		
		//Al principio cada nodo se representa a sí mismo
		for(int i = 0 ; i<longitud ; i++)
			this.representantes[i] = i;
	}
	
	//Une dos nodos entre sí, haciendo que tengan el mismo representante
	public void union(int nodoA, int nodoB) {
		
		int a,b;
		if(nodoA < nodoB)
		{
			a = nodoA;
			b = nodoB;
		}
		else
		{
			a = nodoB;
			b = nodoA;
		}

		if(this.representantes[a] == a)
		{
			if(this.representantes[b] == b)
				this.representantes[b] = a;
			else
				union(a, find(b));
		}
		else
		{
			union(find(a), b);
		}
	}
	
	//Dado un nodo, devuelve el representante de ese nodo
	public int find(int nodo) {
		//Si un nodo se representa a sí mismo, significa que llegamos
		//al representante de todos los anteriores
		if(this.representantes[nodo] == nodo)
			return nodo;
		
		return find(this.representantes[nodo]);
	}
}
