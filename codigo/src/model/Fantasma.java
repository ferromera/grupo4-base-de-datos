package model;

import helpers.LoggerHelper;

public class Fantasma implements Movible, Comible, Posicionable {
	private Estado estado;
	private LoggerHelper logger;
	private Eslabon eslabon;
	
	public Fantasma (){
		this.estado = new Cazador(this);
		this.logger = new LoggerHelper("fantasma");
	}
	
	public void esComidoPor(Comible comible) {
		this.estado.esComidoPor(comible);
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

	@Override
	public void mover(Direccion direccion) {
		this.estado.mover(direccion);
	}

	@Override
	public Eslabon getEslabon() {
		return this.eslabon;
	}
}
