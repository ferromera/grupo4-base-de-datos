package model;

public interface Movible {
	void mover(Direccion direccion);

	void comerPunto(Punto punto);

	void comerFantasma(Fantasma fantasma);

	void comerPacman(Pacman pacman);
	
	//esto me obliga a implemetar metodos que no hacen nada
}
