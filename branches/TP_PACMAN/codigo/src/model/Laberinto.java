package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import commons.PersistibleXML;

public class Laberinto implements PacmanProvider , PersistibleXML{
	private final int ancho;
	private final int alto;
	private final Eslabon posicionInicialPacman;
	private final Eslabon posicionSalidaFantasmas;
	private final Map<Integer, Eslabon> eslabones;
	private List<Fantasma> fantasmas;
	private Pacman pacman;

	private static Laberinto instance = null;

	public static Laberinto getInstance() {
		return instance;
	}

	public static Laberinto valueOf(final int ancho, final int alto,
			final Eslabon posicionInicialPacman, final Eslabon posicionSalidaFantasmas,
			final Map<Integer, Eslabon> eslabones) {
		instance = new Laberinto(ancho, alto, posicionInicialPacman, posicionSalidaFantasmas, eslabones);
		return instance;
	}

	private Laberinto(final int ancho, final int alto, final Eslabon posicionInicialPacman,
			final Eslabon posicionSalidaFantasmas, final Map<Integer, Eslabon> eslabones) {
		this.ancho = ancho;
		this.alto = alto;
		this.posicionInicialPacman = posicionInicialPacman;
		this.posicionSalidaFantasmas = posicionSalidaFantasmas;
		this.eslabones = eslabones;

		this.fantasmas = new ArrayList<Fantasma>();

		this.fantasmas.add(new Fantasma(this.posicionSalidaFantasmas, new EstrategiaZonzo(this)));
		this.fantasmas.add(new Fantasma(this.posicionSalidaFantasmas, new EstrategiaZonzo(this)));
		this.fantasmas.add(new Fantasma(this.posicionSalidaFantasmas, new EstrategiaZonzo(this)));
		this.fantasmas.add(new Fantasma(this.posicionSalidaFantasmas, new EstrategiaZonzo(this)));

		this.pacman = new Pacman(this.posicionInicialPacman);
		
		referenciarBolitas();

		Laberinto.instance = this;
	}

	private void referenciarBolitas() {
		 Map<Integer, Eslabon> eslabones = this.getEslabones();
	        for (Entry<Integer, Eslabon> entry : eslabones.entrySet()) {
	        	entry.getKey(); 

	        	for (Comible comible : entry.getValue().getComibles()) {
	        		if (comible instanceof Bolon){
	        			((Bolon)comible).setLaberinto(this);
	        		}
				}
	        	;
	        }
		
	}

	public void iniciaPowerPellet() {
		for (Fantasma f : fantasmas) {
			f.iniciaPowerPellet();
		}
	}

	@Override
	public Eslabon getEslabonDePacman() {
		return this.pacman.getEslabon();
	}

	public Pacman getPacman() {
		return pacman;
	}

	public boolean esFinDelJuego() {
		return pacman.estaMuerto();
	}
	public void moverFantasmas(){
		for (Fantasma f : fantasmas) {
			f.mover();
		}
	}
	public List<Fantasma> getFanstamas(){
		return fantasmas;
	}

	@Override
	public Element writeToXmlFormat(Document listFantasmas) {
		// TODO Auto-generated method stub
		return null;
	}

	public  Map<Integer, Eslabon> getEslabones() {
		return eslabones;
	}
	public int getAlto(){
		return this.alto;
	}
	public int getAncho(){
		return this.ancho;
	}
	

}
