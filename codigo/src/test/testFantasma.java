package test;

import junit.framework.TestCase;
import model.Cazador;
import model.ContextConfiguration;
import model.Fantasma;
import model.Muerto;
import model.Presa;

public class testFantasma extends TestCase{
	private ContextConfiguration ctx;
	private Fantasma fantasma;
	
	@Override
	protected void setUp(){
		ctx = new ContextConfiguration();
		fantasma = new Fantasma();
	}
	
	public void testCrearFantasma(){
		assertTrue(fantasma.getEstado() instanceof Cazador);
		Cazador cazador = (Cazador)fantasma.getEstado();
		assertTrue(cazador.getNivelDeAgresividad() == 0); 
	}
	
	public void testNoPudeComerFantasmaPorqueEsCazador() {
		fantasma.esComido();
		assertTrue(fantasma.getEstado() instanceof Cazador);
	}
	
	public void testNoPudeComerFantasmaPorqueEstaMuerto() {
		fantasma.iniciaPowerPellet();
		fantasma.esComido();
		assertTrue(fantasma.getEstado() instanceof Muerto);
		fantasma.esComido();
		assertTrue(fantasma.getEstado() instanceof Muerto);
	}
	
	public void testPudeComerFantasma() {
		fantasma.iniciaPowerPellet();
		fantasma.esComido();
		assertTrue(fantasma.getEstado() instanceof Muerto);
	}
	
	public void testConvertirEnPresaOKPorCazador(){
		fantasma.iniciaPowerPellet();
		assertTrue(fantasma.getEstado() instanceof Presa);
	}
	
	public void testConvertirEnPresaInvalidoPorMuerto(){
		fantasma.iniciaPowerPellet();
		fantasma.esComido();
		fantasma.iniciaPowerPellet();
		assertFalse(fantasma.getEstado() instanceof Presa);
	}
	
	public void testIncrementarAgresividad(){
		Cazador cazador = (Cazador) fantasma.getEstado();
		int nivelDeAgresividad = cazador.getNivelDeAgresividad();
		fantasma.pasaronSegundos(2);
		assertTrue(nivelDeAgresividad < cazador.getNivelDeAgresividad());
	}
	public void testIncrementarAgresividadSuperiorALaMaxima(){
		fantasma.pasaronSegundos(ContextConfiguration.MAXIMO_NIVEL_AGRESIVIDAD+1);
		Cazador cazador = (Cazador) fantasma.getEstado();
		int nivelDeAgresividad = cazador.getNivelDeAgresividad();
		assertTrue(nivelDeAgresividad == ContextConfiguration.MAXIMO_NIVEL_AGRESIVIDAD);
	}
	
	public void testDePresaACazadorOKPorTiempoCumplido() {
		fantasma.iniciaPowerPellet();
		fantasma.pasaronSegundos(ContextConfiguration.PERIODO_DE_PRESA);
		assertTrue(fantasma.getEstado() instanceof Cazador);
	}
	public void testDeMuertoACazadorOKPorTiempoCumplido(){
		fantasma.iniciaPowerPellet();
		fantasma.esComido();
		fantasma.pasaronSegundos(ContextConfiguration.PERIODO_DE_MUERTO);
		assertTrue(fantasma.getEstado() instanceof Cazador);
		assertTrue(((Cazador)fantasma.getEstado()).getNivelDeAgresividad()==0);
	}
	public void testDePresaACazadorNOPorTiempoCumplido() {
		fantasma.iniciaPowerPellet();
		fantasma.pasaronSegundos(ContextConfiguration.PERIODO_DE_PRESA-1);
		assertFalse(fantasma.getEstado() instanceof Cazador);
	}
	public void testDeMuertoACazadorNOPorTiempoCumplido(){
		fantasma.iniciaPowerPellet();
		fantasma.esComido();
		fantasma.pasaronSegundos(ContextConfiguration.PERIODO_DE_MUERTO-1);
		assertFalse(fantasma.getEstado() instanceof Cazador);
	}

}
