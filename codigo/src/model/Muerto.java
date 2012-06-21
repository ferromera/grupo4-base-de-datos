package model;

public class Muerto extends Estado {	
	public Muerto(Fantasma fantasma, Estrategia estrategia) {
		super(fantasma, estrategia);			
		System.out.println("Fantasma Muerto");
	}
	
	@Override
	public void pasaronSegundos(int segundos) {
		this.segundosTranscurridos += segundos;
		
		if(this.segundosTranscurridos >= ContextConfiguration.PERIODO_DE_MUERTO){
			this.fantasma.setEstado(new Cazador(this.fantasma, estrategia));
		}
	}

	@Override
	public void esComidoPor(Movible movible) {
		System.out.println("No me podes comer, estoy muerto");		
	}

	@Override
	public void mover(Direccion direccion) {
		System.out.println("Estoy muerto, no me puedo mover");				
	}

	@Override
	public String toString() {
		return "Fantasma Muerto";
	}

	@Override
	public void iniciaPowerPellet() {
		System.out.println("Estoy Muerto, no me importa");
	}
}
