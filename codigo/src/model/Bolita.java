package model;

public class Bolita extends Punto {

	public Bolita(Eslabon eslabon, Laberinto laberinto) {
		super(eslabon, laberinto);
	}



	@Override
	public Eslabon getEslabon() {
		return eslabon;
	}



	@Override
	public void esComidoPor(Movible movible) {
		// TODO Auto-generated method stub
		
	}

}
