package objetivos;

public class Incompleto extends EstadoObjetivo {

	// ***************************************
	// * Metodos
	// ***************************************
	public boolean chequear() {
		return false;
	}
	public void actualizar(ObjetivoParaCumplir obj){
		Completo e = new Completo();
		obj.setEstado(e);
	}

	public boolean estaIncompleto(){return true;}
}
