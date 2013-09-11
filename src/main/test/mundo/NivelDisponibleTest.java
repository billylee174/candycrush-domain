package mundo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class NivelDisponibleTest {

	protected NivelDisponible nivelDisp;
	
	@Before
	public void setUp() throws Exception {
		Jugador jugador = mock(Jugador.class);
		Nivel nivel = mock(Nivel.class);
		this.nivelDisp = new NivelDisponible(jugador, nivel);
	}

	@Test
	public void testNivelDisponible() {
		Jugador jugador = mock(Jugador.class);
		Nivel nivel = mock(Nivel.class);
		this.nivelDisp = new NivelDisponible(jugador, nivel);
		assertEquals(jugador, this.nivelDisp.getJugador());
		assertEquals(nivel, this.nivelDisp.getNivel());
		assertEquals(0, this.nivelDisp.getPuntosObtenidos());		
	}

	@Test
	public void testGanar_NoUltimoNivel() {
		Nivel nivelActual = mock(Nivel.class);
		Nivel nivelSiguiente = mock(Nivel.class);
		this.nivelDisp.setNivel(nivelActual);
		when(nivelActual.getSiguienteNivel()).thenReturn(nivelSiguiente);
		
		this.nivelDisp.ganar();
		verify(this.nivelDisp.getJugador()).agregarNuevoNivelDisponible(this.nivelDisp);
	}
	
	@Test
	public void testGanar_UltimoNivel() {
		Nivel nivelActual = mock(Nivel.class);
		this.nivelDisp.setNivel(nivelActual);
		
		this.nivelDisp.ganar();
		verify(this.nivelDisp.getJugador(), never()).agregarNuevoNivelDisponible(this.nivelDisp);
	}
	
	@Test
	public void testReiniciar(){
		Jugador jugador = this.nivelDisp.getJugador();
		Nivel nivel = this.nivelDisp.getNivel();
		this.nivelDisp.setPuntosObtenidos(230);
		
		this.nivelDisp.reiniciar();
		
		assertEquals(jugador, this.nivelDisp.getJugador());
		assertEquals(nivel, this.nivelDisp.getNivel());
		assertEquals(0, this.nivelDisp.getPuntosObtenidos());
	}
	

}
