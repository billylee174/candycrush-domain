package coloresTest;

import colores.Amarillo;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class AmarilloTest extends TestCase {
	
	//Variable
	public Amarillo dulceAmarillo = new Amarillo();

	//Tests
	public void testCompatibleConColor(){
		Amarillo mockAmarillo = mock(Amarillo.class);
		
		when(mockAmarillo.compatibleConAmarillo()).thenReturn(true);
		
		assertTrue(dulceAmarillo.compatibleConColor(mockAmarillo));
		
		verify(mockAmarillo).compatibleConAmarillo();
	}

	public void testCompatibleConAmarillo(){
		assertTrue(dulceAmarillo.compatibleConAmarillo());
	}
	
	public void testCompatibleConCeleste(){
		assertFalse(dulceAmarillo.compatibleConCeleste());
	}
	public void testCompatibleConVerde(){
		assertFalse(dulceAmarillo.compatibleConVerde());
	}
	public void testCompatibleConRojo(){
		assertFalse(dulceAmarillo.compatibleConRojo());
	}
	public void testCompatibleConNaranja(){
		assertFalse(dulceAmarillo.compatibleConNaranja());
	}
	public void testCompatibleConVioleta(){
		assertFalse(dulceAmarillo.compatibleConVioleta());
	}

}
