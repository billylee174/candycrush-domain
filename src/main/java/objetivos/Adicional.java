package objetivos;

import colores.Dulce;

public abstract class Adicional extends Objetivo {
	
	// ****************************************************
	// * Variables
	// ****************************************************
	public Dulce dulce;

	// ****************************************************
	// * Accessors
	// ****************************************************
	public Dulce getDulce() {
		return dulce;
	}
	public void setDulce(Dulce color) {
		this.dulce = color;
	}
	
}
