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
		System.out.println("SOY BOLITA Y SOY COMIDO por "+movible);
		movible.comerPunto(this);		
	}


	@Override
	public void serComido() {
		super.serComido(); //sumar puntos fuera del alcance
	}
}
