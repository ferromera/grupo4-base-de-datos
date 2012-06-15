package model;

public abstract class Punto implements Comible {
	protected Laberinto laberinto;
	
	protected Punto(Laberinto laberinto){
		this.laberinto = laberinto;
	}
	
	@Override
	abstract public void esComidoPor(Comible comible);
}
