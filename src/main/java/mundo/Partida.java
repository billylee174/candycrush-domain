package mundo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import dificultad.Dificultad;
import direcciones.Direccion;
import explosiones.Explosion;

import objetivos.Objetivo;
import objetivos.ObjetivoParaCumplir;

public class Partida {
	
	protected int movimientosRestantes;
	protected int puntosAlcanzados;
	protected Tablero tablero;
	protected Dificultad dificultad;
	protected NivelDisponible nivelDisponible;
	protected List<ObjetivoParaCumplir> objetivos;
	
	/**
	 * @param nivelDisponible nivel a jugarse
	 * @param dificultad dificultad seleccionada
	 */
	public Partida(NivelDisponible nivelDisponible, Dificultad dificultad) {
		super();
		this.nivelDisponible = nivelDisponible;
		this.dificultad = dificultad;
		Nivel nivel = this.nivelDisponible.getNivel();
		this.puntosAlcanzados = 0;
		this.movimientosRestantes = nivel.getMovimientosDisponibles();
		this.tablero = new Tablero(nivel.getDimensionTablero(), this.dificultad);
		this.objetivos = new ArrayList<ObjetivoParaCumplir>();
		for(Objetivo objetivo : nivel.getObjetivos())
			this.objetivos.add(new ObjetivoParaCumplir(objetivo));
	}

	/** Agrega puntos
	 * @param cantPuntos cantidad de puntos a sumarse
	 */
	public void sumarPuntos(int cantPuntos){
		this.setPuntosAlcanzados(cantPuntos + this.getPuntosAlcanzados());
	}
	
	/** Revisa las condiciones de victoria
	 * @return si la partida ha sido ganada
	 */
	public boolean esPartidaGanada(){
		boolean ganada = true;
		for(int i = 0; ganada && i < this.getObjetivos().size(); i++)
			ganada = ! this.getObjetivos().get(i).incompleto();
		return ganada;
	}
	
	
	/**
	 * Declara la partida ganada si es que se ha ganado
	 */
	public void chequearVictoria(){
		if(this.esPartidaGanada())
			this.getNivelDisponible().ganar();
	}
	
	/** Notifica de la explosion a los objetivos para que se actualicen
	 * @param explosion explosion realizada
	 */
	public void agregarExplosion(Explosion explosion){
		for(ObjetivoParaCumplir objetivo : this.getObjetivos())
			objetivo.chequearRealizacion(explosion);
	}
	
	/** Da la orden de mover el dulce de una ubicacion en una direccion
	 * @param point ubicacion a mover
	 * @param direccion direccion a mover
	 */
	public void realizarMovimiento(Point point, Direccion direccion){
		if(this.getTablero().moverCeldaA(point, direccion))
			this.decrementarMovimiento();
	}
	
	/**
	 * Resta en 1 la cantidad de movimientos restantes
	 */
	public void decrementarMovimiento(){
		this.setMovimientosRestantes(this.getMovimientosRestantes() - 1);
	}
	
	//getters y setters
	public int getMovimientosRestantes() {return movimientosRestantes;}
	public void setMovimientosRestantes(int movimientosRestantes) 
		{this.movimientosRestantes = movimientosRestantes;}
	public int getPuntosAlcanzados() {return puntosAlcanzados;}
	public void setPuntosAlcanzados(int puntosAlcanzados) 
		{this.puntosAlcanzados = puntosAlcanzados;}
	public Tablero getTablero() {return tablero;}
	public void setTablero(Tablero tablero) {this.tablero = tablero;}
	public Dificultad getDificultad() {return dificultad;}
	public void setDificultad(Dificultad dificultad) {this.dificultad = dificultad;}
	public List<ObjetivoParaCumplir> getObjetivos() {return objetivos;}
	public void setObjetivos(List<ObjetivoParaCumplir> objetivos) 
		{this.objetivos = objetivos;}
	public NivelDisponible getNivelDisponible() {return nivelDisponible;}
	public void setNivelDisponible(NivelDisponible nivelDisponible) 
		{this.nivelDisponible = nivelDisponible;}
	

}
