package model;

public interface Movible extends Comible {
	void mover();

	void comerPunto(Punto punto);

	void comerFantasma(Fantasma fantasma);

	void comerPacman(Pacman pacman);
	
	//esto me obliga a implemetar metodos que no hacen nada
}
