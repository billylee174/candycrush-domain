package dificultad;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.Test;

import colores.Dulce;

public class DificultadTest {

	protected Dificultad dificultad;
	
	@Test
	public void testDificultad() {
		List<Dulce> dulces = new ArrayList<Dulce>();
		dulces.add(mock(Dulce.class));
		dulces.add(mock(Dulce.class));
		dulces.add(mock(Dulce.class));
		
		this.dificultad = new Dificultad(dulces);
		assertEquals(dulces, this.dificultad.getDulces());
	}

}
