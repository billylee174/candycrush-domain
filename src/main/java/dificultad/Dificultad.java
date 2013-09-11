package dificultad;

import java.util.List;

import colores.Dulce;

public class Dificultad {
	
	protected List<Dulce> dulces;

	public Dificultad(List<Dulce> dulces) {
		super();
		this.dulces = dulces;
	}
	
	public List<Dulce> getDulces() {return dulces;}
	public void setDulces(List<Dulce> dulces) {this.dulces = dulces;}

}
