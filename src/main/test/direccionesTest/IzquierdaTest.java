package direccionesTest;

import java.awt.Point;

import direcciones.Izquierda;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class IzquierdaTest extends TestCase {

	//Variables
	public Izquierda dir = new Izquierda();
	
	//Tests
	public void testPuedeMoverCelda(){
		
		Point celda = mock(Point.class);
		Point dimencion = mock(Point.class);

		when(celda.getX()).thenReturn((double) 1);

		assertTrue(dir.puedeMoverCelda(celda, dimencion));

		verify(celda).getX();
		
	}
	
	public void testMover(){
		
		Point celda = mock(Point.class);
		
		when(celda.getX()).thenReturn((double) 1);
		
		dir.mover(celda);
		
		verify(celda).getX();
	}
	
}
