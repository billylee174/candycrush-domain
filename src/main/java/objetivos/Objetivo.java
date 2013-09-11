package objetivos;

import explosiones.Explosion;

public abstract class Objetivo {

	// ****************************************************
	// * Variables
	// ****************************************************
	public int puntos;

	// ****************************************************
	// * Accessors
	// ****************************************************
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
		
	// ****************************************************
	// * Metodos
	// ****************************************************
	public abstract void chequearRealizacion(ObjetivoParaCumplir obj, Explosion exp);
	public abstract int retCantExplosiones();
	
}
