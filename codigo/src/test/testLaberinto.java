package test;

import parsers.LaberintoParser;
import junit.framework.TestCase;
import model.Laberinto;

public class testLaberinto extends TestCase {
	private Laberinto laberinto;
	
	public void testLoadFromXml(){
		laberinto = LaberintoParser.build("laberinto.xml");		
	}
	
	
}
