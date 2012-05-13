import junit.framework.TestCase;

public class CasilleroTest extends TestCase {

	
	
	public void testCreacion() {
		Casillero casillero = new Casillero(1, 2);
		assertTrue(casillero.getColumna() == 2);
		assertTrue(casillero.getFila() == 1);
		assertTrue(casillero.getPieza()==null);
	}

}
