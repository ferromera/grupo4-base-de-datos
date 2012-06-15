package model;

import helpers.LoggerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Partida {
	private List<Fantasma> fantasmas;
	private static int delay = 0; // delay for 5 sec.
	private static int period = 1000; // repeat every sec.
	private Timer timer;
	private LoggerHelper logger;

	public Partida(ContextConfiguration ctx) {
		this.fantasmas = new ArrayList<Fantasma>();
		this.logger = new LoggerHelper("partida");
		
		// COMENTADOS PARA PODER CORRER LOS TEST - con un solo fantasma.
		// this.fantasmas.add(new Fantasma());
		// this.fantasmas.add(new Fantasma());
		// this.fantasmas.add(new Fantasma());
		// this.fantasmas.add(new Fantasma());
	}

	public void arrancarPartida() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				notificarFantasmas();
			}
		}, delay, period);
	}

	public void addFantasma(Fantasma fantasma) {
		this.fantasmas.add(fantasma);
	}
	
	public void notificarFantasmas() {
		for (Fantasma f : fantasmas) {
			f.pasaronSegundos(1);
			logger.log("Pasaron "+ period+ " milisegundos.");
		}
	}
}
