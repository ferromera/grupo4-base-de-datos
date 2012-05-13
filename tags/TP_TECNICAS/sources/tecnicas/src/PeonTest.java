import junit.framework.TestCase;


public class PeonTest extends TestCase {

	public void testCreacion(){
		Casillero casillero = new Casillero(1, 2);
		Peon peon = new Peon(casillero);
		assertEquals(peon.getCasillero(), casillero);
		assertTrue(peon.nuncaMovido());
	}
}
