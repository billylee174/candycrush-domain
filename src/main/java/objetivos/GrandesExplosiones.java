package objetivos;

import colores.Dulce;
import explosiones.Explosion;

public class GrandesExplosiones extends Adicional {
	
	// ****************************************************
	// * Variables
	// ****************************************************
	public int magnitudExplosion;

	// ****************************************************
	// * Accessors
	// ****************************************************
	public int getMagnitudExplosion() {
		return magnitudExplosion;
	}
	public void setMagnitudExplosion(int magnitudExplosion) {
		this.magnitudExplosion = magnitudExplosion;
	}

	// ****************************************************
	// * Constructores
	// ****************************************************
	public GrandesExplosiones(int puntos, Dulce color, int cant){
		this.setPuntos(puntos);
		this.setDulce(color);
		this.setMagnitudExplosion(cant);
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
		if(this.esCompatible(exp)){
			obj.actualizar();
		}
	}
	
	/**
	 * Retorna true si la explosion es compatible con el objetivo
	 * @param exp
	 * @return
	 */
	private boolean esCompatible(Explosion exp) {
		return this.esMismoColor(exp) && this.esMismaMagnitud(exp);
	}
	
	public int retCantExplosiones(){
		return 0;
	}
	
	/**
	 * Retorna true si son de la misma magnitud
	 * @param Explosion e
	 * @return boolean
	 */
	private boolean esMismaMagnitud(Explosion e) {
		return e.mismaMagnitud(this.getMagnitudExplosion());
	}
	
	/**
	 * Retorna true si son del mismo color
	 * @param Explosion e
	 * @return boolean
	 */
	private boolean esMismoColor(Explosion e){
		return e.colorIgualA(this.getDulce());
	}
}
