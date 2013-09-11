package objetivosTest;

import static org.mockito.Mockito.*;
import objetivos.GrandesExplosiones;
import objetivos.ObjetivoParaCumplir;
import colores.Verde;
import explosiones.Explosion;
import junit.framework.TestCase;

public class GrandesExplosionesTest extends TestCase {
	
	//Variables
	public GrandesExplosiones obj;
		
	//SetUp
	public void setUp(){
		Verde mockVerde = mock(Verde.class);
		
		obj = new GrandesExplosiones(1, mockVerde, 2);
	}
	
	//Tests
	public void testChequearRealizacion(){
		Explosion mockExp = mock(Explosion.class);
		ObjetivoParaCumplir mockObj = mock(ObjetivoParaCumplir.class);
		
		when(mockExp.colorIgualA(obj.getDulce())).thenReturn(true);
		when(mockExp.mismaMagnitud(obj.getMagnitudExplosion())).thenReturn(true);
		
		obj.chequearRealizacion(mockObj, mockExp);
		
		verify(mockExp).colorIgualA(obj.getDulce());
		verify(mockExp).mismaMagnitud(obj.getMagnitudExplosion());
		
		verify(mockObj).actualizar();
	}
	
}
