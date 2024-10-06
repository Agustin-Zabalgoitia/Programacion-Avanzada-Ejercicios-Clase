package contando_islas;

public class Nodo{
	private int x;
	private int y;
	
	public Nodo(int x, int y){
		super();
		if(x < 0 || y < 0)
			throw new IllegalArgumentException("La posición debe ser positiva");
		
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		if(x>0)
			this.x = x;
	}
	public void setY(int y) {
		if(y>0)
			this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    
	    if (!(obj instanceof Nodo)) return false;
	    
	    Nodo other = (Nodo) obj;

	    return ( this.x == other.x &&  this.y == other.y );
	}
	
}
