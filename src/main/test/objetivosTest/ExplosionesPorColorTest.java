package objetivosTest;

import colores.Verde;
import explosiones.Explosion;
import objetivos.ExplosionesPorColor;
import objetivos.ObjetivoParaCumplir;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class ExplosionesPorColorTest extends TestCase {

	//Variables
	public ExplosionesPorColor obj;
	
	//SetUp
	public void setUp(){
		Verde mockVerde = mock(Verde.class);
		
		obj = new ExplosionesPorColor(1, mockVerde, 2);
	}
	
	//Tests
	public void testChequearRealizacion(){
		Explosion mockExp = mock(Explosion.class);
		ObjetivoParaCumplir mockObj = mock(ObjetivoParaCumplir.class);
		
		when(mockExp.colorIgualA(obj.getDulce())).thenReturn(true);
		
		obj.chequearRealizacion(mockObj, mockExp);
		
		verify(mockExp).colorIgualA(obj.getDulce());
		verify(mockObj).incrementarValorPartida();
	}
	
	public void testRetCantExplosiones(){
		assertEquals(obj.retCantExplosiones(), 2);
	}
	
}
