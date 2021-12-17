package Tabuleiro;

import Tabuleiro.Celula;

public class CelulaMaluca extends Celula {
private int numero;
private boolean bomba;
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public boolean isBomba() {
	return bomba;
}
public void setBomba(boolean bomba) {
	this.bomba = bomba;
}

}