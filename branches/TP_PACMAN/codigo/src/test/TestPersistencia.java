package test;

import junit.framework.TestCase;
import commons.StoreObjectToXml;

import model.Eslabon;
import model.Estrategia;
import model.EstrategiaZonzo;
import model.Fantasma;
import model.PacmanProvider;

public class TestPersistencia extends TestCase {
	
	public void testWriteFantasma() {
		Estrategia estrategia = new EstrategiaZonzo(new PacmanProvider() {
			@Override
			public Eslabon getEslabonDePacman() {
				return null;
			}
		});
		
		Eslabon eslabonFantasma = new Eslabon(1, 1, 1);
		Fantasma fantasma = new Fantasma(eslabonFantasma, estrategia);
		String fileName = "PersonajesTick1.xml";
		
		StoreObjectToXml storeObjectToXml = new StoreObjectToXml(fileName);
		storeObjectToXml.writeToXml(fantasma);
		storeObjectToXml.persistFile();

	}

}
