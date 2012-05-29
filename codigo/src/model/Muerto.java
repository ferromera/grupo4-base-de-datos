package model;

public class Muerto extends Estado {	
	private static final int TIEMPO_MUERTO = 10;

	public Muerto(Fantasma fantasma) {
		super(fantasma);
		System.out.println("Fantasma Muerto");
	}
	
	@Override
	public void pasaronSegundos(int segundos) {
		this.segundosTranscurridos += segundos;
		
		if(this.segundosTranscurridos >= TIEMPO_MUERTO){
			this.fantasma.setEstado(new Cazador(this.fantasma));
		}
	}

	@Override
	public void esComido() {
		System.out.println("No me podes comer, estoy muerto");		
	}

	@Override
	public void mover() {
		System.out.println("Estoy muerto, no me puedo mover");				
	}

}
