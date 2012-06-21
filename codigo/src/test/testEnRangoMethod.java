package test;

import junit.framework.TestCase;

public class testEnRangoMethod extends TestCase {
	public void testPacmanEnRangoPQEstaEnLaMismaFilaANEslabones(){
		assertTrue(enRango(19,17,19,20,3));
	}
	
	/*
	 *  
	 *  16     *
	 *  17   * * *
	 *  18 * * * * *
	 *  19    (P) 
	 *  20 * * * * *
	 *  21   * * * 
	 *  22     *
	 *    15|16(17)18|19
	 *    
	 *  Posicion pacman (19,17)
	 */
	public void testPacmanEnRangoEnDiferenteFila() {
		//arriba
		assertTrue(enRango(19,17,18,15,3));
		assertTrue(enRango(19,17,18,16,3));
		assertTrue(enRango(19,17,18,17,3));
		assertTrue(enRango(19,17,18,18,3));
		assertTrue(enRango(19,17,18,19,3));
		assertTrue(enRango(19,17,17,18,3));
		assertTrue(enRango(19,17,17,17,3));
		assertTrue(enRango(19,17,17,16,3));
		assertTrue(enRango(19,17,16,17,3));
		
		//abajo
		assertTrue(enRango(19,17,20,15,3));
		assertTrue(enRango(19,17,20,16,3));
		assertTrue(enRango(19,17,20,17,3));
		assertTrue(enRango(19,17,20,18,3));
		assertTrue(enRango(19,17,20,19,3));
		assertTrue(enRango(19,17,21,18,3));
		assertTrue(enRango(19,17,21,17,3));
		assertTrue(enRango(19,17,21,16,3));
		assertTrue(enRango(19,17,22,17,3));
	}
	
	public void testPacmanFueraDeRangoEnDiferenteFila() {
		assertFalse(enRango(19,17,16,18,3));
	}

	public static boolean enRango(int filaPacman,int columnaPacman, int filaFantasma, int columnaFantasma, int rangoVisionInicial) {
		if (filaPacman == filaFantasma) {
			return Math.abs(columnaPacman - columnaFantasma) <= rangoVisionInicial;
		} else {
			int deltaMaximoColumna = Math.abs(rangoVisionInicial - Math.abs(filaFantasma - filaPacman));
			return Math.abs(columnaFantasma - columnaPacman) <= deltaMaximoColumna;
		}
	}
}
