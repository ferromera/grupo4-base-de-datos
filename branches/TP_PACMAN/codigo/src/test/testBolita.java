package test;

import java.util.HashMap;
import java.util.Map;

import model.Bolita;
import model.Eslabon;
import model.Laberinto;
import junit.framework.TestCase;

public class testBolita  extends TestCase{

	private Laberinto laberinto;
	private Eslabon eslabon;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		eslabon = new Eslabon(3, 3);
		Eslabon posicionInicialPacman = new Eslabon(1, 2);
		Eslabon posicionSalidaFantasmas = new Eslabon(5, 5);
		Map<Integer, Eslabon> eslabones = new HashMap<Integer, Eslabon>();
		laberinto = new Laberinto(10, 10 , posicionInicialPacman , posicionSalidaFantasmas, eslabones );
	}

	public void testCrearBolita(){
		
		Bolita bolita = new Bolita(eslabon, laberinto);
		assertEquals(bolita.getEslabon(), eslabon);
		assertEquals(eslabon.getComibles().indexOf(bolita), 0);// TODO esto no me gusta del todo
	}
}
