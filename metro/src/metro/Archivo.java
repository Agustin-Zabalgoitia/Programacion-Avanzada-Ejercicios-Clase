package metro;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Archivo {

	private int nroIslas, nroTuneles, nroPuentes;
	private String path;
	
	final private static int MAX_NRO_ISLAS = 10000;
	final private static int MAX_NRO_TUNELES = 12000;
	final private static int MAX_NRO_PUENTES = 12000;
	
	public Archivo(String path) {
		this.path = path;
	}
	
	/*
	*	Recibe como parámetro una cola de prioridades en donde devolverá
	*	las aristas del grafo de entrada
	**/
	public PriorityQueue<Arista> leerArchivo() throws ArchivoNoValidoException, FileNotFoundException
	{
		File archivo = new File(this.path);
		Scanner lector = new Scanner(archivo);
		
		this.nroIslas 	= lector.nextInt();
		if(this.nroIslas > MAX_NRO_ISLAS || this.nroIslas <= 0)
		{
			lector.close();
			throw new ArchivoNoValidoException("El número de islas está fuera de rango");
		}
		
		this.nroTuneles = lector.nextInt();
		if(this.nroTuneles > MAX_NRO_TUNELES || this.nroTuneles < 0)
		{
			lector.close();
			throw new ArchivoNoValidoException("El número de túneles está fuera de rango");
		}
		
		this.nroPuentes = lector.nextInt();
		if(this.nroPuentes > MAX_NRO_PUENTES || this.nroPuentes < 0)
		{
			lector.close();
			throw new ArchivoNoValidoException("El número de puentes está fuera de rango");
		}
		
		PriorityQueue<Arista> aristas = new PriorityQueue<>();
		int a, b;
		for(int i = 0 ; i<this.nroTuneles ; i++)
		{
			a = lector.nextInt()-1;
			b = lector.nextInt()-1;
			aristas.add(new Arista(a, b, Arista.PESO_TUNEL));
		}
			
		for(int i = 0 ; i<this.nroPuentes ; i++)
		{
			a = lector.nextInt()-1;
			b = lector.nextInt()-1;
			aristas.add(new Arista(a, b, Arista.PESO_PUENTE));
		}
		
		lector.close();
		
		return aristas;
	}

	public static void guardarArchivo(String path, String texto) {
		try {
	      FileWriter writer = new FileWriter(path.toString());
	      writer.write(texto);
	      writer.close();
	      System.out.println("Se ha guardado el resultado en " + path);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public int getNroIslas() {
		return nroIslas;
	}

	public int getNroTuneles() {
		return nroTuneles;
	}

	public int getNroPuentes() {
		return nroPuentes;
	}

	public String getPath() {
		return path;
	}
	
}
