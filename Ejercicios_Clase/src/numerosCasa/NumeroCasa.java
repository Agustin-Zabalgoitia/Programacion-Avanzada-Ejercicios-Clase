package numerosCasa;

public class NumeroCasa {
	
	private static boolean validarNumero(int numero) {
		return (numero > 2);
	} 
	
	public static int exponencial(int numero, boolean debug) {
		if(!validarNumero(numero))
			return -1;
		
		int derecha = numero;
		
		
		for(int i = numero - 1 ; i>=0 ; i--) {
			int izquierda = 0;
			
			for(int j = 1; j<i ; j++)
				izquierda += j; 
			
			if(debug) {
				System.out.println("i: " + i);
				System.out.println("Izquierda: " + izquierda);
				System.out.println("Derecha: " + derecha);
				System.out.println();
			}
			
			if(izquierda == derecha)
				return i;
			
			derecha += i;
		}
		
		return -1;
	}
	
	public static int lineal(int numero, boolean debug) {
		if(!validarNumero(numero))
			return -1;
		
		int derecha = numero;
		int izquierda;
		
		for(int i = numero - 1 ; i>0 ; i--) {
			izquierda = (i-1)*i/2;
			
			if(debug) {
				System.out.println("i: " + i);
				System.out.println("Izquierda: " + izquierda);
				System.out.println("Derecha: " + derecha);
				System.out.println();
			}
			
			if(izquierda == derecha)
				return i;
			
			derecha += i;
		}
		
		return -1;
	}
}
