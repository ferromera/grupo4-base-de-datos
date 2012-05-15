import junit.framework.TestCase;

public class TestEnroqueCorto extends TestCase{
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Tablero tablero;
	private Partida partida;
	private Torre torreJugadorBlancas;
	private Rey reyJugadorBlancas;
	
	
	public void setUp(){
		tablero = new Tablero();
		
		jugadorBlancas = new Jugador(new Rey(tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.D)));
		jugadorNegras = new Jugador(new Rey(tablero.getCasillero(Tablero.Fila.OCHO, Tablero.Columna.D)));
		
		torreJugadorBlancas = new Torre(tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.H));
		reyJugadorBlancas = jugadorBlancas.getRey();
		
		jugadorBlancas.addPieza(torreJugadorBlancas);
		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
	}
	
	public void testEnroqueCortoPositivo(){
		Casillero casilleroTorre = torreJugadorBlancas.getCasillero();
			
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());
		
		assertTrue(reyJugadorBlancas.nuncaMovida());
		assertTrue(torreJugadorBlancas.nuncaMovida());
		
		
		//En el enroque corte el rey pasa por los casilleros F1, G1. Se debe verificar que ninguno de esos casilleros 
		//este atacado por otra pieza de un jugador2.
		Casillero casilleroF1 = tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.F);
		Casillero casilleroG1 = tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.G);
		
		assertFalse(jugadorNegras.amenazas(casilleroF1));
		assertFalse(jugadorNegras.amenazas(casilleroG1));
		
		jugadorBlancas.enracarReyCon(torreJugadorBlancas);
		
		//El rey toma el casillero de la torre
		assertEquals(reyJugadorBlancas.getCasillero(), casilleroTorre);
		
		//Verificar que la torre se ubica al costado izquierdo del rey.
		assertEquals(torreJugadorBlancas.getCasillero().getFila(), casilleroTorre.getFila());
		assertEquals(torreJugadorBlancas.getCasillero().getColumna(), casilleroTorre.getColumna());		
	}
	
	public void testEnroqueCortoNegativoPorReyMovido(){
		Casillero casilleroG1 = tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.G); 
		Casillero casilleroRey = tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.E);
		Casillero casilleroTorre = torreJugadorBlancas.getCasillero();

		jugadorBlancas.moverPieza(reyJugadorBlancas,casilleroG1);
		
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());
		
		assertFalse(reyJugadorBlancas.nuncaMovida());
		assertTrue(torreJugadorBlancas.nuncaMovida());
		
		jugadorBlancas.enracarReyCon(torreJugadorBlancas);
		
		//El rey no se mueve porque el enroque no es posible.
		assertEquals(reyJugadorBlancas.getCasillero(), casilleroRey);
		
		//Verificar que la torre no se movio.
		assertEquals(torreJugadorBlancas.getCasillero(), casilleroTorre);		
	}
}
