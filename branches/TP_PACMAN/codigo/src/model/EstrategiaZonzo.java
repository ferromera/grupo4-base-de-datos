package model;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaZonzo extends Estrategia {

	public EstrategiaZonzo() {
		super();
		rangoVisionInicial = ContextConfiguration.VISION_N1;
	}

	@Override
	void mover(Estado estado) {
		if (estado instanceof Cazador){
			Eslabon eslabonPacman = localizarPacman(estado.getFantasma());
		}
		else if (estado instanceof Presa) {

		}

	}

	private Eslabon localizarPacman(Fantasma fantasma) {
		List<Eslabon> eslabones = getEslabonesDerechaArriba(rangoVisionInicial, rangoVisionInicial,fantasma.getEslabon());
		eslabones.addAll(getEslabonesDerechaAbajo(rangoVisionInicial, rangoVisionInicial,fantasma.getEslabon()));
		//eslabones

		return null;
	}

	private List<Eslabon> getEslabonesDerechaArriba(int restanteDerecha, int restanteArriba, Eslabon eslabonActual){
		List<Eslabon> eslabones = new ArrayList<Eslabon>();
		if (eslabonActual != null){
			if (restanteDerecha > 0 )
				eslabones.addAll(getEslabonesDerechaArriba(restanteDerecha - 1, restanteArriba, eslabonActual.getEslabonDerecho()));
			if (restanteArriba > 0 )
				eslabones.addAll(getEslabonesDerechaArriba(restanteDerecha, restanteArriba - 1, eslabonActual.getEslabonArriba()));
			eslabones.add(eslabonActual);
		}
		return eslabones;
	}
	
	private List<Eslabon> getEslabonesDerechaAbajo(int restanteDerecha, int restanteAbajo, Eslabon eslabonActual){
		List<Eslabon> eslabones = new ArrayList<Eslabon>();
		if (eslabonActual != null){
			if (restanteDerecha > 0 )
				eslabones.addAll(getEslabonesDerechaArriba(restanteDerecha - 1, restanteAbajo, eslabonActual.getEslabonDerecho()));
			if (restanteAbajo > 0 )
				eslabones.addAll(getEslabonesDerechaArriba(restanteDerecha, restanteAbajo - 1, eslabonActual.getEslabonAbajo()));
			eslabones.add(eslabonActual);
		}
		return eslabones;
	}
	
	

	@Override
	void moverPresa(Estado estado) {
		// TODO Auto-generated method stub

	}

	@Override
	void moverCazador(Estado estado) {
		// TODO Auto-generated method stub

	}


}
