import junit.framework.TestCase;


public class jaqueMateTest extends TestCase {

	private Tablero tablero;
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	
	public void setUp(){
		tablero = new Tablero();
	}
	
	public void testNoHayJaqueMate(){
		Rey reyBlanco = new Rey (tablero.getCasillero(3,3));
		jugadorBlancas = new Jugador(reyBlanco);
		
		Rey reyNegro = new Rey (tablero.getCasillero(8,8));
		Reina reinaNegra = new Reina(tablero.getCasillero(3,2));
		jugadorNegras.addPiezas(reinaNegra);

		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaque());
		assertFalse(tablero.hayJaqueMate());
	}
	
	
	public void testHayJaqueMate(){
		
		Rey reyBlanco = new Rey (tablero.getCasillero(1,1));
		jugadorBlancas = new Jugador(reyBlanco);
		
		Rey reyNegro = new Rey (tablero.getCasillero(8,8));
		Reina reinaNegra = new Reina(tablero.getCasillero(1,8));
		Reina reinaNegra2 = new Reina(tablero.getCasillero(2,8));
		
		jugadorNegras.addPiezas(reinaNegra);
		jugadorNegras.addPiezas(reinaNegra2);
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaqueMate());

	}
	
	
}
