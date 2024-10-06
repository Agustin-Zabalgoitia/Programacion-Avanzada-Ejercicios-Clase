package metro;

public class Arista implements Comparable<Arista> {
	
	private int a, b, peso;
	
	public static final int PESO_TUNEL  = 0;
	public static final int PESO_PUENTE = 1;
	
	public Arista(int a, int b, int peso)
	{
		if(a < 0 || b < 0 || peso < 0)
			throw new IllegalArgumentException("La arista solo trabaja con valores positivos");
		
		this.a = a;
		this.b = b;
		this.peso = peso;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    
	    if (!(obj instanceof Arista)) return false;
	    
	    Arista other = (Arista) obj;

	    return (( 	this.a == other.a  
	    		&&  this.b == other.b  
	    		&&	this.peso == other.peso) 
	    		||
	    		( 	this.a == other.b  
	    		&&  this.b == other.a  
	    		&&	this.peso == other.peso));
	}

	@Override
	public int compareTo(Arista o) {
		return this.peso - o.peso;
	}

	@Override
	public String toString() {
		return "(a:" + a + ", b:" + b + ", peso:" + peso + ")";
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getPeso() {
		return peso;
	}
	
}
