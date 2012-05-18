package model;

public class MovimientoTorre implements MovimientoPieza {
	private Casillero posicionEnrroqueRey;
	private Casillero posicionEnrroqueTorre;
	
	@Override
	public void moverA(Casillero casillero) {
		
	}

	public Casillero getPosicionEnrroqueRey() {
		return posicionEnrroqueRey;
	}

	public void setPosicionEnrroqueRey(Casillero posicionEnrroqueRey) {
		this.posicionEnrroqueRey = posicionEnrroqueRey;
	}

	public Casillero getPosicionEnrroqueTorre() {
		return posicionEnrroqueTorre;
	}

	public void setPosicionEnrroqueTorre(Casillero posicionEnrroqueTorre) {
		this.posicionEnrroqueTorre = posicionEnrroqueTorre;
	}
}
