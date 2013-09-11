package objetivos;

import explosiones.Explosion;

public class Regular extends Objetivo {

	// ****************************************************
	// * Variables
	// ****************************************************
	public int puntajeMinimo;

	// ****************************************************
	// * Accessors
	// ****************************************************
	public int getPuntajeMinimo() {
		return puntajeMinimo;
	}
	public void setPuntajeMinimo(int puntajeMinimo) {
		this.puntajeMinimo = puntajeMinimo;
	}

	// ****************************************************
	// * Constructores
	// ****************************************************
	public Regular(int p, int pMin){
		this.setPuntos(p);
		this.setPuntajeMinimo(pMin);	
	}

	// ****************************************************
	// * Metodos
	// ****************************************************
	public void chequearRealizacion(ObjetivoParaCumplir obj, Explosion exp){ 
		//No se que tiene que hacer 
	}
	public int retCantExplosiones(){
		return 0;
	}
}
