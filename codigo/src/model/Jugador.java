package model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	private List<Pieza> piezas;
	private Pieza rey;

	public Jugador(Pieza rey) {
		piezas = new ArrayList<Pieza>();
		piezas.add(rey);
		this.rey = rey;
	}

	public Pieza getPieza(Tablero.Fila uno, Tablero.Columna h) {
		return null;
	}

	public boolean amenazas(Casillero casillero) {
		return false;
	}

	public void enracarReyCon(Pieza torre) {
		
	}

	public void addPieza(Pieza pieza) {
		piezas.add(pieza);
	}

	public void moverPieza(Pieza pieza, Casillero casilleroG1) {		
	}

	public void comer(Casillero casillero) {
	}

	public Pieza getRey() {
		return rey;
	}
}
