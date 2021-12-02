package tabuleiro;
public abstract class Celula {
		private boolean mina, escondidinho, vazio, bandeira, vizinho;
		private int caractere, numero;
		
		public int isNumero() {
			return numero;
		}
		
		public void setNumero(int numero) {
			this.numero = numero;
		}
		
		public int porValor() {
			if(this.bandeira == true)
				this.caractere = 7;
			else {
					if(this.escondidinho == true)
						this.caractere = 0;
				else {
					if(this.mina == true)
						this.caractere = 9;
					if(this.vizinho == true) 
						this.caractere = isNumero();
					if(this.vazio == true)
						this.caractere = 8;
				}
			}
			return this.caractere;
		}
		
		public boolean isVizinho() {
			return vizinho;
		}

		public void setVizinho(boolean vizinho) {
			this.vizinho = vizinho;
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

