package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Laberinto {	
	private final int ancho;
	private final int alto;
    private final Eslabon posicionInicialPacman;
    private final Eslabon posicionSalidaFantasmas;
    private final Map<Integer, Eslabon> eslabones;
	private List<Fantasma> fantasmas;
    private Pacman pacman;
        
    public Laberinto(final int ancho,final int alto, 
    					final Eslabon posicionInicialPacman, final Eslabon posicionSalidaFantasmas,
    					final Map<Integer, Eslabon> eslabones){
    	this.ancho = ancho;
    	this.alto = alto;
    	this.posicionInicialPacman = posicionInicialPacman;
    	this.posicionSalidaFantasmas = posicionSalidaFantasmas;
    	this.eslabones = eslabones;
    	
    	this.fantasmas = new ArrayList<Fantasma>();
    	
		this.fantasmas.add(new Fantasma(this.posicionSalidaFantasmas));
		this.fantasmas.add(new Fantasma(this.posicionSalidaFantasmas));
		this.fantasmas.add(new Fantasma(this.posicionSalidaFantasmas));
		this.fantasmas.add(new Fantasma(this.posicionSalidaFantasmas));
		
		this.pacman = new Pacman(this.posicionInicialPacman);
    }
    
	public void iniciaPowerPellet(){
		for (Fantasma f : fantasmas) {
			f.iniciaPowerPellet();
		}
	}
	
	public Eslabon getEslabonDePacman(){
		return this.pacman.getEslabon();	
	}
	public Pacman getPacman(){
		return pacman;
	}
	
}
