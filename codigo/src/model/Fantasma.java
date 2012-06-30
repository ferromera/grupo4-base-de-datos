package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import commons.PersistibleXML;

import helpers.LoggerHelper;

public class Fantasma implements Movible, Comible ,PersistibleXML{
	private Estado estado;
	private LoggerHelper logger;
	private Eslabon eslabon;
	
	public Fantasma (Eslabon eslabon, Estrategia estrategia){
		this.estado = new Cazador(this, estrategia);
		this.logger = new LoggerHelper("fantasma");
		this.eslabon = eslabon;
		this.eslabon.addComible(this);
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
	public void mover() {
		this.estado.mover();
		for(Comible c : this.eslabon.getComibles())
			c.esComidoPor(this);
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

	public void setEslabon(Eslabon eslabon) {
		this.eslabon = eslabon;
		this.eslabon.addComible(this);
	}

	@Override
	public Element writeToXmlFormat(Document listFantasmas) {
		Element elemFantasma = listFantasmas.createElement("fantasma");
		elemFantasma.setAttribute("id", "?");
		elemFantasma.setAttribute("nodo", String.valueOf(eslabon.getId()));
		elemFantasma.setAttribute("fila", String.valueOf(this.eslabon.getFila()));
		elemFantasma.setAttribute("columna", String.valueOf(this.eslabon.getColumna()));
		elemFantasma.setAttribute("sentido", "");
		elemFantasma.setAttribute("personalidad", this.estado.estrategia.getClass().getName());
		elemFantasma.setAttribute("estado", this.estado.getClass().getName());
		return elemFantasma;
	}
}
