package direcciones;

import java.awt.Point;

public abstract class Direccion {

	// ****************************************************
	// * Metodos
	// ****************************************************
	public abstract boolean puedeMoverCelda(Point celda, Point dimencion);
	public abstract Point mover(Point p);

}
