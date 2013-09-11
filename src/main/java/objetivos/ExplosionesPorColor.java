package objetivos;

import colores.Dulce;
import explosiones.Explosion;

public class ExplosionesPorColor extends Adicional {
	
	// ****************************************************
	// * Variables
	// ****************************************************
	public int cantidadExplosion;

	// ****************************************************
	// * Accessors
	// ****************************************************
	public int getCantidadExplosion() {
		return cantidadExplosion;
	}
	public void setCantidadExplosion(int cantidadExplosion) {
		this.cantidadExplosion = cantidadExplosion;
	}

	// ****************************************************
	// * Constructores
	// ****************************************************
	public ExplosionesPorColor(int puntos, Dulce color, int cant){
		this.setPuntos(puntos);
		this.setDulce(color);
		this.setCantidadExplosion(cant);
	}

	// ****************************************************
	// * Metodos
	// ****************************************************
	
	/**
	 * Chequea si se realizo el objetivo
	 * 
	 * @param ObjetivoParaCumplir obj, Explosion exp
	 */
	public void chequearRealizacion(ObjetivoParaCumplir obj, Explosion exp){
		if(this.esMismoColor(exp)){
			obj.incrementarValorPartida();
		}
	}
	
	/**
	 * Retorna la cantidad de explosiones necesarias
	 * 
	 * @return int
	 */
	public int retCantExplosiones(){
		return this.getCantidadExplosion();
	}
	
	/**
	 * Retorna true si son del mismo color 
	 * 
	 * @param Explosion e
	 * @return boolean
	 */
	private boolean esMismoColor(Explosion e){
		return e.colorIgualA(this.getDulce());
	}
	
}
