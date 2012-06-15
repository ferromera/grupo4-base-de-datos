package consola;

import java.util.Scanner;

import model.ContextConfiguration;
import model.Direccion;
import model.Eslabon;
import model.Fantasma;
import model.Pacman;
import model.Partida;
import model.Presa;

public class Consola {
	private Fantasma fantasma;
	private Partida partida;
	private Pacman pacman;
	
	public Consola(){
		pacman = new Pacman(new Eslabon(1,1));
		partida = new Partida(new ContextConfiguration());
	}
	
	public static void main(String[] args) {
		Consola c = new Consola();
		c.menu();
	}

	public void menu() {
		Scanner input = new Scanner(System.in);
		int op;
		
		System.out.println("*********************************************************");
		System.out.println("Trabajo practico grupal N¡ 2: Pacman");
		System.out.println("*********************************************************");
		
		System.out.println("1.- Iniciar Fantasma");
		System.out.println("2.- Comer el fantasma");
		System.out.println("3.- Convertir en presa el fantasma");
		System.out.println("4.- Mover el fantasma");
		System.out.println("5.- Mostrar el fantasma");
		System.out.println("6.- Salir");
		
		do{
			
			System.out.print("Opcion: ");
			op = input.nextInt();	
			
			System.out.println("");
			System.out.println("*********************************************************");

			switch (op) {
				case 1:
					this.iniciarFantasma();
					break;
				case 2:
					this.comerFantasma();
					break;
				case 3:
					this.convertirEnPresa();
					break;
				case 4:
					this.moverFantasma();
					break;
				case 5:
					this.MostrarFantasma();
					break;
				default:
					break;
			}
			
			System.out.println("*********************************************************");
			System.out.println("");

		}while(op != 6);
	}

	private void moverFantasma() {
		if (fantasmaIniciado())
			this.fantasma.mover(Direccion.DERECHA);
	}

	private void iniciarFantasma() {
		this.fantasma = new Fantasma(new Eslabon(1,1));
		this.partida.addFantasma(fantasma);
		this.partida.arrancarPartida();
	}

	private void comerFantasma() {
		if (fantasmaIniciado())
			this.fantasma.esComidoPor(pacman);
	}

	private void convertirEnPresa() {
		if (fantasmaIniciado())
			this.fantasma.setEstado(new Presa(this.fantasma));
	}

	private void MostrarFantasma() {
		if (fantasmaIniciado())
			System.out.println(this.fantasma.toString());
	}

	private boolean fantasmaIniciado() {
		if (this.fantasma == null) {
			System.out.println("Debes iniciar un fantasma primero");
			return false;
		} else
			return true;
	}
}
