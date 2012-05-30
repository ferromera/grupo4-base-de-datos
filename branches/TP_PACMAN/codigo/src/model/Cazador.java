package model;

public class Cazador extends Estado {
	private int nivelDeAgresividad;

	public Cazador(Fantasma fantasma) {
		super(fantasma);
		System.out.println("Fantasma Cazador");
	}

	@Override
	public void pasaronSegundos(int segundos) {
		// Aumentar grado de agresividad con el paso del tiempo.
		if(this.nivelDeAgresividad < ContextConfiguration.MAXIMO_NIVEL_AGRESIVIDAD)
			this.nivelDeAgresividad++;
	}

	@Override
	public void esComido() {
		System.out.println("No me podes comer, soy cazador");
	}

	@Override
	public void mover() {
		System.out.println("Soy cazador y me muevo con nivel de agresividad "
				+ this.nivelDeAgresividad);
	}

	@Override
	public String toString() {
		return "Fantasma cazador con agresividad " + this.nivelDeAgresividad;
	}
}