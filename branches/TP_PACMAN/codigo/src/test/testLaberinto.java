package test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import model.Eslabon;
import model.Laberinto;
import parsers.LaberintoParser;

public class testLaberinto extends TestCase {
	private Laberinto laberinto;
	
	@Override
	public void setUp(){
		laberinto = LaberintoParser.build("laberinto.xml");		
	}
	
	public void testCrearLaberinto() {
		Eslabon posicionInicialPacman = new Eslabon(1, 2,12);
		Eslabon posicionSalidaFantasmas = new Eslabon(4, 4,44);
		Map<Integer, Eslabon> eslabones = new HashMap<Integer, Eslabon>();
		laberinto = Laberinto.valueOf(10, 10, posicionInicialPacman , posicionSalidaFantasmas , eslabones );
		assertEquals(laberinto.getEslabonDePacman(),  posicionInicialPacman);
		assertEquals(laberinto.getPacman().getEslabon(), posicionInicialPacman);
	}
	
	public void testGetInstance(){
		assertNotNull(Laberinto.getInstance());
		assertEquals(Laberinto.getInstance().getEslabonDePacman(), laberinto.getEslabonDePacman());
	}
	
}
