package model;

import java.util.Random;

public class EstrategiaBuscadorTemperamental  extends Estrategia{
	Eslabon ultimoEslabonPacman;
	protected int rangoVisionInicial;
	
	public EstrategiaBuscadorTemperamental(PacmanProvider pacmanProvider){
		super(pacmanProvider, ContextConfiguration.VISION_N4);
		rangoVisionInicial = rangoVision;
		ultimoEslabonPacman = null;
	}
	
	@Override
	void mover(Estado estado) {
		if (estado instanceof Cazador){
			rangoVision = rangoVisionInicial + ((Cazador) estado).getNivelDeAgresividad();
		}
		else{
			rangoVision = rangoVisionInicial;
		}
		
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
