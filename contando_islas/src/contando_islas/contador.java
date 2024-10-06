package contando_islas;

import java.util.ArrayList;
import java.util.LinkedList;

public class contador {


	public static void main(String args[]) {
		System.out.println("===== INICIO =====");
		 
		int[][] grid = {
				{1,1,1,1,0},
				{1,1,0,1,0},
				{1,1,0,0,0},
				{0,0,0,0,0}
		};
		
		int[][] grid2 = {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,1}
		};
		
		int[][] grid3 = {
				{1,1,1,1,0},
				{1,1,0,1,0},
				{1,1,0,0,0},
				{0,1,1,0,0},
				{0,0,1,1,1},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,1,1,1},
				{0,1,0,1,0},
		};
		
		int[][] grid4 = {
				{0,0,0,1,0,0,0,0,1,0,0,0,0,0,1},
				{0,0,1,1,1,0,0,1,1,0,0,0,1,0,0},
				{0,1,1,1,1,1,0,0,1,1,0,1,1,1,0},
				{0,0,1,1,1,1,1,0,1,1,0,0,1,1,1},
				{0,0,0,0,0,1,1,0,0,1,1,0,0,1,0},
				{0,0,0,0,1,1,1,1,0,0,1,1,0,0,0},
				{0,0,1,0,0,1,1,1,1,0,1,1,1,0,1},
				{0,0,0,0,0,0,0,1,1,1,1,0,1,0,1},
				{0,0,1,0,1,0,0,0,1,1,0,0,1,1,1},
				{0,0,1,1,1,1,0,0,0,0,0,0,0,1,1},
				{0,0,0,1,1,1,1,0,1,0,0,1,0,1,0},
				{0,0,0,1,1,1,0,0,1,1,0,0,0,1,1},
				{0,0,0,0,1,1,1,0,0,1,0,0,0,1,1},
				{0,0,0,0,0,0,1,0,0,1,1,0,0,0,0},
				{0,0,1,0,0,0,0,0,0,0,1,1,0,1,0},
				{0,0,0,1,0,0,0,1,1,0,0,0,0,1,1},
				{0,0,1,0,0,1,0,0,1,0,0,1,0,0,1},
				{0,0,0,1,0,0,1,0,0,0,1,1,1,1,1},
				{0,0,1,0,0,0,1,1,0,1,1,0,1,0,1},
				{0,0,0,1,0,0,0,1,1,1,0,0,0,1,1},
				{0,0,0,0,1,0,0,0,0,0,0,0,1,1,1},
				{0,0,0,0,0,0,0,1,1,1,0,0,0,0,0},
				{0,0,0,1,0,0,1,0,1,0,1,0,0,1,0},
				{0,0,1,1,1,0,1,1,1,1,1,0,1,1,1},
				{0,0,0,1,0,0,1,0,1,0,1,0,0,1,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0,0,0},
		};
		
		/*
		Posicion a = new Posicion(0, 0);
		Posicion b = new Posicion(0, 0);
		
		if(a.equals(b))
			System.out.println("La recalcada concha de sus madres esto funca, por lo tanto a es IGUAL a b");
		
		ArrayList<Posicion> array = new ArrayList<>();
		array.add(a);
		
		if(array.contains(b))
			System.out.println("Parece que esto funca como yo pensaba");
		*/
		
		System.out.println("Cantidad de islas en grid:  " + contarIslas(grid));
		System.out.println("Cantidad de islas en grid2: " + contarIslas(grid2));
		System.out.println("Cantidad de islas en grid3: " + contarIslas(grid3));
		System.out.println("Cantidad de islas en grid4: " + contarIslas(grid4));
		System.out.println("=====  FIN   =====");
	}
	
	public static int contarIslas(int[][] grid) {
		
		if (grid == null || grid.length < 1)
			return -1; //TODO: tirar error matriz nula
		
		if (!tamanioMatrizValido(grid))
			return -1; //TODO: tirar error tamaño inválido
		
		if(!contenidoMatrizValido(grid))
			return -1; //TODO: tirar error contenido inválido
		
		ArrayList<Isla> islas = new ArrayList<>();
		LinkedList<Nodo> colaAdyacentes = new LinkedList<>();
		
		for(int i = 0 ; i<grid.length ; i++)
		{
			for(int j = 0 ; j<grid[i].length ; j++) 
			{
				if(grid[i][j] == 1)
				{
					//Si encontramos tierra creamos una isla
					islas.add(new Isla());
					islas.getLast().aniaderAIsla(new Nodo(i,j));
					
					//Buscamos adyacentes
					encontrarAdyacentes(grid, islas, colaAdyacentes, i, j);
					grid[i][j] = 2;
					
					while(!colaAdyacentes.isEmpty())
					{
						Nodo adyacente = colaAdyacentes.pop();
						islas.getLast().aniaderAIsla(adyacente);
						encontrarAdyacentes(grid, islas, colaAdyacentes, adyacente.getX(), adyacente.getY());
						grid[adyacente.getX()][adyacente.getY()] = 2; //Esto tal vez lo tenga que cambiar
					}
				}
			}
		}
		
		return islas.size();
		
	}
	
	//Se asegura de que la matriz sea de m x n con m>=1 y n <= 300 
	//Y además se asegura de que no exista alguna fila 
	//con una cantidad de columnas distinta
	public static boolean tamanioMatrizValido(final int[][] matriz)
	{
		if(matriz.length == 0 || matriz.length > 300)
			return false;
		
		int n = matriz[0].length;
		
		for(int i = 1 ; i<matriz.length; i++)
		{
			if(matriz[i].length != n)
				return false;
		}
		
		return true;
	}
	
	//Se asegura de que el contenido de la matriz sea válido (0 o 1)
	public static boolean contenidoMatrizValido(final int[][] matriz)
	{
		for(int i = 0 ; i<matriz.length ; i++)
		{
			for(int j = 0 ; j<matriz[i].length ; j++) 
			{
				if(matriz[i][j] != 1 && matriz[i][j] != 0)
					return false;
			}
		}
		
		return true;
	}
	
	public static void encontrarAdyacentes(final int[][] matriz, ArrayList<Isla> conjuntoIslas, LinkedList<Nodo> cola, int x, int y)
	{	
		
		verificarAdyacencia(matriz, conjuntoIslas, cola, x-1, y);
		verificarAdyacencia(matriz, conjuntoIslas, cola, x, y-1);
		verificarAdyacencia(matriz, conjuntoIslas, cola, x+1, y);
		verificarAdyacencia(matriz, conjuntoIslas, cola, x, y+1);
		
		/*
		if(x-1 >= 0 && matriz[x-1][y] == 1 )
			cola.add(new Nodo(x-1, y));
		if(y-1 >= 0 && matriz[x][y-1] == 1 )
			cola.add(new Nodo(x, y-1));
		if(x+1 < matriz.length && matriz[x+1][y] == 1 )
			cola.add(new Nodo(x+1, y));
		if(y+1 < matriz[0].length && matriz[x][y+1] == 1 )
			cola.add(new Nodo(x, y+1));
		*/
	}
	
	public static void verificarAdyacencia(final int[][] matriz, ArrayList<Isla> conjuntoIslas, LinkedList<Nodo> cola, int x, int y)
	{
		//Si el nodo que estamos evaluando no se encuentra dentro de una isla
		//y tampoco está en la cola de adyacentes, entonces lo añadimos a la cola		
		if(			x >= 0
				&&	x < matriz.length
				&&	y >= 0
				&&	y < matriz[0].length)
		{
			Nodo nodo = new Nodo(x,y);
			if(		matriz[x][y] == 1
				&&	Isla.estaEnConjuntoDeIslas(conjuntoIslas, nodo) < 0
				&&	!cola.contains(nodo))
				cola.add(nodo);
		}

			
	}
	
}
