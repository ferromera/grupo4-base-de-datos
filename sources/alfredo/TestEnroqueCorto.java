import junit.framework.TestCase;


public class TestEnroqueCorto extends TestCase{
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private Partida partida;
	
	public void setUp(){
		tablero = new Tablero();
		jugador1 = new Jugador(new Rey(tablero.dameCasillero(Tablero.Fila.UNO, Tablero.Columna.D)));
		jugador2 = new Jugador(new Rey(tablero.dameCasillero(Tablero.Fila.OCHO, Tablero.Columna.D)));
		partida = new Partida(jugador1, jugador2);
	}
	
	public void testEnroqueCortoPositivo(){

		Torre torreJugador1 = ((Torre)(jugador1.damePieza(Tablero.Fila.UNO, Tablero.Columna.H)));
		Rey reyJugador1 = jugador1.dameRey();
		
		Casillero casilleroTorre = torreJugador1.dameCasillero();
		
		assertTrue(reyJugador1.nuncaMovida());
		assertTrue(torreJugador1.nuncaMovida());
		
		//En el enroque corte el rey pasa por los casilleros F1, G1. Se debe verificar que ninguno de esos casilleros 
		//este atacado por otra pieza de un jugador2.
		Casillero casilleroF1 = tablero.dameCasillero(Tablero.Fila.UNO, Tablero.Columna.F);
		Casillero casilleroG1 = tablero.dameCasillero(Tablero.Fila.UNO, Tablero.Columna.G);
		
		assertFalse(jugador2.amenazas(casilleroF1));
		assertFalse(jugador2.amenazas(casilleroG1));
		
		jugador1.enracarReyCon(torreJugador1);
		
		assertEquals(reyJugador1.dameCasillero(), casilleroTorre);
		
		//VALIDAR Q CAMBIO BIEN EL CASILLERO DE LA TORRE
		
	}
}
