package model;

import java.util.List;

public class Partida {
	private List<Fantasma> fantasmas;
	
	public Partida() {
		this.fantasmas.add(new Fantasma());
		this.fantasmas.add(new Fantasma());
		this.fantasmas.add(new Fantasma());
		this.fantasmas.add(new Fantasma());
	}
}
