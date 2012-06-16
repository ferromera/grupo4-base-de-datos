package model;

import java.util.LinkedList;
import java.util.List;

public class Eslabon {
	
	private Eslabon eslabonArriba;
	private Eslabon eslabonAbajo;
	private Eslabon eslabonDerecho;
	private Eslabon eslabonIzquierdo;
	private List <Comible> comibles; 
	private int fila;
	private int columna;

	
	public Eslabon(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		comibles = new LinkedList<Comible>();
	}
	
	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
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

	
	public Eslabon getEslabonArriba() {
		return eslabonArriba;
	}

	public void setEslabonArriba(Eslabon eslabonArriba) {
		this.eslabonArriba = eslabonArriba;
	}
	public void addComible (Comible comible){
		comibles.add(comible);
	}
	public List<Comible> getComibles(){
		return comibles;
	}

	public void remover(Comible comible) {
		comibles.remove(comible);		
	}
}