import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;


public class JugadorTest extends TestCase{
	private Jugador jugador;
	private Tablero tablero;
	private Rey rey;
	private List<Pieza> piezas;
	
	public void setUp(){
		tablero = new Tablero();
		Casillero casillero = tablero.getCasillero(8, 5);
		rey = new Rey(casillero);
		piezas = new ArrayList<Pieza>();
		jugador = new Jugador(rey, piezas);
		
	}
	public void testCreation(){

		assertEquals(jugador.getRey(), rey);
		assertEquals(jugador.getPiezas(),piezas);
	}
	public void testMover(){
		
	}
}
