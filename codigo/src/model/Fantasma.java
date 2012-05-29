package model;

public class Fantasma {
	private Estado estado;
	
	public Fantasma (){
		this.estado = new Cazador(this);
	}
	
	public void esComido(){
		this.estado.esComido();
	}
	
	public void mover(){
		this.estado.mover();
	}
	
	public void pasaronSegundos(int segundos){
		this.estado.pasaronSegundos(segundos);
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return this.estado.toString();
	}
}
