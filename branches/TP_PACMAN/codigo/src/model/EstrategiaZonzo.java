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

		if (pacmanEnRango(estado)) {
			if (estado instanceof Cazador) {
				// / decisi—n de movimiento hacia el pacman
			} else if (estado instanceof Presa) {
				// / decisi—n de movimiento alejandome del pacman
			}
		} else {
			// moverse Random
		}
	}

	private boolean pacmanEnRango(Estado estado) {
		Eslabon eslabonPacman = Laberinto.getInstance().getEslabonDePacman();
		Fantasma fantasma = estado.getFantasma();

		int filaPacman = eslabonPacman.getFila();
		int columnaPacman = eslabonPacman.getColumna();
		int filaFantasma = fantasma.getEslabon().getFila();
		int columnaFantasma = fantasma.getEslabon().getColumna();

		if (filaPacman == filaFantasma) {
			return Math.abs(columnaPacman - columnaFantasma) <= rangoVisionInicial;
		} else {
			int deltaMaximoColumna = Math.abs(rangoVisionInicial - Math.abs(filaFantasma - filaPacman));
			return Math.abs(columnaFantasma - columnaPacman) <= deltaMaximoColumna;
		}
	}

	@Deprecated
	private Eslabon localizarPacman(Fantasma fantasma) {
		List<Eslabon> eslabones = getEslabonesEnRango(0, 0, fantasma.getEslabon(), null);
		Eslabon eslabonPacman = null;
		for (Iterator<Eslabon> iterator = eslabones.iterator(); iterator.hasNext();) {
			Eslabon eslabon = (Eslabon) iterator.next();
			for (Iterator<Comible> iterator2 = eslabon.getComibles().iterator(); iterator2
					.hasNext();) {
				Comible comible = (Comible) iterator2.next();
				if (comible instanceof Pacman) {
					eslabonPacman = comible.getEslabon();
				}

			}
		}
		return eslabonPacman;
	}

	@Deprecated
	private List<Eslabon> getEslabonesEnRango(int distanciaEnX, int distanciaEnY,
			Eslabon eslabonActual, Direccion direccionEntrada) {
		List<Eslabon> eslabones = new ArrayList<Eslabon>();
		if (eslabonActual != null) {
			if (distanciaEnX < rangoVisionInicial && direccionEntrada != Direccion.DERECHA) {
				eslabones.addAll(getEslabonesEnRango(distanciaEnX + 1, distanciaEnY,
						eslabonActual.getEslabonDerecho(), Direccion.DERECHA));
			}
			if (distanciaEnX > -rangoVisionInicial && direccionEntrada != Direccion.IZQUIERDA) {
				eslabones.addAll(getEslabonesEnRango(distanciaEnX - 1, distanciaEnY,
						eslabonActual.getEslabonIzquierdo(), Direccion.IZQUIERDA));
			}
			if (distanciaEnY < rangoVisionInicial && direccionEntrada != Direccion.ARRIBA) {
				eslabones.addAll(getEslabonesEnRango(distanciaEnX, distanciaEnY + 1,
						eslabonActual.getEslabonArriba(), Direccion.ARRIBA));
			}
			if (distanciaEnY > -rangoVisionInicial && direccionEntrada != Direccion.ABAJO) {
				eslabones.addAll(getEslabonesEnRango(distanciaEnX, distanciaEnY - 1,
						eslabonActual.getEslabonAbajo(), Direccion.ABAJO));
			}
			eslabones.add(eslabonActual);
		}
		return eslabones;
	}

}
