package programacion_dinamica_costo_minimo_para_cortar_una_varilla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class Main {
	
	public static int topDown(int longitud, final int[] cortes)
	{
		ArrayList<Integer> cortesList = new ArrayList<>();
		for(int corte : cortes)
			cortesList.add(corte);
	
		HashMap<List<Integer>, Integer> memoria = new HashMap<>();
		
		return topDown(cortesList, 0, longitud, memoria);
	}
	
	public static int topDown(final List<Integer> cortes, int izquierda, int derecha, final Map<List<Integer>, Integer> memoria)
	{
		
		if(memoria.containsKey(cortes))
			return memoria.get(cortes);
		
		if(cortes.isEmpty())
			return 0;
		
		int menorCoste = Integer.MAX_VALUE;
		
		for(int corteActual : cortes)
		{
			ArrayList<Integer> cortesIzquierda = new ArrayList<>();
			cortes.forEach(elemento -> { if(elemento < corteActual) cortesIzquierda.add(elemento); });
			
			ArrayList<Integer> cortesDerecha = new ArrayList<>();
			cortes.forEach(elemento -> { if(elemento > corteActual) cortesDerecha.add(elemento); });
			
			int costeActual = topDown(cortesIzquierda, izquierda, corteActual, memoria) + topDown(cortesDerecha, corteActual, derecha, memoria);
			
			if(menorCoste > costeActual)
				menorCoste = costeActual;
		}
		
		memoria.put(cortes, (derecha - izquierda) + menorCoste);
		
		return memoria.get(cortes);
	}
	
	public static int fuerzaBruta(int longitud, final int[] cortes)
	{
		ArrayList<Integer> cortesList = new ArrayList<>();
		for(int corte : cortes)
			cortesList.add(corte);
		
		return fuerzaBruta(cortesList, 0, longitud);
	}
	
	public static int fuerzaBruta(final List<Integer> cortes, int izquierda, int derecha)
	{
		
		if(cortes.isEmpty())
			return 0;
		
		int menorCoste = Integer.MAX_VALUE;
		
		for(int corteActual : cortes)
		{
			ArrayList<Integer> cortesIzquierda = new ArrayList<>();
			cortes.forEach(elemento -> { if(elemento < corteActual) cortesIzquierda.add(elemento); });
			
			ArrayList<Integer> cortesDerecha = new ArrayList<>();
			cortes.forEach(elemento -> { if(elemento > corteActual) cortesDerecha.add(elemento); });
			
			int costeActual = fuerzaBruta(cortesIzquierda, izquierda, corteActual) + fuerzaBruta(cortesDerecha, corteActual, derecha);
			
			if(menorCoste > costeActual)
				menorCoste = costeActual;
		}
		
		return (derecha - izquierda) + menorCoste;
	}
	
	public static void main(String[] args) {
		System.out.println("===== COMIENZA MAIN =====");
		
		int[] cortes1 = {5,6,1,4,2};
		int[] cortes2 = {4,1,6};
		int[] cortes2b = {1,6,4};
		int[] cortes2c = {6,4,1};
		int[] cortes3 = {9,11,2,3,20,17,13};
		
//		System.out.println("===  FUERZA BRUTA");
//		System.out.println(topDown(9, cortes1));
//		System.out.println(topDown(7, cortes2));
//		System.out.println(topDown(21, cortes3));
		
		System.out.println("===  TOP DOWN");
		System.out.println(topDown(9, cortes1));
		System.out.println(topDown(7, cortes2));
		System.out.println(topDown(7, cortes2b));
		System.out.println(topDown(7, cortes2c));
		System.out.println(topDown(21, cortes3));
		
		System.out.println("===  BOTTOM UP");
		
		System.out.println("=====   FIN  MAIN   =====");
	}

}
