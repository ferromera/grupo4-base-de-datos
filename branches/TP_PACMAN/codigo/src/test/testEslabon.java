package test;

import model.Bolita;
import model.Comible;
import model.Eslabon;
import model.Punto;
import junit.framework.TestCase;

public class testEslabon  extends TestCase{

	private Eslabon eslabon;
	private Eslabon eslabon2;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		eslabon = new Eslabon(2, 2);
		eslabon2 = new Eslabon(1,2);
		
	}
	
	public void testCrearEslabon(){
		int fila = 1;
		int columna = 2;
		eslabon = new Eslabon(fila , columna );
		assertTrue(fila == eslabon.getFila());
		assertTrue(columna == eslabon.getColumna());
		assertTrue(eslabon.getComibles().size()==0);
		assertTrue(eslabon.getEslabonAbajo() == null);
		assertTrue(eslabon.getEslabonArriba() == null);
		assertTrue(eslabon.getEslabonDerecho() == null);
		assertTrue(eslabon.getEslabonIzquierdo() == null);
	}
	public void testAgregarEslabonDerecho(){
		eslabon.setEslabonDerecho(eslabon2);
		assertTrue(eslabon.getEslabonDerecho()== eslabon2);
		assertFalse(eslabon.getEslabonIzquierdo()== eslabon2);
		assertFalse(eslabon.getEslabonAbajo()== eslabon2);
		assertFalse(eslabon.getEslabonArriba()== eslabon2);
	}
	public void testAgregarEslabonIzquierdo(){
		eslabon.setEslabonIzquierdo(eslabon2);
		assertFalse(eslabon.getEslabonDerecho()== eslabon2);
		assertTrue(eslabon.getEslabonIzquierdo()== eslabon2);
		assertFalse(eslabon.getEslabonAbajo()== eslabon2);
		assertFalse(eslabon.getEslabonArriba()== eslabon2);
	}

	public void testAgregarEslabonAbajo(){
		eslabon.setEslabonAbajo(eslabon2);
		assertFalse(eslabon.getEslabonDerecho()== eslabon2);
		assertFalse(eslabon.getEslabonIzquierdo()== eslabon2);
		assertTrue(eslabon.getEslabonAbajo()== eslabon2);
		assertFalse(eslabon.getEslabonArriba()== eslabon2);
	}
	public void testAgregarEslabonArriba(){
		eslabon.setEslabonArriba(eslabon2);
		assertFalse(eslabon.getEslabonDerecho()== eslabon2);
		assertFalse(eslabon.getEslabonIzquierdo()== eslabon2);
		assertFalse(eslabon.getEslabonAbajo()== eslabon2);
		assertTrue(eslabon.getEslabonArriba()== eslabon2);
	}
	public void testAgregarComible(){
		//Comible comible = new Bolita();
	}

}
