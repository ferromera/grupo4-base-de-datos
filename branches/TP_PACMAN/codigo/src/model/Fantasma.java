package model;

import helpers.LoggerHelper;

public class Fantasma implements Movible, Comible {
	private Estado estado;
	private LoggerHelper logger;
	private Eslabon eslabon;
	
	public Fantasma (Eslabon eslabon){
		this.estado = new Cazador(this);
		this.logger = new LoggerHelper("fantasma");
		this.eslabon = eslabon;
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

	@Override
	public void esComidoPor(Movible movible) {
		//aca hay que hacer algo con el estado...
		movible.comerFantasma(this);		
	}

	@Override
	public void comerPunto(Punto punto) {
		// Este no hace nada.. no come bolitas
	}

	@Override
	public void comerFantasma(Fantasma fantasma) {
		//no hace nada.. no come fantasmas
	}

	public void serComido(Pacman pacman) {
		// TODO algo con estados aca
		estado.esComidoPor(pacman);
		
	}

	@Override
	public void comerPacman(Pacman pacman) {
		//algo con estados aca?
		pacman.serComido(this);		
	}


}
