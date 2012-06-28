package model;

public abstract class Estrategia {
	protected int rangoVisionInicial;
	protected PacmanProvider pacmanProvider;

	protected Estrategia(PacmanProvider pacmanProvider, int rangoVisionInicial){
		this.pacmanProvider = pacmanProvider;
		this.rangoVisionInicial = rangoVisionInicial;
	}
	
	abstract void mover(Estado estado);
	
	protected boolean pacmanEnRango(Eslabon eslabonPacman, Eslabon eslabonFantasma) {
		int filaPacman = eslabonPacman.getFila();
		int columnaPacman = eslabonPacman.getColumna();
		int filaFantasma = eslabonFantasma.getFila();
		int columnaFantasma = eslabonFantasma.getColumna();

		if (filaPacman == filaFantasma) {
			return Math.abs(columnaPacman - columnaFantasma) <= rangoVisionInicial;
		} else {
			int deltaMaximoColumna = Math.abs(rangoVisionInicial - Math.abs(filaFantasma - filaPacman));
			return Math.abs(columnaFantasma - columnaPacman) <= deltaMaximoColumna;
		}
	}
	
	protected Direccion direccionOpuesta(Direccion direccion){
		switch (direccion){
			case ARRIBA:
				return Direccion.ABAJO;
			case ABAJO:
				return Direccion.ARRIBA;
			case DERECHA:
				return Direccion.IZQUIERDA;
			case IZQUIERDA:
				return Direccion.DERECHA;
		}
		return null;
	}

	// Averiguo la direccion calculando la direccion del vector PosFantasma - PosPacman
	protected Direccion direccionHaciaElPacman(Eslabon eslabonPacman, Eslabon eslabonFantasma) {
		int direccionX = eslabonFantasma.getFila() - eslabonPacman.getFila();
		int direccionY = eslabonFantasma.getColumna() - eslabonPacman.getColumna();

		//esta en los cuadrantes I y II 
		if (direccionX < 0) {
				return Direccion.ABAJO;
		} else if (direccionX > 0) {
				return Direccion.ARRIBA;
		}else{
			if (direccionY > 0)
				return Direccion.IZQUIERDA;
			else
				return Direccion.DERECHA;
		}
	}

}
