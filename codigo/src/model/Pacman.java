package model;

import java.util.Iterator;
import java.util.List;


public class Pacman implements Comible, Movible {
	private Eslabon eslabon;

	public Pacman(Eslabon eslabon){
		this.eslabon = eslabon;
	}
	
	@Override
	public void mover(Direccion direccion) {
		Eslabon proximoEslabon;
		switch (direccion) {
		case ARRIBA:
			proximoEslabon = eslabon.getEslabonArriba();
			break;
		case ABAJO:
			proximoEslabon = eslabon.getEslabonAbajo();
			break;
		case DERECHA:
			proximoEslabon = eslabon.getEslabonDerecho();
			break;
		case IZQUIERDA:
			proximoEslabon = eslabon.getEslabonIzquierdo();
			break;
		}
		this.comerEn(eslabon);
		
	}

	private void comerEn(Eslabon eslabon2) {
		if (eslabon2!=null){
			
			List<Comible> comibles =  this.eslabon.getComibles();
			Iterator<Comible> iterator = comibles.iterator();
			while (iterator.hasNext()){
				iterator.next().esComidoPor(this);
			}
		}
	}



	@Override
	public Eslabon getEslabon() {
		return this.eslabon;
	}

	@Override
	public void esComidoPor(Movible movible) {
		// TODO Auto-generated method stub
		
	}

}
