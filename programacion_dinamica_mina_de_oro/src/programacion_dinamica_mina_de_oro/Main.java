package programacion_dinamica_mina_de_oro;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static int maximo(int a, int b, int c) {
		return Integer.max(a, Integer.max(b, c));
	}
	
	public static int bottomUp(final int[][] mina) {
		
		int[][] tabla = new int[mina.length][mina[0].length];
		
		int maximo = 0;
		
		for(int i = 0 ; i < tabla.length ; i++)
		{
			for(int j = 0 ; j < tabla[0].length ; j++)
			{
				tabla[i][j] = mina[i][j];
				if(i-1>=0)
				{
					int arribaIzquierda = (j-1<0 ? 0 : tabla[i-1][j-1]);
					int arribaCentro = tabla[i-1][j];
					int arribaDerecha = (j+1>=tabla[i].length ? 0 : tabla[i-1][j+1]);
					
					tabla[i][j] += maximo(arribaIzquierda, arribaCentro, arribaDerecha);
				}
				
				if(tabla[i][j] > maximo)
					maximo = tabla[i][j];
			}
		}
		
		return maximo;
	}
	
	public static int topDown(final int[][] mina)
	{
		HashMap<Dupla, Integer> memoria = new HashMap<>();
		int maximo = topDown(mina, memoria, 0, 0);
		
		//El envoltorio deberá de recorrer toda la primera fila		
		for (int i = 1 ; i<mina[0].length ; i++)
			maximo = Integer.max(maximo, topDown(mina, memoria, 0, i));
		
		return maximo;
	}
	
	public static int topDown(final int[][] mina, Map<Dupla, Integer> memoria, int x, int y)
	{
		//Si ya se resolvió el problema vamos a buscar la solución a la memoria
		if(memoria.containsKey(new Dupla(x, y)))
			return memoria.get(new Dupla(x, y));
		
		//Si estamos fuera de rango se obtiene un cero
		if(		x >= mina.length
			||	x < 0
			|| 	y >= mina[0].length
			||	y < 0)
			return 0;
		
		//El valor a guardar en memoria será la suma de la posición actual
		//y el mayor valor que se encuentre debajo de la posición actual
		memoria.put(new Dupla(x, y), 
				mina[x][y] + Integer.max(	topDown(mina, memoria, x+1, y-1), 
											Integer.max(topDown(mina, memoria, x+1, y), topDown(mina, memoria, x+1, y+1))
										)
				);
		
		return memoria.get(new Dupla(x, y));
	}
	
	public static void main(String[] args) {
		System.out.println("===== COMIENZA MAIN =====");
		
		int[][] mina = {
				{3,2,12,15,10},
				{6,19,7,11,17},
				{8,5,12,32,21},
				{3,20,2,9,7},
		};
		
		int[][] mina2 = {
				{10,10,10,10,10,10,1},
				{1,1,1,1,1,1,10},
				{1,1,1,1,1,1,10},
				{1,1,1,1,1,1,10},
				{1,1,1,1,1,1,10},
				{1,1,1,1,1,1,10},
		};
		
		System.out.println("==== BOTTOM UP");
		System.out.println(bottomUp(mina));
		System.out.println(bottomUp(mina2));
		System.out.println("");
		
		System.out.println("==== TOP DOWN");
		System.out.println(topDown(mina));
		System.out.println(topDown(mina2));
		
		System.out.println("=====   FIN  MAIN   =====");
	}

}
