import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;


public class JaqueTest extends TestCase {
	private Tablero tablero;
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	
	public void setUp(){
		tablero = new Tablero();
	}
	
	public void testNoHayJaque(){
		Casillero casillero = tablero.getCasillero(2,1);
		Rey reyBlanco = new Rey (casillero);
		jugadorBlancas = new Jugador(reyBlanco);
		
		Casillero casillero2 = tablero.getCasillero(6,1);
		Rey reyNegro = new Rey (casillero2);
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertFalse(tablero.hayJaque());
	}
	
	
	public void testHayJaque(){
		
		Rey reyBlanco = new Rey (tablero.getCasillero(3,3));
		jugadorBlancas = new Jugador(reyBlanco);
		
		Rey reyNegro = new Rey (tablero.getCasillero(8,8));
		Reina reinaNegra = new Reina(tablero.getCasillero(3,2));
		jugadorNegras.addPiezas(reinaNegra);
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaque());
	}
	
}
