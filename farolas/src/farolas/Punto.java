package farolas;

import java.util.ArrayList;

public class Punto {
	int posicion;
	boolean iluminado;
	ArrayList<Integer> farolasIluminando;
	
	public Punto(int posicion) {
		this.posicion = posicion;
		this.iluminado = false;
		farolasIluminando = new ArrayList<>();
	}
	
	public int getPosicion() {
		return posicion;
	}
	
	public ArrayList<Integer> getFarolasIluminando() {
		return farolasIluminando;
	}
	
	public boolean isIluminado() {
		return iluminado;
	}
	
	public void addFarolasIluminando(int farola) {
		this.farolasIluminando.add(farola);
	}
	
	public void removeFarolasIluminando(int farola) {
		this.farolasIluminando.remove(farola);
	}
	
	
}
