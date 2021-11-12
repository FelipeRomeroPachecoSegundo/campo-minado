package campo_mimado;
import java.util.Random;
import java.util.Scanner;

public class Tabulerio extends Célula{

	private int largura, comprimento, contagemTotalDeMinas, posicaoV;
	private Célula[][] tabuleiro, tabalero;
	private char posicaoH;
	
	
	public void setTabuleiro(Célula[] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public int dificuldade(char escolha) {
		switch(escolha) {
		case'1':
			this.largura = 9;
			this.comprimento = 9;
			this.contagemTotalDeMinas = 10;
			break;
		case'2':
			this.largura = 16;
			this.comprimento = 16;
			this.contagemTotalDeMinas = 40;
			break;
		case'3':
			this.largura = 16;
			this.comprimento = 30;
			this.contagemTotalDeMinas = 99;
			break;
		default:
			largura = 0;
		}
		return largura;
	}
	
	/*public boolean verificarArredores() {
		if(tabuleiro[X+1][Y+1] == mina || tabuleiro[X+1][Y-1] == mina ||
			tabuleiro[X+1][Y] == mina || tabuleiro[X][Y+1] == mina ||
			tabuleiro[X][Y-1] == mina || tabuleiro[X-1][Y] == mina ||
			tabuleiro[X-1][Y-1] == mina || tabuleiro[X-1][Y+1] == mina)
			confirm = false;
			else confirm = true;
		return(confirm);
	}*/
	
	public char escolherPosicaoHorizontal() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("diga as coordenadas na horizontal:");
		this.posicaoH = leitura.next().charAt(0);
	return this.posicaoH;
	}
	
	public int escolherPosicaoVertical() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("diga as coordenadas na vertical:");
		this.posicaoV= leitura.nextInt();
		return this.posicaoV;
	}
	
	public void porNumero(Célula[] tabuleiro) {
		for(int i = 0; i < largura; i++) {
			for(int j = 0; j < largura; j++) {
			if (this.tabuleiro[i].setMina(isMina()) == true)
				tabuleiro[i+1][j+1].setnumeros(isnumeros()) = true; tabuleiro[i+1][j-1].setnumeros(isnumeros()) = true;
				tabuleiro[i+1][j].setnumeros(isnumeros()) = true; tabuleiro[i][j+1].setnumeros(isnumeros()) = true;
				tabuleiro[i][j-1].setnumeros(isnumeros()) = true; tabuleiro[i-1][j].setnumeros(isnumeros()) = true;
				tabuleiro[i-1][j+1].setnumeros(isnumeros()) = true; tabuleiro[i-1][j-1].setnumeros(isnumeros()) = true;
			}
		}
	}
	
	public void porBomba(Célula[] tabuleiro) {
		Random aleatorio = new Random();
		int Numerosaleatorios = 0;
		int[] salvarnumero = new int[this.largura*this.comprimento];
		int n = 0;
		while(n != this.contagemTotalDeMinas) {
			salvarnumero[n] = Numerosaleatorios;
			Numerosaleatorios = aleatorio.nextInt(this.largura*this.comprimento);
			for(i = 0; i < n; i++) {
				if(salvarnumero[i] != Numerosaleatorios)
					tabuleiro[Numerosaleatorios].setMina(isMina()) = true;
				else {
					tabuleiro[Numerosaleatorios].setMina(isMina()) = false;
					n--;
					break;
				}
			}
			n++;
		}
	}
	
	public void montarTabuleiro() {
		tabuleiro = new Célula[largura*comprimento];
		for(int j = 0; j < largura*comprimento; j++) 
			this.tabuleiro[j] = new Célula();
		for(int i = 0; i < (largura*comprimento); i++) {
				this.tabuleiro[i].setVazio(isVazio()) = true;
			}
		porBomba(this.tabuleiro);
		
	}
	
	public void imprimirMatriz() {
		char alfabeto;
		montarTabuleiro(this.tabuleiro[]);
		for(int i = 0; i < largura; i++) {
			for(int l = 0; l < comprimento; l++) {
				if(i == 0 && l == 0) {
					System.out.print("    ");
				for(int k = 0; k < comprimento; k++ ) { 
					alfabeto = (char)(65 + k);
					System.out.print(alfabeto+" ");
					}System.out.print("\n");
				}
				if(l == 0) {
					if(i<10)
						System.out.print(" ");
					System.out.print(" "+i);
					}
				if(this.tabuleiro[].isMina() == true)
					System.out.print(" M");
				else if(this.tabuleiro[].isVazio() == true)
					System.out.print(" *");
				else System.out.print(" 0");
			}
			System.out.print("\n");
		}  
	} 
}
