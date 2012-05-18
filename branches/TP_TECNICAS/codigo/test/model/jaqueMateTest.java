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
		Pieza reyBlanco = new Pieza(new MovimientoRey(),tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
		jugadorBlancas = new Jugador(reyBlanco);

		Pieza reyNegro = new Pieza (new MovimientoRey(),tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		Pieza reinaNegra = new Pieza(new MovimientoReina(),tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
		jugadorNegras.addPieza(reinaNegra);

		//Se inicia la partida
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaque());
		assertFalse(tablero.hayJaqueMate());
	}
	
	
	public void testHayJaqueMate(){
		
		Pieza reyBlanco = new Pieza (new MovimientoRey(),tablero.getCasillero(Tablero.Fila.UNO,Tablero.Columna.A));
		jugadorBlancas = new Jugador(reyBlanco);
		
		Pieza reyNegro = new Pieza (new MovimientoRey(),tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		Pieza reinaNegra = new Pieza(new MovimientoReina(),tablero.getCasillero(Tablero.Fila.UNO,Tablero.Columna.H));
		Pieza reinaNegra2 = new Pieza(new MovimientoReina(),tablero.getCasillero(Tablero.Fila.DOS,Tablero.Columna.H));
		
		jugadorNegras.addPieza(reinaNegra);
		jugadorNegras.addPieza(reinaNegra2);
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaqueMate());
	}
}
