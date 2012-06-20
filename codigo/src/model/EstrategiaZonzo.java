package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EstrategiaZonzo extends Estrategia {

	public EstrategiaZonzo() {
		super();
		rangoVisionInicial = ContextConfiguration.VISION_N1;
	}

	@Override
	void mover(Estado estado) {
		Eslabon eslabonPacman = localizarPacman(estado.getFantasma());
		if (eslabonPacman != null){
			if (estado instanceof Cazador){
				/// Desicion de movimiento hacia el pacman
			}
			else if (estado instanceof Presa) {
				/// Desicion de movimiento alejandome del pacman
			}
		}
		else{
			//moverse Random
		}
	}


	private Eslabon localizarPacman(Fantasma fantasma) {
		List<Eslabon> eslabones = getEslabonesEnRango(0,0,fantasma.getEslabon(),null);
		Eslabon eslabonPacman = null;
		for (Iterator<Eslabon> iterator = eslabones.iterator(); iterator.hasNext();) {
			Eslabon eslabon = (Eslabon) iterator.next();
			for (Iterator<Comible> iterator2 = eslabon.getComibles().iterator(); iterator2.hasNext();) {
				Comible comible = (Comible) iterator2.next();
				if (comible instanceof Pacman) {
					eslabonPacman = comible.getEslabon();
				}
				
			} 
		}
		return eslabonPacman;
	}

	private List<Eslabon> getEslabonesEnRango(int distanciaEnX, int distanciaEnY, Eslabon eslabonActual, Direccion direccionEntrada){
		List<Eslabon> eslabones = new ArrayList<Eslabon>();
		if (eslabonActual != null){
			if (distanciaEnX < rangoVisionInicial && direccionEntrada != Direccion.DERECHA){
				eslabones.addAll(getEslabonesEnRango(distanciaEnX +1 , distanciaEnY, eslabonActual.getEslabonDerecho(), Direccion.DERECHA));
			}
			if (distanciaEnX > -rangoVisionInicial && direccionEntrada != Direccion.IZQUIERDA){
				eslabones.addAll(getEslabonesEnRango(distanciaEnX -1 , distanciaEnY, eslabonActual.getEslabonIzquierdo(), Direccion.IZQUIERDA));
			}
			if (distanciaEnY < rangoVisionInicial && direccionEntrada != Direccion.ARRIBA){
				eslabones.addAll(getEslabonesEnRango(distanciaEnX, distanciaEnY +1, eslabonActual.getEslabonArriba(), Direccion.ARRIBA));
			}
			if (distanciaEnY > -rangoVisionInicial && direccionEntrada != Direccion.ABAJO){
				eslabones.addAll(getEslabonesEnRango(distanciaEnX, distanciaEnY -1, eslabonActual.getEslabonAbajo(), Direccion.ABAJO));
			}
			eslabones.add(eslabonActual);
		}
		return eslabones;
	}

}
