
public class Rey extends Pieza{

		Rey (Casillero casillero){
			this.inicializarPiezaCon(casillero);
		}
		public boolean amenazaA(Casillero casillero){
			return false;
		}
}
