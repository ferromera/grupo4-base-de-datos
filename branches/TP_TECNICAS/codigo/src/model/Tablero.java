package model;

import java.util.List;

public class Tablero {
	private List<Casillero> casillero;
	
	public enum Fila {
		UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO
	}
	
	public enum Columna {
		A, B, C, D, E, F, G, H
	}
	
	public enum Color {
		BLANCO,
		NEGRO
	}
	
	public Tablero(){
		
	}

	public Casillero getCasillero(Fila uno, Columna d) {
		return null;
	}

	public boolean hayJaque() {
		return false;
	}

	public boolean hayJaqueMate() {
		return false;
	}
}
