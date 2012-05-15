import junit.framework.TestCase;


public class JaqueTest extends TestCase {
	private Tablero tablero;
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	
	public void setUp(){
		tablero = new Tablero();
	}
	
	public void testNoHayJaque(){
		Casillero casillero = tablero.getCasillero(Tablero.Fila.DOS,Tablero.Columna.A);
		Rey reyBlanco = new Rey(casillero);
		jugadorBlancas = new Jugador(reyBlanco);
		
		//6,1
		Casillero casillero2 = tablero.getCasillero(Tablero.Fila.SEIS,Tablero.Columna.A);
		Rey reyNegro = new Rey(casillero2);
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertFalse(tablero.hayJaque());
	}
	
	
	public void testHayJaque(){
		Rey reyBlanco = new Rey(tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
		jugadorBlancas = new Jugador(reyBlanco);
		
		Rey reyNegro = new Rey(tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		Reina reinaNegra = new Reina(tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.B));
		jugadorNegras.addPieza(reinaNegra);

		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaque());
	}
	
}
