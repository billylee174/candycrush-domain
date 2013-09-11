package objetivosTest;

import objetivos.Incompleto;
import junit.framework.TestCase;


public class IncompletoTest extends TestCase {

	//Variables
	public Incompleto estado = new Incompleto();
	
	//Tests
	public void testEstaIncompleto(){
		assertTrue(estado.estaIncompleto());
	}
	
}
