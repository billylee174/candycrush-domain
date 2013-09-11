package explosionesTest;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import colores.Verde;
import explosiones.GranExplosion;

public class GranExplosionTest extends TestCase {

	//Variables
		public GranExplosion gExp;

		//SetUp
		public void setUp(){
			Verde mockColor = mock(Verde.class);
			gExp = new GranExplosion(mockColor, 10, 5);
		}

		//Tests
		public void testPuntos(){
			assertEquals(gExp.puntos(), 50);
		}
		
		public void testMismaMagnitud(){
			assertTrue(gExp.mismaMagnitud(5));
			assertFalse(gExp.mismaMagnitud(6));
		}
	
}
