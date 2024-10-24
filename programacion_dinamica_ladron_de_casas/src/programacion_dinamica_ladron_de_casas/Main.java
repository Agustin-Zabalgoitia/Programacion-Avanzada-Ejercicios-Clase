package programacion_dinamica_ladron_de_casas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static int calcularRoboTopDown(final int[] casas)
	{
		HashMap<Integer, Integer> memoria = new HashMap<>();
		return calcularRoboTopDown(casas, memoria, 0);
	}
	
	public static int calcularRoboTopDown(final int[] casas, Map<Integer, Integer> memoria, int casaActual) {

		if(memoria.containsKey(casaActual))
			return memoria.get(casaActual);
		
		if(casaActual >= casas.length)
			return 0; //Terminé de robar
		
		memoria.put(casaActual, Integer.max( casas[casaActual] + calcularRoboTopDown(casas, memoria, casaActual+2), calcularRoboTopDown(casas, memoria, casaActual+1)));
		
		return memoria.get(casaActual);
	}
	
	public static int calcularRoboBottomUp(final int[] casas) {
		
		if(casas.length == 1)
			return casas[0];
		else if (casas.length == 2)
			return (casas[0] > casas[1] ? casas[0] : casas[1]);
		
		int[] tabla = new int[casas.length];
		
		tabla[0] = casas[0];
		tabla[1] = casas[1];
		
		for(int i = 2 ; i<casas.length ; i++)
			tabla[i] = ( casas[i]+tabla[i-2] > tabla[i-1] ? casas[i]+tabla[i-2] : tabla[i-1] );
		
		return tabla[casas.length-1];
	}
	
	public static void main(String[] args) {
		
		System.out.println("===== COMIENZO MAIN ======");
		
		int[] casas1 = {2,10,3,6,8,1,7};
		int[] casas2 = {3};
		int[] casas3 = {9,5};
		int[] casas4 = {110,5,1,3,1,2,3,1,2};
		System.out.println("=== BOTTOM UP");
		System.out.println(Arrays.toString(casas1));
		System.out.println(calcularRoboBottomUp(casas1));
		System.out.println("");
		
		System.out.println(Arrays.toString(casas2));
		System.out.println(calcularRoboBottomUp(casas2));
		System.out.println("");
		
		System.out.println(Arrays.toString(casas3));
		System.out.println(calcularRoboBottomUp(casas3));
		System.out.println("");
		
		System.out.println(Arrays.toString(casas4));
		System.out.println(calcularRoboBottomUp(casas4));
		System.out.println("");
		
		System.out.println("=== TOP DOWN");
		System.out.println(Arrays.toString(casas1));
		System.out.println(calcularRoboTopDown(casas1));
		System.out.println("");
		
		System.out.println(Arrays.toString(casas2));
		System.out.println(calcularRoboTopDown(casas2));
		System.out.println("");
		
		System.out.println(Arrays.toString(casas3));
		System.out.println(calcularRoboTopDown(casas3));
		System.out.println("");
		
		System.out.println(Arrays.toString(casas4));
		System.out.println(calcularRoboTopDown(casas4));
		System.out.println("");
		
		System.out.println("======== FIN MAIN ========");
	}

}
