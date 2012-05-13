
public class Casillero {

	private int fila;
	private int columna;
	private Pieza pieza;
	public Casillero(int i, int j) {
		this.fila=i;
		this.columna=j;
		pieza =null;
	}
	public int getFila() {
		return fila;
	}
	public int getColumna() {
		return columna;
	}
	public Pieza getPieza(){
		return pieza;
	}
	public void setPieza(Pieza pieza) {
		this.pieza=pieza;
	}

	
}
