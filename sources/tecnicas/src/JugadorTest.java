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
		jugador = new Jugador(rey);
	}
	public void testCreation(){

		assertEquals(jugador.getRey(), rey);
	}
	public void testMover(){
		
	}
}
