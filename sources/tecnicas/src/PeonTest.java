import junit.framework.TestCase;


public class PeonTest extends TestCase {
	private Casillero casillero;
	int fila = 6;
	int columna = 4;
	public void setUp(){
		casillero = new Casillero(fila, columna);
	}
	
	
	public void testCreacion(){
		Peon peon = new Peon(casillero);
		assertEquals(peon.getCasillero(), casillero);
		assertTrue(peon.nuncaMovido());
	}
	
	public void testAmenaza(){
		Peon peon = new Peon(casillero);
		Casillero casillero1 = new Casillero(fila,columna);
		Casillero casillero2 = new Casillero(fila+1,columna);
		Casillero casillero3 = new Casillero(fila+1,columna+1);
		Casillero casillero4 = new Casillero(fila+3,columna+2);
		assertFalse(peon.amenazaA(casillero1));
		assertFalse(peon.amenazaA(casillero2));
		assertTrue(peon.amenazaA(casillero3));
		assertFalse(peon.amenazaA(casillero4));
	}
	
}
