import java.util.List;


public class Jugador {
	Rey rey;
	List<Pieza> piezas;
	Jugador (Rey rey, List<Pieza> piezas){
		this.rey=rey;
		this.piezas=piezas;
	}
	public Rey getRey() {
		return rey;
	}
	public List<Pieza> getPiezas() {
		
		return piezas;
	}
}
