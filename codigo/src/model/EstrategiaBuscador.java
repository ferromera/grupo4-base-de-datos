package model;

import java.util.Random;

public class EstrategiaBuscador extends Estrategia {
	Eslabon ultimoEslabonPacman;

	public EstrategiaBuscador(PacmanProvider pacmanProvider){
		super(pacmanProvider, ContextConfiguration.VISION_N3);
		ultimoEslabonPacman = null;
	}

	@Override
	void mover(Estado estado) {
		Eslabon eslabonPacman = pacmanProvider.getEslabonDePacman();
		Eslabon eslabonFantasma = estado.getFantasma().getEslabon();

		if (pacmanEnRango(eslabonPacman, eslabonFantasma)) {
			ultimoEslabonPacman = eslabonPacman;
			moverHaciaPosicionDePacman(estado, eslabonFantasma, eslabonPacman);
		} else {
			if (ultimoEslabonPacman == eslabonFantasma){
				ultimoEslabonPacman = null;
			}
			if (ultimoEslabonPacman != null)
			{
				moverHaciaPosicionDePacman(estado, eslabonFantasma, ultimoEslabonPacman);
			}
			estado.mover(Direccion.values()[new Random().nextInt(4) + 1]);
		}
	}
}
