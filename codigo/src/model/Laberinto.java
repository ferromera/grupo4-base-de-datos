package model;

import java.util.List;

public class Laberinto {
	private int ancho;
	private int alto;
    private Eslabon posicionInicialPacman;
    private Eslabon posicionSalidaFantasmas;
	private List<Eslabon> eslabones;
	private List<Fantasma> fantasmas;
    private Pacman pacman;

	public void iniciaPowerPellet(){
		for (Fantasma f : fantasmas) {
			f.iniciaPowerPellet();
		}
	}
	
	public Eslabon getEslabonDePacman(){
		return this.pacman.getEslabon();
	}
}
