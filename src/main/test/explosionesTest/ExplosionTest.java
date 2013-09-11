package explosionesTest;

import colores.Verde;
import explosiones.Explosion;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class ExplosionTest extends TestCase {

	//Variables
	public Explosion exp;

	//SetUp
	public void setUp(){
		Verde mockColor = mock(Verde.class);
		exp = new Explosion(mockColor, 10);
	}

	//Tests
	public void testAlHacerUnaExplosionLosPuntosSeCalculanCorrectamente(){
		int puntosPorDulce = 10;
		int cantidadDeDulcesEnLaExplosion = 3;
		exp = new Explosion(mock(Verde.class), puntosPorDulce);
		
		int expected = cantidadDeDulcesEnLaExplosion*puntosPorDulce;
		
		assertEquals(expected,exp.puntos());
	}
	
	//public void testColorIgualA(){
		//Verde mocoVerde = mock(Verde.class);
		
		//assertTrue(exp.colorIgualA(mocoVerde));
		
		//verify(mocoVerde).
	//}
	
	public void testMismaMagnitud(){
		assertTrue(exp.mismaMagnitud(3));
	}
}
