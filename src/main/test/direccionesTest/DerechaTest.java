package direccionesTest;

import java.awt.Point;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import direcciones.Derecha;

public class DerechaTest extends TestCase {

	//Variables
	public Derecha dir = new Derecha();
	
	//Tests
	public void testPuedeMoverCelda(){
		Point celda = mock(Point.class);
		Point dimencion = mock(Point.class);

		when(celda.getX()).thenReturn((double) 0);
		when(dimencion.getX()).thenReturn((double) 1);

		assertTrue(dir.puedeMoverCelda(celda, dimencion));

		verify(celda).getX();
		verify(dimencion).getX();
	}

	public void testMover(){
		Point celda = mock(Point.class);
		
		when(celda.getX()).thenReturn((double) 0);

		dir.mover(celda);
		
		verify(celda).getX();
		verify(celda).getY();
	}
	
}
