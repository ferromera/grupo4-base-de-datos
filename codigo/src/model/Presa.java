package model;

public class Presa extends Estado {
	private static final int TIEMPO_PRESA = 20;

	public Presa(Fantasma fantasma) {
		super(fantasma);
		System.out.println("Fantasma Presa");
	}

	@Override
	public void pasaronSegundos(int segundos) {
		this.segundosTranscurridos += segundos;

		if (this.segundosTranscurridos >= TIEMPO_PRESA) {
			this.fantasma.setEstado(new Cazador(this.fantasma));
		}
	}

	@Override
	public void esComido() {
		System.out.println("Soy presa y me comiste");
	}

	@Override
	public void mover() {
		System.out.println("Soy presa y me escapo");
	}

}
