import java.util.List;


public class Jugador {
	Rey rey;
	List<Pieza> piezas;
	Jugador (Rey rey){
		this.rey=rey;
	}
	public Rey getRey() {
		return rey;
	}
	public List<Pieza> getPiezas() {
		
		return piezas;
	}
	public  void addPiezas(Pieza pieza) {
		
		piezas.add(pieza);
	}
}
