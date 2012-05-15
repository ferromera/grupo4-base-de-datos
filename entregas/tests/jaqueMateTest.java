import junit.framework.TestCase;


public class jaqueMateTest extends TestCase {

	private Tablero tablero;
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	
	public void setUp(){
		tablero = new Tablero();
	}
	
	public void testNoHayJaqueMate(){
		//3,3
		Rey reyBlanco = new Rey (tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
		jugadorBlancas = new Jugador(reyBlanco);
		//8,8
		Rey reyNegro = new Rey (tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		Reina reinaNegra = new Reina(tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
		jugadorNegras.addPieza(reinaNegra);

		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaque());
		assertFalse(tablero.hayJaqueMate());
	}
	
	
	public void testHayJaqueMate(){
		
		Rey reyBlanco = new Rey (tablero.getCasillero(Tablero.Fila.UNO,Tablero.Columna.A));
		jugadorBlancas = new Jugador(reyBlanco);
		
		Rey reyNegro = new Rey (tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		Reina reinaNegra = new Reina(tablero.getCasillero(Tablero.Fila.UNO,Tablero.Columna.H));
		Reina reinaNegra2 = new Reina(tablero.getCasillero(Tablero.Fila.DOS,Tablero.Columna.H));
		
		jugadorNegras.addPieza(reinaNegra);
		jugadorNegras.addPieza(reinaNegra2);
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaqueMate());

	}
	
	
}
