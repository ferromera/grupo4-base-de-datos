package model;

import java.util.Random;

public class EstrategiaZonzo extends Estrategia {

	public EstrategiaZonzo(PacmanProvider pacmanProvider) {
		super(pacmanProvider, ContextConfiguration.VISION_N1);
	}

	@Override
	void mover(Estado estado) {
		Eslabon eslabonPacman = pacmanProvider.getEslabonDePacman();
		Eslabon eslabonFantasma = estado.getFantasma().getEslabon();
		
		if (pacmanEnRango(eslabonPacman, eslabonFantasma)) {
			moverHaciaPosicionDePacman(estado, eslabonFantasma, eslabonPacman);
		} else {
			moverseRandom(eslabonFantasma, estado);
			
			/*
			Eslabon proximoEslabon = null;
			Direccion direccion = null;
			while(proximoEslabon == null) {   
				direccion = Direccion.values()[new Random().nextInt(4) + 1];
				proximoEslabon  =  eslabonFantasma.getEslabonEnDireccion(direccion);
				}
			estado.mover(direccion);*/
		}
	}
	
}
