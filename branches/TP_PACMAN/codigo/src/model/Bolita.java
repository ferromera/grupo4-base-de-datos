package model;

public class Bolita extends Punto {

	public Bolita(Eslabon eslabon, Laberinto laberinto) {
		super(eslabon, laberinto);
	}

	@Override
	public void esComidoPor(Comible comible) {
		//Deberia sumarle puntos al pacman. No forma parte del enunciado.
	}

	@Override
	public Eslabon getEslabon() {
		return eslabon;
	}

}
