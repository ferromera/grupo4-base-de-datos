package model;

import java.util.Random;

public abstract class Estrategia {
	protected int rangoVision;
	protected PacmanProvider pacmanProvider;

	protected Estrategia(PacmanProvider pacmanProvider, int rangoVisionInicial){
		this.pacmanProvider = pacmanProvider;
		this.rangoVision = rangoVisionInicial;
	}
	
	abstract void mover(Estado estado);
	
	protected boolean pacmanEnRango(Eslabon eslabonPacman, Eslabon eslabonFantasma) {
		int filaPacman = eslabonPacman.getFila();
		int columnaPacman = eslabonPacman.getColumna();
		int filaFantasma = eslabonFantasma.getFila();
		int columnaFantasma = eslabonFantasma.getColumna();

		if (filaPacman == filaFantasma) {
			return Math.abs(columnaPacman - columnaFantasma) <= rangoVision;
		} else {
			int deltaMaximoColumna = Math.abs(rangoVision - Math.abs(filaFantasma - filaPacman));
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

	protected void moverHaciaPosicionDePacman(Estado estado, Eslabon eslabonFantasma, Eslabon eslabonPacman){
		if (estado instanceof Cazador) {
			estado.mover(direccionHaciaElPacman(eslabonPacman, eslabonFantasma));
		} else if (estado instanceof Presa) {
			estado.mover(direccionOpuesta(direccionHaciaElPacman(eslabonPacman, eslabonFantasma)));
		}
	}
	protected void moverseRandom(Eslabon eslabonFantasma, Estado estado){
		Eslabon proximoEslabon = null;
		Direccion direccion = null;
		while(proximoEslabon == null) {   
			direccion = Direccion.values()[new Random().nextInt(4) ];
			proximoEslabon  =  eslabonFantasma.getEslabonEnDireccion(direccion);
			}
		estado.mover(direccion);
	}
	
}
