package mundo;

public class NivelDisponible {
	
	protected int puntosObtenidos;
	protected Jugador jugador;
	protected Nivel nivel;
	
	/**
	 * @param jugador jugador que tiene el nivel disponible
	 * @param nivel el nivel que esta disponible
	 */
	public NivelDisponible(Jugador jugador, Nivel nivel) {
		super();
		this.puntosObtenidos = 0;
		this.jugador = jugador;
		this.nivel = nivel;
	}

	/** 
	 * Se considerara al nivel como ganado
	 */
	public void ganar(){
		if(this.getNivel().getSiguienteNivel() != null)
			this.getJugador().agregarNuevoNivelDisponible(this);
	}
	
	/**
	 * Vuelve los datos actuales a sus valores iniciales
	 */
	public void reiniciar(){
		this.setPuntosObtenidos(0);
	}
	
	//getters y setters
	public int getPuntosObtenidos() {return puntosObtenidos;}
	public void setPuntosObtenidos(int puntosObtenidos) {this.puntosObtenidos = puntosObtenidos;}
	public Jugador getJugador() {return jugador;}
	public void setJugador(Jugador jugador) {this.jugador = jugador;}
	public Nivel getNivel() {return nivel;}
	public void setNivel(Nivel nivel) {this.nivel = nivel;}
	
}
