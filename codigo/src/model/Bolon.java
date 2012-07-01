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
		
		movible.comerPunto(this);
	}

	@Override
	public void serComido() {
		laberinto.iniciaPowerPellet();
		System.out.println("SOY BOLON Y SOY COMIDO ");
		super.serComido();		
	}



	public void setLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
		
	}
}
