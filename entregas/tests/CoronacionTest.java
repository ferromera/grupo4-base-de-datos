import junit.framework.TestCase;

public class CoronacionTest extends TestCase{
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Tablero tablero;
	private Partida partida;
	private Peon peonJugadorBlancas;

	
	public void setUp(){
		tablero = new Tablero();
		
		jugadorBlancas = new Jugador(new Rey(tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.D)));
		jugadorNegras = new Jugador(new Rey(tablero.getCasillero(Tablero.Fila.OCHO, Tablero.Columna.D)));
		
		//Un casillero antes de poder coronar
		peonJugadorBlancas = new Peon(tablero.getCasillero(Tablero.Fila.DOS, Tablero.Columna.G));
				
		jugadorBlancas.addPieza(peonJugadorBlancas);
		
		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
	}
	
	public void testEnroqueCortoPositivo(){
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());
		
		//El jugador que tiene las piezas negras solo conserva al rey.
	}
	

}

