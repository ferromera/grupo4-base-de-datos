package model;


public class Pieza {
	private MovimientoPieza movimientoPiezaStrategy;
	private Casillero casillero;
	
	public Pieza(MovimientoPieza movimientoPiezaStrategy, Casillero casillero){
		this.movimientoPiezaStrategy = movimientoPiezaStrategy;
		this.casillero = casillero;
	}
	
	public boolean nuncaMovida(){
		return true;
	}

	public Casillero getCasillero(){
		return casillero;
	}

	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}

	public MovimientoPieza getMovimientoPiezaStrategy() {
		return movimientoPiezaStrategy;
	}

	public void setMovimientoPiezaStrategy(MovimientoPieza movimientoPiezaStrategy) {
		this.movimientoPiezaStrategy = movimientoPiezaStrategy;
	}

	public boolean amenazasA(Casillero casilleroPeonNegro) {
		return false;
	}

}
