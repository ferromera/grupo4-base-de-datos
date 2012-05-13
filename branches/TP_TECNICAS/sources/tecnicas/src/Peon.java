
public class Peon extends Pieza{
	
	public Peon(Casillero casillero){
		this.inicializarPiezaCon(casillero);
	}

	public boolean amenazaA(Casillero casillero1) {
		boolean retorno = false;
		if ((this.casillero.getFila() == casillero1.getFila()-1)&&
			((this.casillero.getColumna() == casillero1.getColumna()-1)||(this.casillero.getFila() == casillero1.getFila()+1))){
			retorno = true;
		}
		return retorno;
	}
}
