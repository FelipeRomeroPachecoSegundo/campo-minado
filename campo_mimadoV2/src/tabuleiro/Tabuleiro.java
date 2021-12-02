package tabuleiro;
import java.util.Random;
import interfaceG.InterfaceGrafica;
public class Tabuleiro extends Celula implements InterfaceGrafica {
		private int largura, comprimento, contagemTotalDeMinas, insanidade;
		private Tabuleiro[][] tabuleiro;
		
		public int dificuldade(char escolha) {
			switch(escolha) {
			case'1':
				this.largura = 9;
				this.comprimento = 9;
				this.contagemTotalDeMinas = 10;
				this.insanidade = 6;
				break;
			case'2':
				this.largura = 16;
				this.comprimento = 16;
				this.contagemTotalDeMinas = 40;
				this.insanidade = 4;
				break;
			case'3':
				this.largura = 16;
				this.comprimento = 30;
				this.contagemTotalDeMinas = 99;
				this.insanidade = 3;
				break;
			default:
				largura = 0;
			}
			return largura;
		}
		public void encurtarAbrirVazios(int a, int b, int c, int d, int linha, int coluna) {
			for(int i = a; i <= c; i++) 
				for(int j = b; j <= d; j++) 
					this.tabuleiro[linha+i][coluna+j].setEscondidinho(false);
		}
		public void abrirVazios() {
			for(int linha = 0; linha < largura; linha++) {
				for(int coluna = 0; coluna < comprimento; coluna++) {
					if(this.tabuleiro[linha][coluna].isEscondidinho() == false && this.tabuleiro[linha][coluna].isVazio() == true) {
						if(coluna == 0  && linha != 0 && linha != largura-1) 
							encurtarAbrirVazios(-1, 0, 1, 1, linha, coluna);
						else if(coluna == comprimento-1  && linha != 0 && linha != largura-1) 
							encurtarAbrirVazios(-1, -1, 1, 0, linha, coluna);
						else if(linha == 0 && coluna != 0 && coluna != comprimento-1) 
							encurtarAbrirVazios(0, -1, 1, 1, linha, coluna);
						else if(linha == largura-1 && coluna != 0 && coluna != comprimento-1) 
							encurtarAbrirVazios(-1, -1, 0, 1, linha, coluna);
						else if(linha > 0 && linha < largura-1 && coluna > 0 && coluna < comprimento-1) 
							encurtarAbrirVazios(-1, -1, 1, 1, linha, coluna);
						else if(linha == 0 && coluna == 0) 
							encurtarAbrirVazios(0, 0, 1, 1, linha, coluna);
						else if(linha == largura-1 && coluna == 0) 
							encurtarAbrirVazios(-1, 0, 0, 1, linha, coluna);
						else if(linha == 0 && coluna == comprimento-1) 
							encurtarAbrirVazios(0, -1, 1, 0, linha, coluna);
						else if(linha == largura-1 && coluna == comprimento-1) 
							encurtarAbrirVazios(-1, -1, 0, 0, linha, coluna);
					}
				}	
			}
		}
		
		public void encurtarPorNumero(int a, int b, int c, int d, int linha, int coluna, int numero) {
			for(int i = a; i <= c; i++) {
				for(int j = b; j <= d; j++) {
					if(this.tabuleiro[linha + i][coluna + j].isMina() == true) {
						numero++;
						this.tabuleiro[linha][coluna].setNumero(numero);}}}
		}
		
		public void porNumero() {
			int numero;
			for(int linha = 0; linha < largura; linha++) {
				for(int coluna = 0; coluna < comprimento; coluna++) {
					numero = 0;
					if(this.tabuleiro[linha][coluna].isVizinho() == true) {
						if(coluna == 0  && linha != 0 && linha != largura-1) 
							encurtarPorNumero(-1, 0, 1, 1, linha, coluna, numero);
						else if(coluna == comprimento-1  && linha != 0 && linha != largura-1) 
							encurtarPorNumero(-1, -1, 1, 0, linha, coluna, numero);
						else if(linha == 0 && coluna != 0 && coluna != comprimento-1) 
							encurtarPorNumero(0, -1, 1, 1, linha, coluna, numero);
						else if(linha == largura-1 && coluna != 0 && coluna != comprimento-1) 
							encurtarPorNumero(-1, -1, 0, 1, linha, coluna, numero);
						else if(linha > 0 && linha < largura-1 && coluna > 0 && coluna < comprimento-1) 
							encurtarPorNumero(-1, -1, 1, 1, linha, coluna, numero);
						else if(linha == 0 && coluna == 0) 
							encurtarPorNumero(0, 0, 1, 1, linha, coluna, numero);
						else if(linha == largura-1 && coluna == 0) 
							encurtarPorNumero(-1, 0, 0, 1, linha, coluna, numero);
						else if(linha == 0 && coluna == comprimento-1) 
							encurtarPorNumero(0, -1, 1, 0, linha, coluna, numero);
						else if(linha == largura-1 && coluna == comprimento-1) 
							encurtarPorNumero(-1, -1, 0, 0, linha, coluna, numero);
					}
				}
			}
		}
		
		public void encurtarPorVizinhos(int a, int b, int c, int d, int linha, int coluna) {
			for(int i = a; i <= c; i++) 
				for(int j = b; j <= d; j++) 
					if(this.tabuleiro[linha][coluna].isMina() != true) 
						if(this.tabuleiro[linha + i][coluna + j].isMina() == true) 
							this.tabuleiro[linha][coluna].setVizinho(true);
		}
		
		public void porVizinho() {
			for(int linha = 0; linha < largura; linha++) {
				for(int coluna = 0; coluna < comprimento; coluna++) {
					if(coluna == 0  && linha != 0 && linha != largura-1) 
						encurtarPorVizinhos(-1, 0, 1, 1, linha, coluna);
					else if(coluna == comprimento-1  && linha != 0 && linha != largura-1) 
						encurtarPorVizinhos(-1, -1, 1, 0, linha, coluna);
					else if(linha == 0 && coluna != 0 && coluna != comprimento-1) 
						encurtarPorVizinhos(0, -1, 1, 1, linha, coluna);
					else if(linha == largura-1 && coluna != 0 && coluna != comprimento-1) 
						encurtarPorVizinhos(-1, -1, 0, 1, linha, coluna);
					else if(linha > 0 && linha < largura-1 && coluna > 0 && coluna < comprimento-1) 
						encurtarPorVizinhos(-1, -1, 1, 1, linha, coluna);
					else if(linha == 0 && coluna == 0) 
						encurtarPorVizinhos(0, 0, 1, 1, linha, coluna);
					else if(linha == largura-1 && coluna == 0) 
						encurtarPorVizinhos(-1, 0, 0, 1, linha, coluna);
					else if(linha == 0 && coluna == comprimento-1) 
						encurtarPorVizinhos(0, -1, 1, 0, linha, coluna);
					else if(linha == largura-1 && coluna == comprimento-1) 
						encurtarPorVizinhos(-1, -1, 0, 0, linha, coluna);
				}
			}
		}
		
		public void porVazio() {
			for(int i = 0; i < largura; i++) {
				for(int l = 0; l < comprimento; l++)
					if(this.tabuleiro[i][l].isMina() != true && this.tabuleiro[i][l].isVizinho() != true)
					this.tabuleiro[i][l].setVazio(true);
			}
		}
		
		public void porFalse() {
			for(int j = 0; j < largura; j++) {
				for(int k = 0; k < comprimento; k++) {
					tabuleiro[j][k].setVazio(false);
					tabuleiro[j][k].setVizinho(false);
				}
			}
		}
		
		public void porBomba() {
			Random aleatorio = new Random();
			int linha, coluna;
			boolean porMina;
			for(int i = 0; i < contagemTotalDeMinas; i++){
					do{
						linha = aleatorio.nextInt(this.largura);
						coluna = aleatorio.nextInt(this.comprimento);
						if(this.tabuleiro[linha][coluna].isMina() != true)
							porMina = true;
						else
							porMina = false;
					} while(porMina == false);
						this.tabuleiro[linha][coluna].setMina(true);
				}
		tabuleiro[0][0].setMina(true);
		tabuleiro[10][10].setMina(true);
		tabuleiro[10][9].setMina(true);
			}
		
		public void esconderCelulas() {
			for(int j = 0; j < largura; j++) {
				for(int k = 0; k < comprimento; k++)
					this.tabuleiro[j][k].setEscondidinho(true);
			}
		}
		
		public void iniciarTabuleiro() {
			this.tabuleiro = new Tabuleiro[largura][comprimento];
			for(int j = 0; j < largura; j++) {
				for(int k = 0; k < comprimento; k++)
					this.tabuleiro[j][k] = new Tabuleiro();
			}
		}
		
		public void montarTabuleiro() {
			porVizinho();
			porNumero();
			porVazio();
		}
		
	public String stringarMatriz(int V, int H, int bandeira, int jogada) {
		String matriz = "\n";
		Random rand = new Random();
		
		int n = 0;
		if(jogada == 1) {
		iniciarTabuleiro();
		esconderCelulas();
		porBomba();
		}
		if(bandeira == 1 && tabuleiro[V][H].isMina() == true && rand.nextInt(this.insanidade) == 1) {
			tabuleiro[V][H].setMina(false);
			porFalse();
			montarTabuleiro();
			}
		else montarTabuleiro();
		do {
			if(bandeira == 2 && this.tabuleiro[V][H].isBandeira() != true) { 
				if(this.tabuleiro[V][H].isMina() == true || this.tabuleiro[V][H].isVizinho() == true)
					this.tabuleiro[V][H].setEscondidinho(false);
				if(this.tabuleiro[V][H].isVazio() == true) {
					this.tabuleiro[V][H].setEscondidinho(false);
					abrirVazios();
				}
			}
			if(bandeira == 1 && this.tabuleiro[V][H].isEscondidinho() == true) { 
				if(this.tabuleiro[V][H].isBandeira() != true) {
					this.tabuleiro[V][H].setBandeira(true);
					break;}
				else {
					this.tabuleiro[V][H].setBandeira(false);
					break;}
			}
			n++;
			} while(n != V + H);
			
					for(int i = 0; i < largura; i++) {
						for(int j = 0; j < comprimento; j++) 
							matriz = matriz + " " + this.tabuleiro[i][j].porValor();
						matriz = matriz + "\n";}
						return matriz;		
				} 
	}