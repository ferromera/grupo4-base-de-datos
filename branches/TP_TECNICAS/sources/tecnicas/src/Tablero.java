import java.util.ArrayList;
import java.util.List;


public class Tablero {
	private List<Casillero> casilleros;
	
	public Tablero(){
		casilleros = new ArrayList<Casillero>();
		for (int i = 1; i < 9;i++){
			for (int j =1 ; j<9;j++){
				Casillero casillero = new Casillero(i,j);
				casilleros.add(casillero);
			}
		}
	}

	public Casillero getCasillero(int fila, int columna) {
		int numeroCasillero = (fila-1)*8+columna;
		return casilleros.get(numeroCasillero);
	}

	public boolean hayJaque() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hayJaqueMate() {
		// TODO Auto-generated method stub
		return false;
	}
}
