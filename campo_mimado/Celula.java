package campo_mimado;

public class Celula {
	private boolean mina, escondidinho, vazio, bandeira, numeros;

	public boolean isNumeros() {
		return numeros;
	}

	public void setNumeros(boolean numeros) {
		this.numeros = numeros;
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public boolean isEscondidinho() {
		return escondidinho;
	}

	public void setEscondidinho(boolean escondidinho) {
		this.escondidinho = escondidinho;
	}

	public boolean isVazio() {
		return vazio;
	}

	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}

	public boolean isBandeira() {
		return bandeira;
	}

	public void setBandeira(boolean bandeira) {
		this.bandeira = bandeira;
	}
}
