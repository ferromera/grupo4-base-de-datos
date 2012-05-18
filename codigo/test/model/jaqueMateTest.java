package model;

import junit.framework.TestCase;


public class jaqueMateTest extends TestCase {

	private Tablero tablero;
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Pieza reyBlanco;
	private Pieza reyNegro;
	private Partida partida;
	private Pieza reinaNegra;
	private Pieza reinaNegra2;
	
	public void setUp(){
		tablero = new Tablero();
	}
	
	public void testNoHayJaqueMate(){
		prepararTurnoParaNoHayJaqueMate();
		
		jugadorNegras.addPieza(reinaNegra);
		//Se inicia la partida
		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		
		assertTrue(tablero.hayJaque());
		assertFalse(tablero.hayJaqueMate());
	}
	
	public void testHayJaqueMate(){		
		prepararTurnoParaHayJaque();
		
		jugadorNegras.addPieza(reinaNegra);
		jugadorNegras.addPieza(reinaNegra2);
		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		
		assertTrue(tablero.hayJaqueMate());
	}

	private void prepararTurnoParaHayJaque() {
		reyBlanco = new Pieza (new MovimientoRey(),tablero.getCasillero(Tablero.Fila.UNO,Tablero.Columna.A));
		jugadorBlancas = new Jugador(reyBlanco);
		
		reyNegro = new Pieza (new MovimientoRey(),tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		reinaNegra = new Pieza(new MovimientoReina(),tablero.getCasillero(Tablero.Fila.UNO,Tablero.Columna.H));
		reinaNegra2 = new Pieza(new MovimientoReina(),tablero.getCasillero(Tablero.Fila.DOS,Tablero.Columna.H));
	}
	
	private void prepararTurnoParaNoHayJaqueMate() {
		reyBlanco = new Pieza(new MovimientoRey(),tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
		jugadorBlancas = new Jugador(reyBlanco);

		reyNegro = new Pieza (new MovimientoRey(),tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));
		reinaNegra = new Pieza(new MovimientoReina(),tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));
	}
}
