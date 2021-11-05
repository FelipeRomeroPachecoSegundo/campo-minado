package campo_mimado;

import java.util.Random;

public class Tabulerio {

	private int largura, comprimento, contagemTotalDeMinas;
	private char[][] tabuleiro;
	private boolean confirm;
	private Célula celula = new Célula();
	
	public void dificuldade(char escolha) {
		int quantDeNumerosleatorios;
		switch(escolha) {
		case'f':
			this.largura = 9;
			this.comprimento = 9;
			this.contagemTotalDeMinas = 10;
			quantDeNumerosleatorios = 16;
			break;
		case'm':
			this.largura = 16;
			this.comprimento = 16;
			this.contagemTotalDeMinas = 40;
			quantDeNumerosleatorios = 6;
			break;
		case'd':
			this.largura = 16;
			this.comprimento = 30;
			this.contagemTotalDeMinas = 99;
			quantDeNumerosleatorios = 9;
			break;
		}
	}
	
	public boolean verificarArredores(int X, int Y) {
		if(tabuleiro[X+1][Y+1] == celula.mina || tabuleiro[X+1][Y-1] == celula.mina ||
			tabuleiro[X+1][Y] == celula.mina || tabuleiro[X][Y+1] == celula.mina ||
			tabuleiro[X][Y-1] == celula.mina || tabuleiro[X-1][Y] == celula.mina ||
			tabuleiro[X-1][Y-1] == celula.mina || tabuleiro[X-1][Y+1] == celula.mina)
			confirm = false;
			else confirm = true;
		return(confirm);
	}
	
	public void abrirEspaço() {
		if(celula.expandir == true) {
		}
	}	
	
	public void gerarMatrizComBomba(int quantDeNumerosleatorios) { 
		Random random = new Random();
		int numeroAleatorio = random.nextInt(quantDeNumerosleatorios);
		int numeroDeMinas;
		do {
			numeroDeMinas = 0;
			for(int i = 0; i<largura; i++) {
				for(int j = 0; j<comprimento; j++) {
					if(numeroAleatorio == 1 && numeroDeMinas < contagemTotalDeMinas) { 
					tabuleiro[i][j] = celula.mina; 
					numeroDeMinas++;
					}
					else tabuleiro[i][j] = '0';
				}
			}
		} while (numeroDeMinas != contagemTotalDeMinas);
	}

	public int colocarNumero() {
		if(confirm == false)
			celula.numeroDaCelula++;
		return celula.numeroDaCelula
	}
	
	public void gerarMatrizEscondida() {
		for(int i = 0; i < largura; i++) {
			for(int j = 0; j<comprimento; j++)
				tabuleiro[i][j] = celula.escondidinho;
		}
		
	}
	
	public void imprimirMatriz() {
		for(int i = 0; i < largura; i++) {
			for(int l = 0; l < comprimento; l++)
				System.out.print(" "+tabuleiro[i][l]);
			System.out.print("\n");
		} 
	} 
	
}
