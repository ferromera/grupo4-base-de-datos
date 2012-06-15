package model;

public class Eslabon {
	private Eslabon eslabonArriba;

	private Eslabon eslabonAbajo;
	private Eslabon eslabonDerecho;
	private Eslabon eslabonIzquierdo;
	private Punto comida;
	private Fantasma fantasma;
	private int fila;
	private int columna;

	
	public Eslabon(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;	
	}
	
	public Eslabon(int fila, int columna, Punto punto) {
		this(fila,columna);
		this.comida = punto;
	}
	
	public Comible getComida() {
		return this.comida;
	}

	public Comible getFantasma() {
		return this.fantasma;
	}

	private int getFila() {
		return this.fila;
	}

	private int getColumna() {
		return this.columna;
	}

	public Eslabon getEslabonAbajo() {
		return eslabonAbajo;
	}
	
	public void setEslabonAbajo(Eslabon eslabonAbajo) {
		this.eslabonAbajo = eslabonAbajo;
	}
	
	public Eslabon getEslabonDerecho() {
		return eslabonDerecho;
	}
	
	public void setEslabonDerecho(Eslabon eslabonDerecho) {
		this.eslabonDerecho = eslabonDerecho;
	}
	
	public Eslabon getEslabonIzquierdo() {
		return eslabonIzquierdo;
	}
	
	public void setEslabonIzquierdo(Eslabon eslabonIzquierdo) {
		this.eslabonIzquierdo = eslabonIzquierdo;
	}
	
	public void setComida(Punto comida) {
		this.comida = comida;
	}
	
	public void setFantasma(Fantasma fantasma) {
		this.fantasma = fantasma;
	}
	
	public Eslabon getEslabonArriba() {
		return eslabonArriba;
	}

	public void setEslabonArriba(Eslabon eslabonArriba) {
		this.eslabonArriba = eslabonArriba;
	}
}
