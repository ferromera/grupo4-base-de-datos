package model;

import java.util.Iterator;
import java.util.List;


public class Pacman implements Comible, Movible {
	private Eslabon eslabon;

	public Pacman(Eslabon eslabon){
		this.eslabon = eslabon;
	}

	@Override
	public void mover(Direccion direccion) {
		Eslabon proximoEslabon;
		switch (direccion) {
		case ARRIBA:
			proximoEslabon = eslabon.getEslabonArriba();
			break;
		case ABAJO:
			proximoEslabon = eslabon.getEslabonAbajo();
			break;
		case DERECHA:
			proximoEslabon = eslabon.getEslabonDerecho();
			break;
		case IZQUIERDA:
			proximoEslabon = eslabon.getEslabonIzquierdo();
			break;
		}
		this.comerEn(eslabon);

	}

	public void comerEn(Eslabon eslabon2) {

		if (eslabon2!=null){
			eslabon2.comiblesComidosPor(this);
		}	
	}

	@Override
	public Eslabon getEslabon() {
		return this.eslabon;
	}

	@Override
	public void esComidoPor(Movible movible) {
		movible.comerPacman(this);
	}

	@Override
	public void comerPunto(Punto punto) {
		punto.serComido();		
	}

	@Override
	public void comerFantasma(Fantasma fantasma) {
		fantasma.serComido(this);		
	}
	public void serComido(Fantasma fantasma){
		//TODO
	}

	@Override
	public void comerPacman(Pacman pacman) {
		// no hago nada... no como pacmans		
	}
}
