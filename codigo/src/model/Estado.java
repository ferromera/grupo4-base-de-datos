package model;

public abstract class Estado {
	protected Fantasma fantasma;
	protected int segundosTranscurridos; 
	protected Estrategia estrategia;
	
	protected Estado(Fantasma fantasma, Estrategia estrategia){
		this.segundosTranscurridos = 0;
		this.fantasma = fantasma;
		this.estrategia = estrategia;
	}
	abstract public void iniciaPowerPellet();
	abstract public void esComidoPor(Movible movible);
	abstract public void pasaronSegundos(int segundos);
	abstract public void mover(Direccion direccion);
	public Fantasma getFantasma(){return this.fantasma;}
	public void mover(){
		estrategia.mover(this);
	}

}
