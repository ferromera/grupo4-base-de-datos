package model;

import java.util.Random;

public class EstrategiaPerezoso extends Estrategia {

	public EstrategiaPerezoso(PacmanProvider pacmanProvider) {
		super(pacmanProvider, ContextConfiguration.VISION_N2);
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
}
