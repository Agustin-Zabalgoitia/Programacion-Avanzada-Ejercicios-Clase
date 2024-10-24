package programacion_dinamica_mina_de_oro;

import java.util.Objects;

public class Dupla implements Comparable<Dupla> {
	private final int x;
	private final int y;
	
	public Dupla(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dupla other = (Dupla) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public int compareTo(Dupla o) {
		return (this.getX() + this.getY()) - (o.getX() + o.getY());
	}	
	
}
