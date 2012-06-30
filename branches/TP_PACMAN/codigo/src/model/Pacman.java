package model;

public class Pacman implements Comible, Movible {
	private Eslabon eslabon;
	private boolean muerto;

	public Pacman(Eslabon eslabon){
		this.eslabon = eslabon;
		this.eslabon.addComible(this);
		muerto = false;
	}

	@Override
	public void mover() {
		Eslabon proximoEslabon;
		Direccion direccion = Direccion.ABAJO;
		switch (direccion ) {
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
		//aca va la estrategia por ahora hardcodeado a ir arriba
	}
	
	public void mover(Direccion direccion){
		Eslabon proximoEslabon = eslabon;

		switch (direccion ) {
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
			this.comerEn(proximoEslabon);
	}

	public void comerEn(Eslabon eslabon2) {
		if (eslabon2!=null){
			eslabon2.comiblesComidosPor(this);
		}
		eslabon = eslabon2;
	}

	@Override
	public Eslabon getEslabon() {
		return this.eslabon;
	}

	@Override
	public void esComidoPor(Movible movible) {
		System.out.println("Estoy siendo comido - pacman");
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
		muerto = true;
	}

	@Override
	public void comerPacman(Pacman pacman) {
		// no hago nada... no como pacmans		
	}

	public void setEslabon(Eslabon eslabon) {
		this.eslabon = eslabon;
		this.eslabon.addComible(this);
	}
	
	public boolean estaMuerto(){
		return muerto;
	}

}
