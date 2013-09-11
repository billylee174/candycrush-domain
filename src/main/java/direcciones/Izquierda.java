package direcciones;

import java.awt.Point;

public class Izquierda extends Direccion {

	// ****************************************************
	// * Metodos
	// ****************************************************
	
	/**
	 * Retorna true si puede mover hacia la Izquierda, false en caso contrario
	 *  
	 * @param Point celda
	 * @param Point dimencion
	 * 
	 * @return boolean
	 */
	public boolean puedeMoverCelda(Point celda, Point dimencion) {
		return (celda.getX() - 1) >= 0;
	}

	/**
	 * Retorna un nuevo Punto, moviendolo 1 hacia la Izquierda
	 * 
	 * @param Point p
	 * @return Point
	 */
	public Point mover(Point p) {
		p.move((int)p.getX()-1,(int) p.getY());
		return p;
	}

}
