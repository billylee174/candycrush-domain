package direccionesTest;

import java.awt.Point;

import direcciones.Abajo;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class AbajoTest extends TestCase {

	//Variables
	public Abajo dir = new Abajo();
	
	//Tests
	public void testPuedeMoverCelda(){
		
		Point celda = mock(Point.class);
		Point dimencion = mock(Point.class);
		
		when(celda.getY()).thenReturn((double) 1);
				
		assertTrue(dir.puedeMoverCelda(celda, dimencion));
		
		verify(celda).getY();
	}
		
	public void testMover(){
		
		Point celda = mock(Point.class);
		
		when(celda.getY()).thenReturn((double) 1);
		
		dir.mover(celda);
		
		verify(celda).getY();
		verify(celda).getX();
	}
	
}
