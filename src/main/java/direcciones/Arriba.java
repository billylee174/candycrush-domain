package direcciones;

import java.awt.Point;

public class Arriba extends Direccion {

	// ****************************************************
	// * Metodos
	// ****************************************************
	
	/**
	 * Retorna true si puede mover hacia Arriva, false en caso contrario
	 *  
	 * @param Point celda
	 * @param Point dimencion
	 * 
	 * @return boolean
	 */
	public boolean puedeMoverCelda(Point celda, Point dimencion) {
		return (celda.getY() + 1) <= (dimencion.getY());
	}

	/**
	 * Retorna un nuevo Punto, moviendolo 1 hacia arriba
	 * 
	 * @param Point p
	 * @return Point
	 */
	public Point mover(Point p) {
		p.move((int)p.getX(),(int)p.getY()+1);
		return p;
	}

}
