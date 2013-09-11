package mundo;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import objetivos.Objetivo;
import objetivos.ObjetivoParaCumplir;

import org.junit.Before;
import org.junit.Test;

import dificultad.Dificultad;
import direcciones.Direccion;
import explosiones.Explosion;

import static org.mockito.Mockito.*;

public class PartidaTest {

	protected Partida partida;
	
	@Before
	public void setUp() throws Exception {
		Dificultad dificultad = mock(Dificultad.class);
		NivelDisponible nivelDisponible = mock(NivelDisponible.class);
		Nivel nivel = mock(Nivel.class);
		when(nivelDisponible.getNivel()).thenReturn(nivel);
		int movimientosDisponibles = 14;
		Point point = mock(Point.class);
		List<Objetivo> objetivos = new ArrayList<Objetivo>();
		when(nivel.getMovimientosDisponibles()).thenReturn(movimientosDisponibles);
		when(nivel.getDimensionTablero()).thenReturn(point);
		when(nivel.getObjetivos()).thenReturn(objetivos);
		this.partida = new Partida(nivelDisponible, dificultad);
	}

	@Test
	public void testPartida() {
		NivelDisponible nivelDisponible = mock(NivelDisponible.class);
		Dificultad dificultad = mock(Dificultad.class);
		int movimientosDisponibles = 14;
		
		Nivel nivel = mock(Nivel.class);
		when(nivelDisponible.getNivel()).thenReturn(nivel);
		when(nivel.getMovimientosDisponibles()).thenReturn(movimientosDisponibles);
		Point point = mock(Point.class);
		when(nivel.getDimensionTablero()).thenReturn(point);
		
		Objetivo objetivo1 = mock(Objetivo.class);
		Objetivo objetivo2 = mock(Objetivo.class);
		Objetivo objetivo3 = mock(Objetivo.class);
		List<Objetivo> objetivos = new ArrayList<Objetivo>();
		objetivos.add(objetivo1);
		objetivos.add(objetivo2);
		objetivos.add(objetivo3);
		when(nivel.getObjetivos()).thenReturn(objetivos);
		
		this.partida = new Partida(nivelDisponible, dificultad);
		
		assertEquals(movimientosDisponibles, this.partida.getMovimientosRestantes());
		assertEquals(0, this.partida.getPuntosAlcanzados());
		assertEquals(dificultad, this.partida.getDificultad());
		assertEquals(nivelDisponible, this.partida.getNivelDisponible());
		assertEquals(point, this.partida.getTablero().getDimension());
		//no se revisa si el tablero tiene la dificultad adecuada
		assertEquals(objetivos.size(), this.partida.getObjetivos().size());
		boolean found = true;
		for(ObjetivoParaCumplir objetivoParaCumplir : this.partida.getObjetivos())
		{	Objetivo aCumplir = objetivoParaCumplir.getObjetivoACumplir();
			if(found)
			{	found = aCumplir.equals(objetivo1) || 
						aCumplir.equals(objetivo2) || 
						aCumplir.equals(objetivo3);
			}
		}
		assertTrue(found);
	}

	@Test
	public void testSumarPuntos_DesdeCero() {
		assertEquals(0, this.partida.getPuntosAlcanzados());
		int puntos = 75;
		
		this.partida.sumarPuntos(puntos);
		assertEquals(puntos, this.partida.getPuntosAlcanzados());
	}
	
	@Test
	public void testSumarPuntos_ConPuntosYaHechos() {
		int puntosHechos = 50;
		int nuevosPuntos = 75;
		this.partida.setPuntosAlcanzados(puntosHechos);
		
		this.partida.sumarPuntos(nuevosPuntos);
		assertEquals(puntosHechos + nuevosPuntos, this.partida.getPuntosAlcanzados());
	}
	

	@Test
	public void testEsPartidaGanada_False() {
		ObjetivoParaCumplir objetivoIncompleto = mock(ObjetivoParaCumplir.class);
		ObjetivoParaCumplir objetivoCompleto = mock(ObjetivoParaCumplir.class);
		when(objetivoIncompleto.incompleto()).thenReturn(true);
		when(objetivoCompleto.incompleto()).thenReturn(false);
		List<ObjetivoParaCumplir> objetivos = new ArrayList<ObjetivoParaCumplir>();		
		this.partida.setObjetivos(objetivos);
		
		objetivos.add(objetivoIncompleto);
		assertFalse(this.partida.esPartidaGanada());
		
		objetivos.add(objetivoCompleto);
		assertFalse(this.partida.esPartidaGanada());
		
		objetivos.clear();
		objetivos.add(objetivoCompleto);
		assertTrue(this.partida.esPartidaGanada());
		
		objetivos.add(objetivoIncompleto);
		assertFalse(this.partida.esPartidaGanada());
	}
	
	@Test
	public void testEsPartidaGanada_True() {
		ObjetivoParaCumplir objetivoCompleto1 = mock(ObjetivoParaCumplir.class);
		ObjetivoParaCumplir objetivoCompleto2 = mock(ObjetivoParaCumplir.class);
		when(objetivoCompleto1.incompleto()).thenReturn(false);
		when(objetivoCompleto2.incompleto()).thenReturn(false);
		List<ObjetivoParaCumplir> objetivos = new ArrayList<ObjetivoParaCumplir>();		
		this.partida.setObjetivos(objetivos);
		
		objetivos.add(objetivoCompleto1);
		assertTrue(this.partida.esPartidaGanada());
		
		objetivos.add(objetivoCompleto2);
		assertTrue(this.partida.esPartidaGanada());
	}
	
	@Test
	public void testChequearVictoria_SinVictoria(){
		ObjetivoParaCumplir objetivoIncompleto = mock(ObjetivoParaCumplir.class);
		when(objetivoIncompleto.incompleto()).thenReturn(true);
		List<ObjetivoParaCumplir> objetivos = new ArrayList<ObjetivoParaCumplir>();
		objetivos.add(objetivoIncompleto);
		this.partida.setObjetivos(objetivos);
		
		this.partida.chequearVictoria();
		verify(this.partida.getNivelDisponible(), never()).ganar();
	}
	
	@Test
	public void testChequearVictoria_ConVictoria(){
		ObjetivoParaCumplir objetivoCompleto = mock(ObjetivoParaCumplir.class);
		when(objetivoCompleto.incompleto()).thenReturn(false);
		List<ObjetivoParaCumplir> objetivos = new ArrayList<ObjetivoParaCumplir>();
		objetivos.add(objetivoCompleto);
		this.partida.setObjetivos(objetivos);
		
		this.partida.chequearVictoria();
		verify(this.partida.getNivelDisponible()).ganar();
	}
	

	@Test
	public void testAgregarExplosion_ConUnObjetivo() {
		Explosion explosion = mock(Explosion.class);
		
		ObjetivoParaCumplir objetivo = mock(ObjetivoParaCumplir.class);
		List<ObjetivoParaCumplir> objetivos = new ArrayList<ObjetivoParaCumplir>();
		objetivos.add(objetivo);
		this.partida.setObjetivos(objetivos);
		
		this.partida.agregarExplosion(explosion);
		verify(objetivo).chequearRealizacion(explosion);
	}
	
	@Test
	public void testAgregarExplosion_ConVariosObjetivos() {
		Explosion explosion = mock(Explosion.class);
		
		ObjetivoParaCumplir objetivo1 = mock(ObjetivoParaCumplir.class);
		ObjetivoParaCumplir objetivo2 = mock(ObjetivoParaCumplir.class);
		ObjetivoParaCumplir objetivo3 = mock(ObjetivoParaCumplir.class);
		List<ObjetivoParaCumplir> objetivos = new ArrayList<ObjetivoParaCumplir>();
		objetivos.add(objetivo1);
		objetivos.add(objetivo2);
		this.partida.setObjetivos(objetivos);
		
		this.partida.agregarExplosion(explosion);
		verify(objetivo1).chequearRealizacion(explosion);
		verify(objetivo2).chequearRealizacion(explosion);
		
		objetivos.add(objetivo3);
		this.partida.agregarExplosion(explosion);
		verify(objetivo1, times(2)).chequearRealizacion(explosion);
		verify(objetivo2, times(2)).chequearRealizacion(explosion);
		verify(objetivo3).chequearRealizacion(explosion);
	}
	
	@Test
	public void testRealizarMovimiento_SinAccion(){
		Point point = mock(Point.class);
		Direccion direccion = mock(Direccion.class);
		Tablero tablero = mock(Tablero.class);
		this.partida.setTablero(tablero);
		int movimientosRestantes = 4;
		this.partida.setMovimientosRestantes(movimientosRestantes);
		
		when(tablero.moverCeldaA(point, direccion)).thenReturn(false);
		this.partida.realizarMovimiento(point, direccion);
		
		assertEquals(movimientosRestantes, this.partida.getMovimientosRestantes());
	}
	
	@Test
	public void testRealizarMovimiento_DecrementaMovimiento(){
		Point point = mock(Point.class);
		Direccion direccion = mock(Direccion.class);
		Tablero tablero = mock(Tablero.class);
		this.partida.setTablero(tablero);
		int movimientosRestantes = 4;
		this.partida.setMovimientosRestantes(movimientosRestantes);
		
		when(tablero.moverCeldaA(point, direccion)).thenReturn(true);
		this.partida.realizarMovimiento(point, direccion);
		
		assertEquals(movimientosRestantes - 1, this.partida.getMovimientosRestantes());
	}
	
	@Test
	public void testDecrementarMovimiento(){
		int movimientosRestantes = 4;
		this.partida.setMovimientosRestantes(movimientosRestantes);
		
		this.partida.decrementarMovimiento();
		assertEquals(movimientosRestantes - 1, this.partida.getMovimientosRestantes());
	}
}
