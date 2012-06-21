package consola;

import java.util.Scanner;

import model.ContextConfiguration;
import model.Fantasma;
import model.Pacman;
import model.Partida;

public class Consola {
	private Fantasma fantasma;
	private Partida partida;
	private Pacman pacman;
	
	public Consola(){
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
		System.out.println("Trabajo practico grupal N¡ 3: Pacman");
		System.out.println("*********************************************************");
		
		System.out.println("1.- Iniciar Partida");
		System.out.println("2.- Salir");
		
		do{
			
			System.out.print("Opcion: ");
			op = input.nextInt();	
			
			System.out.println("");
			System.out.println("*********************************************************");

		}while(op != 2);
	}


}
