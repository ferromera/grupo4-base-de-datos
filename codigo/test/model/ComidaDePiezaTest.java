package model;

import junit.framework.TestCase;

import org.junit.Test;

public class ComidaDePiezaTest extends TestCase{
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Tablero tablero;
	private Partida partida;
	private Pieza torreJugadorBlancas;
	private Pieza peonNegro;
	private Casillero casilleroPeonNegro;
	
	public void setUp(){
		tablero = new Tablero();
		
		jugadorBlancas = new Jugador(new Pieza(new MovimientoRey(), tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.D)));
		jugadorNegras = new Jugador(new Pieza(new MovimientoRey(), tablero.getCasillero(Tablero.Fila.OCHO, Tablero.Columna.D)));
				
		
		torreJugadorBlancas = new Pieza(new MovimientoTorre(), tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.H));
		
		peonNegro = new Pieza(new MovimientoPeon(), tablero.getCasillero(Tablero.Fila.SIETE, Tablero.Columna.A));
		casilleroPeonNegro = peonNegro.getCasillero();
		
		jugadorBlancas.addPieza(torreJugadorBlancas);
		jugadorNegras.addPieza(peonNegro);
		
		//Se inicia la partida
		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
	}
	
	public void testTorreBlancaSeComeAPeonNegroPositivo(){
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());

		//Verificamos que realmente podamos comer al peon negro con la torre
		assertTrue(torreJugadorBlancas.amenazasA(casilleroPeonNegro));
		
		jugadorBlancas.comer(tablero.getCasillero(Tablero.Fila.SIETE, Tablero.Columna.A));
		//tambien podria ser valido 
		//jugadorBlancas.comer(Tablero.Fila.SIETE, Tablero.Columna.A);

		
		//Verificar que la torre se ubica en la posicion donde estaba el peon negro.
		assertEquals(torreJugadorBlancas.getCasillero(), casilleroPeonNegro);
		
		//Verificar que jugadorNegras no tiene mas ese peon
		Pieza peonComido = jugadorNegras.getPieza(Tablero.Fila.SIETE, Tablero.Columna.A);
		assertNull(peonComido);
	}
	
	@Test(expected = MovimientoInvalidoException.class)
	public void testReyBlancoSeComePeonNegativoPorMovimientoInvalido(){
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());

		//Verificamos que NO podemos comer al peon negro con el rey blanco
		assertFalse(jugadorBlancas.getRey().amenazasA(casilleroPeonNegro));
		
		jugadorBlancas.comer(tablero.getCasillero(Tablero.Fila.SIETE, Tablero.Columna.A));
		
		//Verificar que el rey no se movio.
		assertTrue(jugadorBlancas.getRey().nuncaMovida());
		
		//Verificar que jugadorNegras aun tiene a su peon.
		Pieza peonNoComido = jugadorNegras.getPieza(Tablero.Fila.SIETE, Tablero.Columna.A);
		assertNotNull(peonNoComido);
	}
}
