package model;

public abstract class Punto implements Comible {
	protected Eslabon eslabon;
	protected Laberinto laberinto;
	
	protected Punto(Eslabon eslabon, Laberinto laberinto){
		this.eslabon= eslabon;
		eslabon.addComible(this);
		this.laberinto= laberinto;
	}
}	

