package model;

public class Presa extends Estado {
	public Presa(Fantasma fantasma) {
		super(fantasma);
		System.out.println("Fantasma Presa");
	}

	@Override
	public void pasaronSegundos(int segundos) {
		this.segundosTranscurridos += segundos;

		if (this.segundosTranscurridos >= ContextConfiguration.PERIODO_DE_PRESA) {
			this.fantasma.setEstado(new Cazador(this.fantasma));
		}
	}

	@Override
	public void esComido() {
		System.out.println("Soy presa y me comiste");
		this.fantasma.setEstado(new Muerto(this.fantasma));
	}

	@Override
	public void mover() {
		System.out.println("Soy presa y me escapo");
	}
	
	@Override
	public String toString() {
		return "Fantasma Presa";
	}

}
