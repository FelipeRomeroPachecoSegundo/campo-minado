package campo_mimado;
import java.util.Scanner;

import interface_grafica.InterfaceGrafica;
import tabuleiro.Tabuleiro;
public class CampoMinado {
		public static void main(String[] args) {
			InterfaceGrafica tabuleiro = new Tabuleiro();
			Scanner leitura = new Scanner(System.in);
			String matriz = new String();
			int verifica��o1, V, H, bandeira, jogada = 1;
			char escolha;
			System.out.println("vamos come�ar o jogo, primeiro escolha uma dificuldade. \n1-Facil  2-Medio  3-Dificil");
			do {
			escolha = leitura.next().charAt(0);
			verifica��o1 = tabuleiro.dificuldade(escolha);
			} while(verifica��o1 == 0);
			do {
				System.out.println("desejas selecionar uma bandeira?\n1-Sim\t2-Nao");
				bandeira = leitura.nextInt();
				System.out.println("diga as coordenadas na vertical:");
				V= leitura.nextInt();
				System.out.println("diga as coordenadas na horizontal:");
				H = leitura.nextInt();
				matriz = tabuleiro.stringarMatriz(V, H, bandeira, jogada);
				System.out.println(matriz);
				jogada++;
			}while(true);
		}
	}