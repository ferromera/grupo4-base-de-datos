package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Eslabon {
	
	private Eslabon eslabonArriba;
	private Eslabon eslabonAbajo;
	private Eslabon eslabonDerecho;
	private Eslabon eslabonIzquierdo;
	private List <Comible> comibles; 
	private int fila;
	private int columna;
	private int id;

	
	public Eslabon(int fila, int columna, int id) {
		this.fila = fila;
		this.columna = columna;
		this.id = id;
		comibles = new ArrayList<Comible>();
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
		Iterator<Comible> iterator = comibles.iterator();
		while (iterator.hasNext()){
			if (iterator.next() == comible){
				iterator.remove();
			}
		}
		
		//comibles.remove(comible);*/		
	}
	
	public Eslabon getEslabonEnDireccion(Direccion direccion){
		Eslabon eslabonEnDireccion = null;
		switch (direccion) {
		case ARRIBA:
			eslabonEnDireccion  = eslabonArriba;
			break;
		case ABAJO:
			eslabonEnDireccion  = eslabonAbajo;
			break;
		case IZQUIERDA:
			eslabonEnDireccion  = eslabonIzquierdo;
			break;
		case DERECHA:
			eslabonEnDireccion  = eslabonDerecho;
			break;
			}
		return eslabonEnDireccion;
		
	}

	public void comiblesComidosPor(Pacman pacman) {
		List<Comible> comiblesAComer =  new ArrayList<Comible>(this.getComibles());
		Iterator<Comible> iterator = comiblesAComer.iterator();
		while (iterator.hasNext()){
			iterator.next().esComidoPor(pacman);
		}
	}

	public int getId() {
		
		return id;
	}

	public Element writeToXmlFormat(Document listEslabones) {
		Element elemFantasma = listEslabones.createElement("nodo");
		elemFantasma.setAttribute("id", String.valueOf(id));
		elemFantasma.setAttribute("fila", String.valueOf(fila));
		elemFantasma.setAttribute("columna", String.valueOf(columna));
		elemFantasma.setAttribute("contiene", getAlimentoContenido());
		elemFantasma.setAttribute("izquierda", String.valueOf(this.getEslabonIzquierdo().getId()));
		elemFantasma.setAttribute("derecha", String.valueOf(this.getEslabonDerecho().getId()));
		elemFantasma.setAttribute("arriba", String.valueOf(this.getEslabonArriba().getId()));
		elemFantasma.setAttribute("abajo", String.valueOf(this.getEslabonAbajo().getId()));
		return elemFantasma;
	}

	private String getAlimentoContenido() {
		String contenido =""; 
		for (Comible comible : comibles) {
			if (comible instanceof Bolita){
				contenido = "bolita";
			}
			if (comible instanceof Bolon){
				contenido = "bolon";
			}
		}
		
		return contenido;
	}
}
