package model;

public class Bolon extends Punto {

	public Bolon(Eslabon eslabon, Laberinto laberinto) {
		super(eslabon, laberinto);
	}

	@Override
	public void esComidoPor(Comible comible) {
		//this.laberinto.iniciaPowerPellet();
	}

	@Override
	public Eslabon getEslabon() {
		return eslabon;
	}

}
