package model;

public abstract class Estado {
	protected Fantasma fantasma;
	protected int segundosTranscurridos; 
	
	protected Estado(Fantasma fantasma){
		this.segundosTranscurridos = 0;
		this.fantasma = fantasma;
	}
	abstract public void iniciaPowerPellet();
	abstract public void esComido();
	abstract public void pasaronSegundos(int segundos);
	abstract public void mover();

}
