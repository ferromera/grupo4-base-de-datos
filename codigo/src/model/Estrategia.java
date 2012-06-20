package model;

public abstract class Estrategia {
	protected int rangoVisionInicial;

	abstract void mover(Estado estado);
	
	abstract void moverPresa(Estado estado);
	
	abstract void moverCazador(Estado estado);
	
}
