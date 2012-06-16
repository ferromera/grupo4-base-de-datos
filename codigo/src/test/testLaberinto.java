package test;

import java.util.HashMap;
import java.util.Map;

import parsers.LaberintoParser;
import junit.framework.TestCase;
import model.Eslabon;
import model.Laberinto;

public class testLaberinto extends TestCase {
	private Laberinto laberinto;
	
	public void testLoadFromXml(){
		laberinto = LaberintoParser.build("laberinto.xml");		
	}
	public void testCrearLaberinto() {
		Eslabon posicionInicialPacman = new Eslabon(1, 2);
		Eslabon posicionSalidaFantasmas = new Eslabon(4, 4);
		Map<Integer, Eslabon> eslabones = new HashMap<Integer, Eslabon>();
		laberinto = new Laberinto(10, 10, posicionInicialPacman , posicionSalidaFantasmas , eslabones );
		assertEquals(laberinto.getEslabonDePacman(),  posicionInicialPacman);
	}
	
	
}
