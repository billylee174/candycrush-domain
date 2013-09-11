package explosiones;

import colores.Dulce;

public class Explosion {

	// ****************************************************
	// * Variables
	// ****************************************************
	public Dulce dulce;
	public static int valor;
	
		
	// ****************************************************
	// * Accessors
	// ****************************************************
	public Dulce getDulce() {
		return dulce;
	}
	public void setDulce(Dulce color) {
		this.dulce = color;
	}
	public static int getValor() {
		return valor;
	}
	public static void setValor(int valor) {
		Explosion.valor = valor;
	}	

	// ****************************************************
	// * Constructores
	// ****************************************************
	public Explosion(Dulce d, int v){
		this.setDulce(d);
		this.setValor(v);	
	}

	// ****************************************************
	// * Metodos
	// ****************************************************
	
	/**
	 * Retorna los puntos de la explosion
	 * 
	 * Puntos = (valor de la explocion) * (magnitud de la explocion)
	 * magnitud de una Explocion = 3
	 * 
	 * @return int
	 */
	public int puntos(){
		return (this.getValor() * 3); 
	}

	/**
	 * Retorna true si el Dulce pasado por parametro es compatible con el dulce de la explocion
	 * 
	 * @param Dulce d
	 * @return boolean
	 */
	public boolean colorIgualA(Dulce d){
		return this.getDulce().compatibleConColor(d);
	}
	
	/**
	 * Retorna true si la magnitud pasada por parametro es igual a 3
	 * 
	 *  La magnitud de una explocion comun es siempre 3
	 * 
	 * @param int magnitud
	 * @return boolean
	 */
	public boolean mismaMagnitud(int magnitud) {
		return magnitud == 3;
	}
	
}
