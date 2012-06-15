package model;

public class Eslabon {
	private Eslabon eslabonArriba;
	private Eslabon eslabonAbajo;
	private Eslabon eslabonDerecha;
	private Eslabon eslabonIzquierdo;
	private Punto comida;
	private Fantasma fantasma;
	
	public Comible getComida(){
		return this.comida;
	}
	
	public Comible getFantasma(){
		return this.fantasma;
	}
}
