package direccionesTest;

import java.awt.Point;

import direcciones.Arriba;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class ArribaTest extends TestCase {

	//Variables
	public Arriba dir = new Arriba();
	
	//Tests
	public void testPuedeMoverCelda(){
		
		Point celda = mock(Point.class);
		Point dimencion = mock(Point.class);
		
		when(celda.getY()).thenReturn((double) 0);
		when(dimencion.getY()).thenReturn((double) 1);
		
		assertTrue(dir.puedeMoverCelda(celda, dimencion));
		
		verify(celda).getY();
		verify(dimencion).getY();
	}
	
	public void testMover(){
		
		Point celda = mock(Point.class);
		
		when(celda.getY()).thenReturn((double) 0);
		
		dir.mover(celda);
		
		verify(celda).getY();
		verify(celda).getY();
	}
	
}
