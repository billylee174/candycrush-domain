package direcciones;

import java.awt.Point;


public class Derecha extends Direccion {

	// ****************************************************
	// * Metodos
	// ****************************************************
	
	/**
	 * Retorna true si puede mover hacia la Derecha, false en caso contrario
	 *  
	 * @param Point celda
	 * @param Point dimencion
	 * 
	 * @return boolean
	 */
	public boolean puedeMoverCelda(Point celda, Point dimencion){		
		return (celda.getX() + 1) <= (dimencion.getX());
	}

	/**
	 * Retorna un nuevo Punto, moviendolo 1 hacia la Derecha
	 * 
	 * @param Point p
	 * @return Point
	 */
	public Point mover(Point p){
		p.move((int)p.getX() + 1, (int)p.getY());
		return p;
	}

}
