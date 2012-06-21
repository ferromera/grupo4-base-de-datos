package model;

import java.util.Random;

public class EstrategiaZonzo extends Estrategia {

	public EstrategiaZonzo(PacmanProvider pacmanProvider) {
		super(pacmanProvider);
		rangoVisionInicial = ContextConfiguration.VISION_N1;
	}

	@Override
	void mover(Estado estado) {
		Eslabon eslabonPacman = pacmanProvider.getEslabonDePacman();
		Eslabon eslabonFantasma = estado.getFantasma().getEslabon();
		
		if (pacmanEnRango(eslabonPacman, eslabonFantasma)) {
			if (estado instanceof Cazador) {
				estado.mover(direccionHaciaElPacman(eslabonPacman, eslabonFantasma));
			} else if (estado instanceof Presa) {
				estado.mover(direccionOpuesta(direccionHaciaElPacman(eslabonPacman, eslabonFantasma)));
			}
		} else {
			estado.mover(Direccion.values()[new Random().nextInt(4) + 1]);
		}
	}

	private boolean pacmanEnRango(Eslabon eslabonPacman, Eslabon eslabonFantasma) {
		int filaPacman = eslabonPacman.getFila();
		int columnaPacman = eslabonPacman.getColumna();
		int filaFantasma = eslabonFantasma.getFila();
		int columnaFantasma = eslabonFantasma.getColumna();

		if (filaPacman == filaFantasma) {
			return Math.abs(columnaPacman - columnaFantasma) <= rangoVisionInicial;
		} else {
			int deltaMaximoColumna = Math.abs(rangoVisionInicial
					- Math.abs(filaFantasma - filaPacman));
			return Math.abs(columnaFantasma - columnaPacman) <= deltaMaximoColumna;
		}
	}
	
	private Direccion direccionOpuesta(Direccion direccion){
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
	private Direccion direccionHaciaElPacman(Eslabon eslabonPacman, Eslabon eslabonFantasma) {
		int direccionX = eslabonFantasma.getFila() - eslabonPacman.getFila();
		int direccionY = eslabonFantasma.getColumna() - eslabonPacman.getColumna();

		//SIN CONSIDERAR LAS PAREDES 
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
		
		//INCLUYE ALGO DE LOGICA PARA EVITAR PAREDES 
//		//esta en los cuadrantes I y II 
//		if (direccionX < 0) {
//			// si no es una pared
//			if (eslabonFantasma.getEslabonAbajo() != null)
//				return Direccion.ABAJO;
//			else if (direccionY > 0)
//				return Direccion.DERECHA;
//			else
//				return Direccion.IZQUIERDA;
//		} else if (direccionX > 0) {
//			if (eslabonFantasma.getEslabonArriba() != null)
//				return Direccion.ARRIBA;
//			else if (direccionY > 0)
//				return Direccion.DERECHA;
//			else
//				return Direccion.IZQUIERDA;
//		}else{
//			if (direccionY > 0)
//				return Direccion.IZQUIERDA;
//			else
//				return Direccion.DERECHA;
//		}
	}
}
