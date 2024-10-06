package main;

import java.util.Scanner;

import numerosCasa.NumeroCasa;

public class Main {

	private static void mostrarMatriz(int[][] matriz) {
		int n = matriz.length;
		for(int i = 0 ; i<n ; i++)
		{
			for(int j = 0 ; j<n ; j++)
			{
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	
	
	private static void transponerReflejar(int[][] imagen) {
		mostrarMatriz(imagen);
		int n = imagen.length;
		int aux;
		//Transponemos la matriz
		for(int i = 0 ; i<n ; i++)
		{
			for(int j = 0 ; j<i; j++)
			{
				aux = imagen[i][j];
				imagen[i][j] = imagen[j][i];
				imagen[j][i] = aux; 
			}
		}
		System.out.println();
		mostrarMatriz(imagen);
		System.out.println("n: "+n);
		//Reflejamos la matriz
		for(int i = 0 ; i<n ; i++)
		{
			for(int j = 0 ; j<n-1; j++)
			{
				aux = imagen[i][j];
				imagen[i][j] = imagen[i][n-j-1];
				imagen[i][n-j-1] = aux; 
			}
		}
		
		//Obtenemos la matriz rotada perfectamente a 90º en dirección horaria
		System.out.println();
		mostrarMatriz(imagen);
	}
	
	private static void sinTransponer(int[][] imagen) {
		int n = imagen.length;
		int aux;
		int aux2;
		mostrarMatriz(imagen);
		for(int i = 0 ; i<n-1 ; i++)
		{
			for(int j = 0 ; j<n-1; j++)
			{
				aux = imagen[i][j];
				imagen[i][j] = imagen[j][i];
				
				aux2 = imagen[j][n-1-i];
				imagen[j][n-1-i] = aux;
				
				aux = imagen[n-1-i][n-1-j];
				imagen[n-1-i][n-1-j] = aux2;
				
				imagen[j][i] = aux;
			}
		}
		System.out.println();
		mostrarMatriz(imagen);
	}
	
	public static void matriz() {
		
		int tresXtres[][] = {
						{1,2,3},
						{4,5,6},
						{7,8,9}
						}; 
		
		int cuatroXcuatro[][] = {
						{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}
						};
		
		System.out.println("--- Transposición y reflejo de matriz ---");
		//transponerReflejar(tresXtres);
		
		System.out.println("--- Sin transposición ---");
		sinTransponer(cuatroXcuatro);
	}
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		String menu = "d";
		boolean debugMode = false;
		while(!menu.equals("e") && !menu.equals("l") && !menu.equals("c") && !menu.equals("s")) {
			System.out.println("=== MENU ===");
			System.out.println("e - EXPONENCIAL");
			System.out.println("l - LINEAL");
			System.out.println("c - CONSTANTE");
			System.out.println("d - DEBUG ("+(debugMode)+")");
			System.out.println("s - SALIR");
			System.out.println();
			menu = reader.next();
			
			if(menu.equals("d"))
				debugMode = !debugMode;
		}
		
		System.out.println("=== INGRESE NUMEROS ===");
		int in = 0;
		while(in>=0 && !menu.equals("s")) {
			in = reader.nextInt();
			
			if(menu.equals("e"))
				System.out.println(NumeroCasa.exponencial(in, debugMode));
			else if (menu.equals("l"))
				System.out.println(NumeroCasa.lineal(in, debugMode));
			
		}
		System.out.println("=== FIN ===");
		reader.close();
	}

}
