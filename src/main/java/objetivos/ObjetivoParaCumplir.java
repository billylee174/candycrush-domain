package objetivos;

import explosiones.Explosion;

public class ObjetivoParaCumplir {

	// ***************************************
	// * Variables
	// ***************************************
	public Objetivo objetivoACumplir;
	public EstadoObjetivo estado;
	public int valorPartida;
	
	// ***************************************
	// * Accessors
	// ***************************************
	public Objetivo getObjetivoACumplir() {
		return objetivoACumplir;
	}
	public void setObjetivoACumplir(Objetivo objetivoACumplir) {
		this.objetivoACumplir = objetivoACumplir;
	}
	public int getValorPartida() {
		return valorPartida;
	}
	public void setValorPartida(int valorPartida) {
		this.valorPartida = valorPartida;
	}
	public EstadoObjetivo getEstado() {
		return estado;
	}
	public void setEstado(EstadoObjetivo estado) {
		this.estado = estado;
	}
	
	// ***************************************
	// * Constructores
	// ***************************************
	public ObjetivoParaCumplir(Objetivo obj){
		this.setObjetivoACumplir(obj);
		this.setValorPartida(0);
		this.setEstado(new Incompleto());
	}
	
	// ***************************************
	// * Metodos
	// ***************************************
	
	/**
	 * Si el objetivo esta incompleto, chequea su realizacion
	 * @param Explosion e
	 */
	public void chequearRealizacion(Explosion e){
		if(this.incompleto()){
		this.getObjetivoACumplir().chequearRealizacion(this, e);
		}
	}
	
	/**
	 * Retorna true si esta incompleto
	 * @return
	 */
	public boolean incompleto() {
		return this.getEstado().estaIncompleto();
	}
	
	/**
	 * Actualiza el estado
	 */
	public void actualizar(){
		this.getEstado().actualizar(this);
	}
	
	/**
	 * Incrementa la variable valorPartida en 1
	 * Si se completo la cantidad de explosiones, se actualiza el estado
	 */
	public void incrementarValorPartida(){
		this.setValorPartida(this.getValorPartida() + 1);
		
		if(this.cantExplosiones() == this.getValorPartida()){
			this.actualizar();
		}
	}
	
	/**
	 * Retorna la cantidad de explosiones del objetivo
	 * @return
	 */
	private int cantExplosiones() {
		return this.getObjetivoACumplir().retCantExplosiones();
	}
	
}
