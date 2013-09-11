package mundo;

import java.awt.Point;
import java.util.List;

import objetivos.Objetivo;

public class Nivel {
	
	protected String nombre;
	protected Point dimensionTablero;
	protected int movimientosDisponibles;
	protected Nivel siguienteNivel;
	protected List<Objetivo> objetivos;
	
	/**
	 * @param nombre nombre del nivel
	 * @param dimensionTablero
	 * @param movimientosDisponibles
	 * @param objetivos
	 */
	public Nivel(String nombre, Point dimensionTablero,
			int movimientosDisponibles, List<Objetivo> objetivos) {
		super();
		this.nombre = nombre;
		this.dimensionTablero = dimensionTablero;
		this.movimientosDisponibles = movimientosDisponibles;
		this.objetivos = objetivos;
	}
	
	//getters y setters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public Point getDimensionTablero() {return dimensionTablero;}
	public void setDimensionTablero(Point dimensionTablero) 
		{this.dimensionTablero = dimensionTablero;}
	public int getMovimientosDisponibles() {return movimientosDisponibles;}
	public void setMovimientosDisponibles(int movimientosDisponibles) 
		{this.movimientosDisponibles = movimientosDisponibles;}
	public Nivel getSiguienteNivel() {return siguienteNivel;}
	public void setSiguienteNivel(Nivel siguienteNivel) {this.siguienteNivel = siguienteNivel;}
	public List<Objetivo> getObjetivos() {return objetivos;}
	public void setObjetivos(List<Objetivo> objetivos) {this.objetivos = objetivos;}

}
