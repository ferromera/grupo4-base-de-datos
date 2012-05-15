import junit.framework.TestCase;


public class TableroTest extends TestCase{
	public void testCraeacion(){
		Tablero tablero = new Tablero();
		Casillero casilleroTablero = tablero.getCasillero(1,2);
		Casillero casillero = new Casillero(1,2);
		assertTrue(casillero.getFila() == casilleroTablero.getFila());
	}

}
