package model;

public class Presa extends Estado {
	private Cazador estadoAnterior;
	public Presa(Fantasma fantasma, Estrategia estrategia) {
		super(fantasma, estrategia);
		this.estadoAnterior= (Cazador)fantasma.getEstado();
		System.out.println("Fantasma Presa");
	}

	@Override
	public void pasaronSegundos(int segundos) {
		this.segundosTranscurridos += segundos;

		if (this.segundosTranscurridos >= ContextConfiguration.PERIODO_DE_PRESA) {
			this.fantasma.setEstado(this.estadoAnterior);
		}
	}

	@Override
	public void esComidoPor(Movible movible) {//esto aca es raro... comido por comible
		System.out.println("Soy presa y me comiste");
		this.fantasma.setEstado(new Muerto(this.fantasma, estrategia));
	}

	@Override
	public void mover(Direccion direccion) {
		System.out.println("Soy presa y me escapo");
	}
	
	@Override
	public String toString() {
		return "Fantasma Presa";
	}

	@Override
	public void iniciaPowerPellet() {
		this.segundosTranscurridos=0;
	}

}
