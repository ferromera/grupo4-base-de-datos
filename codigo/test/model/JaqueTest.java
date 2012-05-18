package model;

import junit.framework.TestCase;


public class JaqueTest extends TestCase {
	private Tablero tablero;
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Pieza reyBlanco;
	private Pieza reyNegro;
	private Partida partida;
	private Pieza reinaNegra;
	private Casillero casilleroA2;
	private Casillero casilleroA6;
	
	
	public void setUp(){
		tablero = new Tablero();
	}
	
	public void testNoHayJaque(){
		prepararTurnoParaNoHayJaque();
		
		//Se inicia la partida
		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertFalse(tablero.hayJaque());
	}

	public void testHayJaque(){
		prepararTurnoParaHayJaque();

		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
		assertTrue(tablero.hayJaque());
	}

	private void prepararTurnoParaHayJaque() {
		reyBlanco = new Pieza(new MovimientoRey(),tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.C));

		jugadorBlancas = new Jugador(reyBlanco);
		
		reyNegro = new Pieza(new MovimientoRey(),tablero.getCasillero(Tablero.Fila.OCHO,Tablero.Columna.H));

		reinaNegra = new Pieza(new MovimientoReina(),tablero.getCasillero(Tablero.Fila.TRES,Tablero.Columna.B));
		jugadorNegras.addPieza(reinaNegra);
	}
	
	private void prepararTurnoParaNoHayJaque() {
		casilleroA2 = tablero.getCasillero(Tablero.Fila.DOS,Tablero.Columna.A);
		reyBlanco = new Pieza(new MovimientoRey(),casilleroA2);
		jugadorBlancas = new Jugador(reyBlanco);
		
		casilleroA6 = tablero.getCasillero(Tablero.Fila.SEIS,Tablero.Columna.A);
		reyNegro = new Pieza(new MovimientoRey(),casilleroA6);
		jugadorNegras = new Jugador(reyNegro);
	}
	
}
