package metro;

import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) {
		Archivo metroin = new Archivo("metro.in");
		
		PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>();
		
		try {
			colaPrioridad = metroin.leerArchivo();
		}
		catch (Exception e) {
			System.err.println(e);
			return;
		}
		
		//Se implementó el algoritmo de Kruskal para la resolución
		
		UnionFind uf = new UnionFind(metroin.getNroIslas());
		
		Arista arista;
		int pesoTotal = 0;
		while(!colaPrioridad.isEmpty())
		{	
			arista = colaPrioridad.poll();
			//Buscamos el representante de los nodos de la arista
			if(uf.find(arista.getA()) != uf.find(arista.getB()))
			{
				//Si son distintos entonces los tenemos que unir
				uf.union(arista.getA(), arista.getB());
				pesoTotal += arista.getPeso();
			}
		}
		
		//Si obtuvimos dos MST significa que el ejercicio no se puede resolver
		//porque hay por lo menos una isla que no está conectada por puente o túnel
		if(metroin.getNroIslas() > 1)
		{
			int representante = uf.find(0);
			int nuevoRepresentante;
			for (int i = 1 ; i<metroin.getNroIslas() ; i++)
			{
				nuevoRepresentante = uf.find(i);
				if(representante != nuevoRepresentante)
				{
					System.out.println("La entrada es incorrecta, se introdujo un conjunto de islas que no se encuentran conectadas, por lo que es imposible resolver el ejercicio");
					return;
				}
			}
		}
		
		System.out.println("Cantidad de Puentes: " + pesoTotal);
		Archivo.guardarArchivo("metro.out", Integer.toString(pesoTotal));
	}

}
