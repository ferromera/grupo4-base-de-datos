package model;

public class Casillero {
	private Tablero.Fila fila;
	private Tablero.Columna columna;
	
	public Casillero (Tablero.Fila fila, Tablero.Columna columna){
		this.fila = fila;
		this.columna = columna;
	}
	
	public Tablero.Fila getFila() {
		return fila;
	}

	public Tablero.Columna getColumna() {
		return columna;
	}

	public void setFila(Tablero.Fila fila) {
		this.fila = fila;
	}

	public void setColumna(Tablero.Columna columna) {
		this.columna = columna;
	}

}
