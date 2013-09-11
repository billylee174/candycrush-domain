package mundo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	protected String nombre;
	protected int puntaje;
	protected List<NivelDisponible> nivelesDisponibles;
	
	/**
	 * @param nombre nombre del jugador
	 * @param primerNivel primer nivel disponible a jugarse
	 */
	public Jugador(String nombre, Nivel primerNivel) {
		super();
		this.nombre = nombre;
		this.puntaje = 0;
		this.nivelesDisponibles = new ArrayList<NivelDisponible>();
		this.nivelesDisponibles.add(new NivelDisponible(this, primerNivel));
	}
	
	/**
	 * Reinicia el juego, deshabilitando todos los niveles posteriores al primero.
	 * Se eliminan todos los puntos obtenidos
	 * No se eliminan los niveles adicionales creados
	 */
	public void reiniciarJuego(){
		this.setPuntaje(0);
		NivelDisponible primerNivelDisponible = this.getNivelesDisponibles().get(0);
		primerNivelDisponible.reiniciar();
		this.nivelesDisponibles = new ArrayList<NivelDisponible>();
		this.nivelesDisponibles.add(primerNivelDisponible);
	}
	
	/** Se agrega a la lista de niveles disponibles el siguiente nivel
	 * 		correspondiente al parametro
	 * @param nivelPasado
	 */
	protected void agregarNuevoNivelDisponible(NivelDisponible nivelPasado){
		NivelDisponible nuevoNivel = new NivelDisponible(
				this, nivelPasado.getNivel().getSiguienteNivel());
		this.getNivelesDisponibles().add(nuevoNivel);	
	}

	//Todos los getters/setters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public int getPuntaje() {return puntaje;}
	public void setPuntaje(int puntaje) {this.puntaje = puntaje;}
	public List<NivelDisponible> getNivelesDisponibles() {return nivelesDisponibles;}
	public void setNivelesDisponibles(List<NivelDisponible> nivelesDisponibles) 
		{this.nivelesDisponibles = nivelesDisponibles;}
	
}
