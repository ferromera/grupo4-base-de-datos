package test;

import java.util.HashMap;
import java.util.Map;

import model.Bolita;
import model.Eslabon;
import model.Estado;
import model.Laberinto;
import junit.framework.TestCase;

public class testBolita  extends TestCase{

	private Laberinto laberinto;
	private Eslabon eslabon;
	private Bolita bolita; 
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		eslabon = new Eslabon(3, 3);
		Eslabon posicionInicialPacman = new Eslabon(1, 2);
		Eslabon posicionSalidaFantasmas = new Eslabon(5, 5);
		Map<Integer, Eslabon> eslabones = new HashMap<Integer, Eslabon>();
		laberinto = Laberinto.valueOf(10, 10 , posicionInicialPacman , posicionSalidaFantasmas, eslabones );
		bolita = new Bolita(eslabon, laberinto);
	}

	public void testCrearBolita(){
		
	
		assertEquals(bolita.getEslabon(), eslabon);
		assertEquals(eslabon.getComibles().indexOf(bolita), 0);
		// TODO esto ultimo no me gusta del todo, me ata a la implementacion, pero como lo testeo sino?
		

	}
	public void testBolitaComidaPorPacman(){
		assertNotNull(bolita.getEslabon());
		int cantidadDeElementos = eslabon.getComibles().size();
		laberinto.getPacman().comerEn(bolita.getEslabon());
		assertNull(bolita.getEslabon());
		assertTrue(cantidadDeElementos -1 == eslabon.getComibles().size());
	}
	
	/*public void testBolitaNoComidaPorFantasma(){
		assertNotNull(bolita.getEslabon());
		int cantidadDeElementos = eslabon.getComibles().size();
		laberinto.getFantasmas().comerEn(bolita.getEslabon());
		assertNotNull(bolita.getEslabon());
		assertTrue(cantidadDeElementos -1 == eslabon.getComibles().size());
	}*/
	
}
