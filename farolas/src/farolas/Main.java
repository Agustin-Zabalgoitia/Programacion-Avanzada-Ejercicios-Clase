package farolas;
import java.util.List;

public class Main {
	
	private static final int[] POSICIONES = {1,4,13,16,21,25,37,45};
	
	public static void main(String[] args) {
		
		Farola[] farolas = new Farola[7];
		
		farolas[0] = new Farola(1,3);
		farolas[1] = new Farola(4,5);
		farolas[2] = new Farola(7,7);
		farolas[3] = new Farola(11,6);
		farolas[4] = new Farola(15,8);
		farolas[5] = new Farola(26,9);
		farolas[6] = new Farola(37,10);
		
		List<Farola> listaObtenida = Farola.calcularFarolasEncendidas(POSICIONES, farolas);
		System.out.println(listaObtenida);
	}

}
