package tabuleiro;
import java.io.Serializable;
public abstract class Celula implements Serializable {
	private boolean  escondidinho,  bandeira;

	public boolean isEscondidinho() {
		return escondidinho;
	}

	public void setEscondidinho(boolean escondidinho) {
		this.escondidinho = escondidinho;
	}

	public boolean isBandeira() {
		return bandeira;
	}

	public void setBandeira(boolean bandeira) {
		this.bandeira = bandeira;
	}
	
}