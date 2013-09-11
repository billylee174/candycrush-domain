package objetivos;

public class Completo extends EstadoObjetivo {

	// ***************************************
	// * Metodos
	// ***************************************
	public boolean chequear() {
		return true;
	}
	public void actualizar(ObjetivoParaCumplir obj){}
	public boolean estaIncompleto(){return false;}
}
