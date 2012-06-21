package model;

public abstract class Estrategia {
	protected int rangoVisionInicial;
	protected PacmanProvider pacmanProvider;

	protected Estrategia(PacmanProvider pacmanProvider){
		this.pacmanProvider = pacmanProvider;
	}
	
	abstract void mover(Estado estado);

}
