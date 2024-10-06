package cc2;

public class Main {

	static final int[] ARR = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
	static final int[] ARR2 = {1,2,3,4,5};
	static final int[] ARR3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59};
	
	public static int sumaDivideYConquista(int[] arr)
	{
		return sumaDivideYConquista(arr, 0, arr.length-1);
	}
	
	public static int sumaDivideYConquista(int[] arr, int limiteIzquierdo, int limiteDerecho)
	{
		int medio = (limiteDerecho + limiteIzquierdo)/2;
		
		if(limiteDerecho - limiteIzquierdo <= 1)
			return arr[limiteIzquierdo] + ( (limiteDerecho - limiteIzquierdo)==1 ? arr[limiteDerecho] : 0 );
		
		return sumaDivideYConquista(arr, limiteIzquierdo, medio) + sumaDivideYConquista(arr, medio  + 1, limiteDerecho);
	}
	
	public static int sumaRecursiva(int[] arr)
	{
		return sumaRecursiva(arr, arr.length-1);
	}
	
	public static int sumaRecursiva(int[] arr, int pos)
	{
		if(pos == 0)
			return arr[pos];
		
		return arr[pos] + sumaRecursiva(arr, pos-1);
	}
	
	public static int sumaIterativa(int[] arr)
	{
		int resultado = 0;
		
		for(int i = 0 ; i<arr.length ; i++)
			resultado += arr[i];
		
		return resultado;
	}
	
	public static void probarTodo(int[] arr)
	{
		System.out.println("Iterativa: " + sumaIterativa(arr));
		System.out.println("Recursiva: " + sumaRecursiva(arr));
		System.out.println("Division y Conquista: " + sumaDivideYConquista(arr));
	}
	
	public static void main(String[] args) {
		probarTodo(ARR3);
	}

}
