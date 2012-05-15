import junit.framework.TestCase;

public class CoronacionTest extends TestCase{
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Tablero tablero;
	private Partida partida;
	private Peon peonJugadorBlancas;
	private Casillero casilleroDeCoronacion;

	
	public void setUp(){
		tablero = new Tablero();
		
		jugadorBlancas = new Jugador(new Rey(tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.D)));
		jugadorNegras = new Jugador(new Rey(tablero.getCasillero(Tablero.Fila.OCHO, Tablero.Columna.D)));
		
		//Un casillero antes de poder coronar		
		casilleroDeCoronacion = tablero.getCasillero(Tablero.Fila.OCHO, Tablero.Columna.G);
		
		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
	}
	
	public void testEnroqueCortoPositivo(){
		peonJugadorBlancas = new Peon(tablero.getCasillero(Tablero.Fila.SIETE, Tablero.Columna.G));
		jugadorBlancas.addPieza(peonJugadorBlancas);
		
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());
		
		//El jugador que tiene las piezas negras solo conserva al rey. Como 
		//la pieza llega a la ultima fila se corona
		jugadorBlancas.moverPieza(peonJugadorBlancas, casilleroDeCoronacion);

		//Como no hubo una exception durante el casteo el peon se cambio adecuadamente por una reina.
		//El casteo se hace unicamente en este test para probar que efectivamente cambio el tipo de pieza. 
		Reina piezaCoronada = (Reina)jugadorBlancas.getPieza(Tablero.Fila.OCHO, Tablero.Columna.G);
		
		assertNotNull(piezaCoronada);
		assertEquals(piezaCoronada.getCasillero(), casilleroDeCoronacion);
	}
	
	public void testCoronacionNegativaPorTodaviaNoEraLaUltimaFila(){
		peonJugadorBlancas = new Peon(tablero.getCasillero(Tablero.Fila.SEIS, Tablero.Columna.G));
		Casillero casilleroPeonDestino = tablero.getCasillero(Tablero.Fila.SIETE, Tablero.Columna.G);
		
		jugadorBlancas.addPieza(peonJugadorBlancas);
		
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());
		
		//El jugador que tiene las piezas negras solo conserva al rey. Como 
		//la pieza NO llega a la ultima fila y por lo tanto no ocurre la coronacion
		jugadorBlancas.moverPieza(peonJugadorBlancas, casilleroPeonDestino);
		
		assertEquals(peonJugadorBlancas.getCasillero(), casilleroPeonDestino);	
	}
}

