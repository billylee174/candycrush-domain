package mundo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class JugadorTest {

	protected Jugador jugador;
	
	@Before
	public void setUp() throws Exception {
		Nivel primerNivel = mock(Nivel.class);
		this.jugador = new Jugador("Jorge", primerNivel);
	}

	@Test
	public void testJugador() {
		String nombre = "Jose";
		Nivel primerNivel = mock(Nivel.class);
		this.jugador = new Jugador(nombre, primerNivel);
		assertEquals(nombre, this.jugador.nombre);
		assertEquals(0, this.jugador.puntaje);
		assertEquals(1, this.jugador.getNivelesDisponibles().size());
		assertEquals(primerNivel, this.jugador.getNivelesDisponibles().get(0).getNivel());
	}

	@Test
	public void testAgregarNuevoNivelDisponible(){
		NivelDisponible nivelDisp = mock(NivelDisponible.class);
		Nivel viejoNivel = mock(Nivel.class);
		when(nivelDisp.getNivel()).thenReturn(viejoNivel);
		Nivel nuevoNivel = mock(Nivel.class);
		when(viejoNivel.getSiguienteNivel()).thenReturn(nuevoNivel);
		
		boolean found = false;
		
		for(NivelDisponible disp : this.jugador.getNivelesDisponibles())
			found = disp.getNivel() == nuevoNivel;
		
		assertFalse(found);
		this.jugador.agregarNuevoNivelDisponible(nivelDisp);
		
		for(NivelDisponible disp : this.jugador.getNivelesDisponibles())
			found = disp.getNivel() == nuevoNivel;
		
		assertTrue(found);
	}
	
	@Test
	public void testReiniciarJuego_MismoJugadorConSoloElPrimerNivelDisp() {
		String nombre = "nombre";
		Nivel primerNivel = mock(Nivel.class);
		this.jugador = new Jugador(nombre, primerNivel);
		this.jugador.setPuntaje(1525);
		assertEquals(1525, this.jugador.getPuntaje());
		this.jugador.reiniciarJuego();
		assertEquals(0, this.jugador.getPuntaje());
		assertEquals(nombre, this.jugador.getNombre());
		assertEquals(1, this.jugador.getNivelesDisponibles().size());
		assertEquals(primerNivel, this.jugador.getNivelesDisponibles().get(0).getNivel());
	}
	
	@Test
	public void testReiniciarJuego_SeReiniciaElPrimerNivelDisponible() {
		NivelDisponible primerNivelDisp = mock(NivelDisponible.class);
		List<NivelDisponible> nivelesDisp = new ArrayList<NivelDisponible>();
		nivelesDisp.add(primerNivelDisp);
		this.jugador.setNivelesDisponibles(nivelesDisp);
		this.jugador.reiniciarJuego();
		verify(primerNivelDisp).reiniciar();
	}

}
