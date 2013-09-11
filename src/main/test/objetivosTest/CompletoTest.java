package objetivosTest;

import objetivos.Completo;
import junit.framework.TestCase;

public class CompletoTest extends TestCase {

	//Variables
	public Completo estado = new Completo();
	
	//Tests
	public void testEstaIncompleto(){
		assertFalse(estado.estaIncompleto());
	}
}
