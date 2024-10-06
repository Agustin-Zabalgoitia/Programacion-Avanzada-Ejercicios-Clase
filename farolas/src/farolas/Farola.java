package farolas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Farola {
	private int posicion;
	private int radioIluminacion;
	private boolean encendida;
	
	public Farola(int posicion, int radioIluminacion) {
		this.posicion = posicion;
		this.radioIluminacion = radioIluminacion;
		this.encendida = false;
	}
	
	public int getPosicion() {
		return posicion;
	}
	
	public int getRadioIluminacion() {
		return radioIluminacion;
	}
	
	public boolean isEncendida() {
		return encendida;
	}
	
	public void setEncendida(boolean encendida) {
		this.encendida = encendida;
	}
	
	@Override
	public String toString() {
		return "(" + this.posicion + ";" + this.radioIluminacion + ";" + this.encendida + ")";
	}
	
public static List<Farola> calcularFarolasEncendidas(int[] posiciones, Farola[] farolas){
		
		TreeMap<Integer, ArrayList<Farola>> puntos = new TreeMap<>();
		
		if(posiciones == null || farolas == null)
			throw new NullArrayException();
		
		for (int i = 0; i<posiciones.length ; i++) {
			puntos.put(posiciones[i], new ArrayList<>());
		}
		
		for(Farola farola: farolas)
		{
			int minimo = farola.getPosicion() - farola.getRadioIluminacion();
			int maximo = farola.getPosicion() + farola.getRadioIluminacion();
			
			boolean iluminar = false; 
			
			//Buscamos si hay algún punto que pueda ser iluminado por la farola 
			//y todavía no haya sido iluminado
			for (Map.Entry<Integer, ArrayList<Farola>>punto:puntos.entrySet())
			{
				if(punto.getKey() >= minimo && punto.getKey() <= maximo && punto.getValue().isEmpty())
					iluminar = true;
			}
			
			//En caso de que se haya encontrado algún punto que iluminar, se deberá
			//encender la farola, haciendo que todos los puntos que estén dentro de
			//su radio sean iluminados por ella.
			if(iluminar)
			{
				farola.setEncendida(true); //Encendemos la farola
				for (Map.Entry<Integer, ArrayList<Farola>>punto:puntos.entrySet())
				{
					if(punto.getKey() >= minimo && punto.getKey() <= maximo)
						punto.getValue().add(farola); // Guardamos la farola en el punto correspondiente
				}	
			}

		}		
		
		//Tira un error en caso de que quede algun punto sin iluminar
		for (Map.Entry<Integer, ArrayList<Farola>>punto:puntos.entrySet())
		{
			if(punto.getValue().isEmpty())
				throw new ImposibleIluminarTodosLosPuntosException();
		}
		
		for(Farola farola: farolas)
		{
			int minimo = farola.getPosicion() - farola.getRadioIluminacion();
			int maximo = farola.getPosicion() + farola.getRadioIluminacion();
			
			boolean apagar = true;
			
			for (Map.Entry<Integer, ArrayList<Farola>>punto:puntos.entrySet())
			{
				//Si la farola está iluminando el punto y esa farola es la única que lo está iluminando,
				//entonces esa farola no se debe de apagar. En caso de que todos los puntos que ilumine
				//la farola ya sean iluminados por otras farolas, se la debe de apagar.
				if(punto.getKey() >= minimo && punto.getKey() <= maximo && punto.getValue().contains(farola) && punto.getValue().size() == 1)
					apagar = false;
			}
			
			if(apagar)
			{
				farola.setEncendida(false);
				for (Map.Entry<Integer, ArrayList<Farola>>punto:puntos.entrySet())
				{
					//Eliminamos la farola de la lista de farolas que iluminan al punto, ya que la apagamos
					if(punto.getKey() >= minimo && punto.getKey() <= maximo && punto.getValue().contains(farola))
						punto.getValue().remove(farola); 
				}	
			}
		}
		
		/*
		System.out.println("Estos son los puntos:");
		puntos.forEach((posicion, iluminado) -> System.out.println("pos: " + posicion + "\tilu: " + iluminado));
		*/
		
		//Devolvemos las farolas como una lista
		return Arrays.asList(farolas);
	}
}
