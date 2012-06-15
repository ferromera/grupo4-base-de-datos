package model;

public class Bolon extends Punto {

	public Bolon(Laberinto laberinto) {
		super(laberinto);
	}

	@Override
	public void esComidoPor(Comible comible) {
		this.laberinto.iniciaPowerPellet();
	}

}
