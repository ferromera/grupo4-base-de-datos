package model;

import helpers.LoggerHelper;

public class Fantasma {
	private Estado estado;
	private LoggerHelper logger;
	
	public Fantasma (){
		this.estado = new Cazador(this);
		this.logger = new LoggerHelper("fantasma");
	}
	
	public void esComido(){
		this.estado.esComido();
	}
	
	public void mover(){
		this.estado.mover();
	}
	
	public void pasaronSegundos(int segundos){
		this.estado.pasaronSegundos(segundos);
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		this.logger.log("Cambio de estado a: " + estado);
	}
	
	@Override
	public String toString() {
		return this.estado.toString();
	}

	public Estado getEstado() {
		return this.estado;
	}
	public void iniciaPowerPellet(){
		this.estado.iniciaPowerPellet();
	}
	
}
