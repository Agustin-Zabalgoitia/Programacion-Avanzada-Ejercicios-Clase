package ejercicio_2_10;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;

public class Factorial {

	static final int NUMERO=14250;
	
	public static void main(String[] args) {
		Instant start = Instant.now();
		System.out.println("-- Ejecutando Factorial de "+ NUMERO +" Iterativo --");
		System.out.println(factorial(NUMERO));
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Tiempo: "+ timeElapsed.toMillis() +" milliseconds");
		
		start = Instant.now();
		System.out.println("");
		System.out.println("-- Ejecutando Factorial de "+ NUMERO +" Recursivo --");
		System.out.println(factorialRecursivo(BigInteger.valueOf(NUMERO)));
		end = Instant.now();
		timeElapsed = Duration.between(start, end);
		System.out.println("Tiempo: "+ timeElapsed.toMillis() +" milliseconds");
	}
	
	public static BigInteger factorial(int num) {
	    BigInteger respuesta = new BigInteger("1");
	    for (int i = num; i>1 ; i--)
	        respuesta = respuesta.multiply(BigInteger.valueOf(i));
	    return respuesta;
	}
	
	public static BigInteger factorialRecursivo(BigInteger numero) {
		if(numero.compareTo(BigInteger.valueOf(1)) == 0)
			return numero;
		else
			return numero.multiply(factorialRecursivo(numero.subtract(BigInteger.valueOf(1))));
		
	}
	
	/*
	public static BigInteger factorialRecursivo(int num){
	    return factorialRecursivo(BigInteger.valueOf(num), num-1);
	}
	
	public static BigInteger factorialRecursivo(BigInteger num, int pos) {
	    if (pos<=1)
	        return num;
	       
	    return factorialRecursivo( num.multiply(BigInteger.valueOf(pos)), pos-1);
	}
	*/

}
