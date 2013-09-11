package objetivosTest;

import explosiones.Explosion;
import objetivos.GrandesExplosiones;
import objetivos.Incompleto;
import objetivos.ObjetivoParaCumplir;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class ObjetivoParaCumplirTest extends TestCase {

	//Variables
	public ObjetivoParaCumplir obj;
	
	//Tests
	public void testChequearRealizacion(){
		GrandesExplosiones mockGExp = mock(GrandesExplosiones.class);
		obj = new ObjetivoParaCumplir(mockGExp);
		
		Incompleto mockInc = mock(Incompleto.class);
		obj.setEstado(mockInc);
		
		Explosion mockExp = mock(Explosion.class);
		
		when(mockInc.estaIncompleto()).thenReturn(true);
		
		obj.chequearRealizacion(mockExp);
		
		verify(mockInc).estaIncompleto();
		verify(mockGExp).chequearRealizacion(obj, mockExp);
		
	}
	
	public void testIncompleto(){
		GrandesExplosiones mockGExp = mock(GrandesExplosiones.class);
		obj = new ObjetivoParaCumplir(mockGExp);
		
		Incompleto mockInc = mock(Incompleto.class);
		obj.setEstado(mockInc);
		
		when(mockInc.estaIncompleto()).thenReturn(true);
		
		assertTrue(obj.incompleto());
		
		verify(mockInc).estaIncompleto();
	}
	
	public void testIncrementarValorPartida(){
		//TODO
	}
	
}
