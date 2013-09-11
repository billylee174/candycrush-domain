package colores;

public class Dulce {

	private String color;
	
	public boolean compatibleConColor(Dulce d){
		return this.color.equals(d.getColor());
	}

	public String getColor() {
		return color;
	}
	
	public List getTiposDeDulcesPosibles(){
		creamos la lista
		instanciamos un amarillo, un verde ...
	}
	
}
