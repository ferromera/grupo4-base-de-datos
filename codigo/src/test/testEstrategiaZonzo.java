package test;

import junit.framework.TestCase;
import model.Bolita;
import model.ContextConfiguration;
import model.Eslabon;
import model.Estado;
import model.EstrategiaZonzo;
import model.Fantasma;
import model.Pacman;
import model.PacmanProvider;

public class testEstrategiaZonzo extends TestCase {
	private ContextConfiguration ctx = new ContextConfiguration();
	private EstrategiaZonzo zonzo;
	private Estado estado;
	private Fantasma fantasma;
	private Eslabon eslabonFantasma;
	private Eslabon eslabonPacman;
	private Eslabon eslabones[][] = new Eslabon[10][10];
	private Pacman pacman;
	
	/*
	 *  
	 *  2     *
	 *  3   * * *
	 *  4 * * * F *
	 *  5 * * P * *
	 *  6 * * * * *
	 *  7   * * * 
	 *  8     *
	 *    3|4(5)6|7
	 *    
	 *  Posicion pacman (19,17)
	 */
	@Override
	public void setUp() {
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++){
				eslabones[i][j] = new Eslabon(i, j);
			}
		
		for(int i=2; i<=8; i++)
			for(int j=3; j<=7; j++)
			{	
				eslabones[i][j].setEslabonAbajo(eslabones[i+1][j]);
				eslabones[i][j].setEslabonArriba(eslabones[i-1][j]);
				eslabones[i][j].setEslabonDerecho(eslabones[i][j+1]);
				eslabones[i][j].setEslabonIzquierdo(eslabones[i][j-1]);
			}
		
		eslabonFantasma = eslabones[4][6];
		eslabonPacman = eslabones[5][5];
		eslabonPacman.addComible(new Bolita(eslabonPacman, null));
		
		zonzo = new EstrategiaZonzo(new PacmanProvider() {
			@Override
			public Eslabon getEslabonDePacman() {
				return eslabonPacman;
			}
		});
		
		fantasma = new Fantasma(eslabonFantasma, zonzo);
		pacman = new Pacman(eslabonPacman);
	}
	
	public void testPerseguirPacmanPorQueEstaEnRango(){
		fantasma.mover();
		assertTrue(fantasma.getEslabon().getFila() == 5);
		assertTrue(fantasma.getEslabon().getColumna() == 6);
		
		fantasma.mover();
		assertTrue(fantasma.getEslabon().getFila() == 5);
		assertTrue(fantasma.getEslabon().getColumna() == 5);
		
		
	}
}
