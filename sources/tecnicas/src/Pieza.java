
public abstract class Pieza {
	protected boolean nuncaMovido;
	protected Casillero casillero;
	Pieza (Casillero casillero){
		this.inicializarPiezaCon(casillero);
		casillero.setPieza(this);
	}
	protected void inicializarPiezaCon(Casillero casillero){
		this.casillero=casillero;
		nuncaMovido = true;
		
	}
	public Casillero getCasillero(){
		return casillero;}
	protected Pieza(){}
	public boolean nuncaMovido(){
		return nuncaMovido;
	}
	public abstract boolean amenazaA(Casillero casillero);
}
