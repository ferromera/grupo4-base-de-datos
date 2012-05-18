package model;

import junit.framework.TestCase;

public class EnroqueCortoTest extends TestCase{
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Tablero tablero;
	private Partida partida;
	private Pieza torreJugadorBlancas;
	private Pieza reyJugadorBlancas;
	private Casillero casilleroTorreBlanca;
	private Casillero casilleroReyBlanco;
	private Casillero casilleroG1;
	
	public void setUp(){
		tablero = new Tablero();
		
		jugadorBlancas = new Jugador(new Pieza(new MovimientoRey(), tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.D)));

		jugadorNegras = new Jugador(new Pieza(new MovimientoRey(), tablero.getCasillero(Tablero.Fila.OCHO, Tablero.Columna.D)));
		
		torreJugadorBlancas = new Pieza(new MovimientoTorre(),tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.H));
		reyJugadorBlancas = jugadorBlancas.getRey();
		
		casilleroTorreBlanca = torreJugadorBlancas.getCasillero();
		casilleroReyBlanco = reyJugadorBlancas.getCasillero();
		
		jugadorBlancas.addPieza(torreJugadorBlancas);
		
		//Se inicia la partida
		partida = new Partida(jugadorBlancas, jugadorNegras, tablero);
	}
	
	public void testEnroqueCortoPositivo(){
		prepararTurnoParaEnroqueCortoPositivo();
		
		jugadorBlancas.enracarReyCon(torreJugadorBlancas);
		
		//El rey toma el casillero de la torre
		assertEquals(reyJugadorBlancas.getCasillero(), casilleroTorreBlanca);
		
		//Verificar que la torre se ubica al costado izquierdo del rey.
		assertEquals(torreJugadorBlancas.getCasillero().getFila(), casilleroTorreBlanca.getFila());
		assertEquals(torreJugadorBlancas.getCasillero().getColumna(), casilleroTorreBlanca.getColumna());		
	}

	
	public void testEnroqueCortoNegativoPorCaminoDelReyAtacado(){
		prepararTurnoParaEnroqueCortoNegativoPorCaminoDelReyAtacado();
		
		jugadorBlancas.enracarReyCon(torreJugadorBlancas);
		
		//El rey no se mueve porque el enroque no es posible.
		assertEquals(reyJugadorBlancas.getCasillero(), casilleroReyBlanco);
		
		//Verificar que la torre no se movio.
		assertEquals(torreJugadorBlancas.getCasillero(), casilleroTorreBlanca);		
	}

	
	public void testEnroqueCortoNegativoPorReyMovido(){
		prepararTurnoParaEnroqueCortoNegativoPorReyMovido();
		
		jugadorBlancas.enracarReyCon(torreJugadorBlancas);
		
		//El rey no se mueve porque el enroque no es posible.
		assertEquals(reyJugadorBlancas.getCasillero(), casilleroReyBlanco);
		
		//Verificar que la torre no se movio.
		assertEquals(torreJugadorBlancas.getCasillero(), casilleroTorreBlanca);		
	}

	
	public void testEnroqueCortoNegativoPorTorreMovida(){
		prepararTurnoParaEnroqueCortoNegativoPorTorreMovida();
		
		jugadorBlancas.enracarReyCon(torreJugadorBlancas);
		
		//El rey no se mueve porque el enroque no es posible.
		assertEquals(reyJugadorBlancas.getCasillero(), casilleroReyBlanco);
		
		//Verificar que la torre no se movio.
		assertEquals(torreJugadorBlancas.getCasillero(), casilleroTorreBlanca);		
	}

	private void prepararTurnoParaEnroqueCortoNegativoPorTorreMovida() {
		casilleroG1 = tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.G); 

		jugadorBlancas.moverPieza(reyJugadorBlancas,casilleroG1);
		
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());
		
		assertTrue(reyJugadorBlancas.nuncaMovida());
		assertFalse(torreJugadorBlancas.nuncaMovida());
	}
	
	private void prepararTurnoParaEnroqueCortoNegativoPorReyMovido() {
		casilleroG1 = tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.G); 

		jugadorBlancas.moverPieza(reyJugadorBlancas,casilleroG1);
		
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());
		
		assertFalse(reyJugadorBlancas.nuncaMovida());
		assertTrue(torreJugadorBlancas.nuncaMovida());
	}

	private void prepararTurnoParaEnroqueCortoNegativoPorCaminoDelReyAtacado() {
		//Ubicamos un alfil en el casillero A7
		jugadorNegras.addPieza(new Pieza(new MovimientoAlfil(),tablero.getCasillero(Tablero.Fila.SIETE, Tablero.Columna.A)));
		
		//Primero juegan las blancas
		assertEquals(jugadorBlancas,partida.jugadorActivo());
		
		Casillero casilleroG1 = tablero.getCasillero(Tablero.Fila.UNO, Tablero.Columna.G); 
		
		//El alfil negro amenaza un casillero por el que debe pasar el rey
		assertTrue(jugadorNegras.amenazas(casilleroG1));
	}

	private void prepararTurnoParaEnroqueCortoPositivo() {
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
	}
}
