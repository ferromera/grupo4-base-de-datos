package test;

import model.Eslabon;
import model.Pacman;
import junit.framework.TestCase;

public class testPacman extends TestCase{
	
	Eslabon eslabon;
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		eslabon = new Eslabon(1,2,12); 
	}
	
	public void testCrearPacman(){
		Pacman pacman = new Pacman(eslabon);
		assertEquals(pacman.getEslabon(), eslabon);
	}
}
