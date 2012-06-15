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
		if(this.nivelDeAgresividad+segundos < ContextConfiguration.MAXIMO_NIVEL_AGRESIVIDAD)
			this.nivelDeAgresividad+=segundos;
		else
			this.nivelDeAgresividad=ContextConfiguration.MAXIMO_NIVEL_AGRESIVIDAD;
	}

	@Override
	public void esComidoPor(Comible comible) {
		System.out.println("No me podes comer, soy cazador");
		comible.esComidoPor(this.fantasma);
	}

	@Override
	public void mover(Direccion direccion) {
		System.out.println("Soy cazador y me muevo con nivel de agresividad "
				+ this.nivelDeAgresividad);
	}

	@Override
	public String toString() {
		return "Fantasma cazador con agresividad " + this.nivelDeAgresividad;
	}

	public int getNivelDeAgresividad() {
		return this.nivelDeAgresividad;
	}

	@Override
	public void iniciaPowerPellet() {
		this.fantasma.setEstado(new Presa(this.fantasma));
	}
}
