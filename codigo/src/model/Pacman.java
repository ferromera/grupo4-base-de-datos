package model;


public class Pacman implements Comible, Movible, Posicionable {
	private Eslabon eslabon;

	public Pacman(Eslabon eslabon){
		this.eslabon = eslabon;
	}
	
	@Override
	public void mover(Direccion direccion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void esComidoPor(Comible comible) {
	
	}

	@Override
	public Eslabon getEslabon() {
		return this.eslabon;
	}

}
