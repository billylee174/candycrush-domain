package objetivos;

public abstract class EstadoObjetivo {

	public abstract boolean chequear();
	public abstract void actualizar(ObjetivoParaCumplir obj);
	public abstract boolean estaIncompleto();
}
