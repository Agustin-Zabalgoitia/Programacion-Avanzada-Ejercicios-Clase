package farolas.test;

import org.junit.Test;

import farolas.Farola;
import farolas.NullArrayException;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;

public class FarolaTest { 
	
	@Test
	public void noSeLePasanPosiciones() {
		Farola[] farolas = new Farola[3];
		farolas[0] = new Farola(1, 3);
		farolas[1] = new Farola(2, 3);
		farolas[2] = new Farola(3, 3);
		assertThrows(NullArrayException.class, () -> {
			Farola.calcularFarolasEncendidas(null, farolas);
		});
	}
	
	@Test
	public void noSeLePasanFarolas() {
		int[] posiciones = {1,3,5}; 
		assertThrows(NullArrayException.class, () -> {
			Farola.calcularFarolasEncendidas(posiciones, null);
		});
	}

}
