package ejercicio_2_11;

public class Main {

	final static int NUMERO = 100000000; 
	
	public static void main(String[] args) {
		System.out.println("===INICIO===");
		//a)
		long startTime = System.nanoTime();
		sumar(NUMERO);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Tiempo en sumar "+ NUMERO +" elementos: \t\t"+ duration +" nanosegundos");
		
		//b)
		startTime = System.nanoTime();
		multiplicar(NUMERO);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Tiempo en multiplicar "+ NUMERO +" elementos: \t"+ duration +" nanosegundos");
		
		//c)
		startTime = System.nanoTime();
		dividir(NUMERO);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Tiempo en dividir "+ NUMERO +" elementos: \t\t"+ duration +" nanosegundos");
		
		//d)
		startTime = System.nanoTime();
		comparar(NUMERO);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Tiempo en comparar "+ NUMERO +" elementos: \t"+ duration +" nanosegundos");
		
		//e)
		startTime = System.nanoTime();
		asignar(NUMERO);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Tiempo en asignar "+ NUMERO +" elementos: \t\t"+ duration +" nanosegundos");
		
		System.out.println("===FIN===");
		
	}

	public static void sumar(int n) {
		for(int i = 0 ; i<n ; i++)
			sumar();
	}
	
	public static int sumar() {
		return 1+1;
	}
	
	public static void multiplicar(int n) {
		for(int i = 0 ; i<n ; i++)
			multiplicar();
	}
	
	public static int multiplicar() {
		return 1*1;
	}
	
	public static void dividir(int n) {
		for(int i = 0 ; i<n ; i++)
			dividir();
	}
	
	public static int dividir() {
		return 1/2;
	}
	
	public static void comparar(int n) {
		for(int i = 0 ; i < n ; i++)
			if(1 == 0)
			{}
	}
	
	public static void asignar(int n) {
		int a;
		for(int i = 0 ; i < n ; i++)
			a = i;
	}
	
}
