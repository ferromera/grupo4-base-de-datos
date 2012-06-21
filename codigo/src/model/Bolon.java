package model;



public class Bolon extends Punto {

	public Bolon(Eslabon eslabon, Laberinto laberinto) {
		super(eslabon, laberinto);
	}



	@Override
	public Eslabon getEslabon() {
		return eslabon;
	}

	@Override
	public void esComidoPor(Movible movible) {
		System.out.println("SOY BOLON Y SOY COMIDO por "+movible);
	}

	@Override
	public void serComido() {
		laberinto.iniciaPowerPellet();
		super.serComido();		
	}
}
