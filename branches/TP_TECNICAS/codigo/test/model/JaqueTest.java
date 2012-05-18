package model;

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
		Pieza reyBlanco = new Pieza(new MovimientoRey(),casillero);
		jugadorBlancas = new Jugador(reyBlanco);
		
		Casillero casillero2 = tablero.getCasillero(Tablero.Fila.SEIS,Tablero.Columna.A);
		Pieza reyNegro = new Pieza(new MovimientoRey(),casillero2);
		
		//Se inicia la partida
		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertFalse(tablero.hayJaque());
	}
	
	
	public void testHayJaque(){
		Pieza reyBlanco = new Pieza(new MovimientoRey(),tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));

		jugadorBlancas = new Jugador(reyBlanco);
		
		Pieza reyNegro = new Pieza(new MovimientoRey(),tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));

		Pieza reinaNegra = new Pieza(new MovimientoReina(),tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.B));
		jugadorNegras.addPieza(reinaNegra);

		Partida partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaque());
	}
	
}
