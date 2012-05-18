package model;

import junit.framework.TestCase;


public class jaqueMateTest extends TestCase {

	private Tablero tablero;
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	
	public void setUp(){
		tablero = new Tablero();
	}
	
	public void testNoHayJaqueMate(){
		MovimientoRey reyBlanco = new MovimientoRey (tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
		jugadorBlancas = new Jugador(reyBlanco);

		MovimientoRey reyNegro = new MovimientoRey (tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		MovimientoPiezaReina reinaNegra = new MovimientoPiezaReina(tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
		jugadorNegras.addPieza(reinaNegra);

		//Se inicia la partida
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaque());
		assertFalse(tablero.hayJaqueMate());
	}
	
	
	public void testHayJaqueMate(){
		
		MovimientoRey reyBlanco = new MovimientoRey (tablero.getCasillero(Tablero.Fila.UNO,Tablero.Columna.A));
		jugadorBlancas = new Jugador(reyBlanco);
		
		MovimientoRey reyNegro = new MovimientoRey (tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		MovimientoPiezaReina reinaNegra = new MovimientoPiezaReina(tablero.getCasillero(Tablero.Fila.UNO,Tablero.Columna.H));
		MovimientoPiezaReina reinaNegra2 = new MovimientoPiezaReina(tablero.getCasillero(Tablero.Fila.DOS,Tablero.Columna.H));
		
		jugadorNegras.addPieza(reinaNegra);
		jugadorNegras.addPieza(reinaNegra2);
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaqueMate());
	}
}
