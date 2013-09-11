package direcciones;

import java.awt.Point;

public class Abajo extends Direccion {

	// ****************************************************
	// * Metodos
	// ****************************************************
	
	/**
	 * Retorna true si puede mover hacia Abajo, false en caso contrario
	 *  
	 * @param Point celda
	 * @param Point dimencion
	 * 
	 * @return boolean
	 */
	public boolean puedeMoverCelda(Point celda, Point dimencion) {
		return (celda.getY() - 1) >= 0;
	}

	/**
	 * Retorna un nuevo Punto, moviendolo 1 hacia Abajo
	 * 
	 * @param Point p
	 * @return Point
	 */
	public Point mover(Point p) {
		p.move((int)p.getX(),(int)p.getY()-1);
		return p;
	}

}
