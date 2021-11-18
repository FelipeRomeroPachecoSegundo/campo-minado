package campo_mimado;
import java.util.*;
import java.util.Scanner;

public class Tabulerio extends Celula{

	private int largura, comprimento, contagemTotalDeMinas, posicaoV, posicaoH;
	private Celula[][] tabuleiro;
	private char[][] tabalero;
	
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
	
	public int escolherPosicaoHorizontal() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("diga as coordenadas na horizontal:");
		this.posicaoH = leitura.nextInt();
	return this.posicaoH;
	}
	
	public int escolherPosicaoVertical() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("diga as coordenadas na vertical:");
		this.posicaoV= leitura.nextInt();
		return this.posicaoV;
	}
	
	public void porNumero() {
		for(int i = 0; i < largura; i++) {
			for(int j = 0; j < comprimento; j++) {
			if (this.tabuleiro[i][j].isMina() == true)
				this.tabuleiro[i+1][j+1].setNumeros(true); this.tabuleiro[i+1][j-1].setNumeros(true);
				this.tabuleiro[i+1][j].setNumeros(true); this.tabuleiro[i][j+1].setNumeros(true);
				this.tabuleiro[i][j-1].setNumeros(true); this.tabuleiro[i-1][j].setNumeros(true);
				this.tabuleiro[i-1][j+1].setNumeros(true); this.tabuleiro[i-1][j-1].setNumeros(true);
			}
		}
	}
	public int escolherNumero() {
		int numero = 0;
		return numero;
	}
	
	public void porBomba() {
		/*Random aleatorio = new Random();
		TreeSet meuNumero = new TreeSet ();
		int Numerosaleatorios = 0;
		int[] salvarnumero = new int[this.largura*this.comprimento];
		int n = 0;
		while(n != this.contagemTotalDeMinas) {
			salvarnumero[n] = Numerosaleatorios;
			Numerosaleatorios = aleatorio.nextInt(this.largura*this.comprimento);
			for(i = 0; i < n; i++) {
				if(salvarnumero[i] != Numerosaleatorios)
					this.tabuleiro[Numerosaleatorios][Numerosaleatorios].setMina(true);
				else {
					this.tabuleiro[Numerosaleatorios][Numerosaleatorios].setMina(false);
					n--;
					break;
				}
			}
			n++;
		}*/
			this.tabuleiro[5][5].setMina(true);
			
		
	}
	
	public void montarTabuleiro() {
		this.tabuleiro = new Celula[largura][comprimento];
		for(int j = 0; j < largura; j++) {
			for(int k = 0; k < comprimento; k++)
				this.tabuleiro[j][k] = new Celula();
		}
		for(int i = 0; i < largura; i++) {
			for(int l = 0; l < comprimento; l++)
				this.tabuleiro[i][l].setVazio(true);
			}
		porBomba();
	}
	
	public void imprimirMatriz() {
		int n = 0;
		int[] H = new int[comprimento];
		int[] V = new int[largura];
		montarTabuleiro();
		this.tabalero = new char[largura][comprimento];
		do {
			V[n] = escolherPosicaoVertical();
			H[n] = escolherPosicaoHorizontal();
		for(int i = 0; i < largura; i++) {
			for(int l = 0; l < comprimento; l++) {
				if(i == 0 && l == 0) {
					System.out.print("    ");
				for(int k = 0; k < comprimento; k++ ) { 
					System.out.print(k+" ");
					}System.out.print("\n");
				}
				if(l == 0) {
					if(i<10)
						System.out.print(" ");
					System.out.print(" "+i);
					}
				for(int j = 0; j <= n; j++) {
				if(this.tabuleiro[V[j]][H[j]].isMina() == true && V[j] == i && l == H[j]) {
					this.tabalero[i][l] = 'M';
					break;
				}
				else if(this.tabuleiro[V[j]][H[j]].isVazio() == true && V[j] == i && l == H[j]) {
					this.tabalero[i][l] = '*';
					break;
					}
					else this.tabalero[i][l] = '0';
				}
				System.out.print(" "+this.tabalero[i][l]);
				
		}
			System.out.print("\n");
		} n++;
		} while(true);
	} 
}
