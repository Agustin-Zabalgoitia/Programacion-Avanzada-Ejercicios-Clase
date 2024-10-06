package plan_de_electrificacion;

public class Electrificacion {

	public static void main(String[] args) {
		int[][] m = // Coste de cada trama entre ciudades
		{
			{0, 2, 4, 3},
			{2, 0, 5, 2},
			{4, 1, 0, 1},
			{3, 2, 5, 0}
		};
		
		int[] nyk = {4, 2}; // n = ciudades y k = centrales electricas
		int[] ks = {1, 4}; // k's = ciudades con centrales electricas
		
		Electrificacion.electrificar(nyk[0], ks, m);
	}
	
	public static void electrificar(int n, int[] ks, int[][] m) {
		
		int[][] mi = new int[n][n];
		int coste = 0;
		n-=1;
		
		// Evaluo cada central electrica
		for(int k : ks) {
			k-=1; // Para determinado "k"
			
			// Para la evaluación de las tramas...
			// Evaluo el triangulo superior (sin la diagonal principal)
			for(int i=0; i<n-1; i++)
				if(i!=k)
				for(int j=i+1; j<n; j++) 
					if(j!=k)
						if(m[i][j] > (m[i][k] + m[k][j])) {
							m[i][j] = m[i][k] + m[k][j];
							mi[i][j] = k;
						}
		}
		
		// Para el calculo del coste total...
		// Evaluo el triangulo superior (sin la diagonal principal)
		for(int i=0; i<n-1; i++) 
			for(int j=i+1; j<n; j++)
				coste += mi[i][j] > 0 ? m[i][mi[i][j]] + m[mi[i][j]][j] : 0;
		
		if(coste > 0)
			System.out.println(coste);
		else
			System.out.println("Ya están bien interconectados");
		
		// Para mostrar que tramas hay que instalar...
		// Evaluo el triangulo superior (sin la diagonal principal)
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++)
				if(mi[i][j] != 0) {
					System.out.println	(i+1 + " " + (mi[i][j] + 1));
					System.out.print	(j+1 + " " + (mi[i][j] + 1));
					System.out.println	();
				}
		}
	}
}
