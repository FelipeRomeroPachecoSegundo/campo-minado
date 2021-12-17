package CampoMinado;

import java.util.InputMismatchException;
import java.util.Scanner;
import Exceptions.ExceptionMenu;
import Ranking.SalvarRanking;
import Salvar.Salvar;
import Exceptions.ExceptionDificuldade;
import Exceptions.ExceptionEscolha;
import Tabuleiro.Tabuleiro;

public class CampoMinado {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		Scanner leitura = new Scanner(System.in);
		String matriz = new String();
		int verificar = 0, V = 0, H = 0, bandeira = 0, jogada = 1, sair = 0, continuar, tipoJogo = 0, menu = 0;
		String tempo;
		Integer dificuldade = null;
		do {
			try {
			System.out.println("BEM VINDO AO CAMPO MINADO \n1-NOVO JOGO  \n2-CONTINUAR  \n3-RANKING  \n4-SAIR");
			menu = leitura.nextInt();
			} catch(InputMismatchException e) {
                System.out.println("Por favor digite um numero\n"); }
			leitura.nextLine();
			try {
				switch (menu) {
				case 1: {
				 jogada = 1;
					continuar = 2;
					do {
						
						try { 
							System.out.println("qual tipo de campo minado desejas jogar? \n1-Normal  2-Maluco");
							tipoJogo = leitura.nextInt();
		                } catch(InputMismatchException e) {
		                    System.out.println("Por favor digite um numero\n"); }
						leitura.nextLine();
					} while (tipoJogo != 1 && tipoJogo != 2);
					Salvar.gravarEscolha(tipoJogo, "dadoTipoJogo.dat");
					do {
						try {
							System.out.println("escolha uma dificuldade. \n1-Facil  2-Medio  3-Dificil");
							dificuldade = leitura.nextInt();
							verificar = tabuleiro.dificuldade(dificuldade);
						} catch (ExceptionDificuldade erro2) {
							System.err.println(erro2.getMessage());
						} catch(InputMismatchException e) {
		                    System.out.println("Por favor digite um numero\n"); }
						leitura.nextLine();
					} while (verificar == 0);
					Salvar.gravarEscolha(dificuldade, "dadoDificuldade.dat");
					long inicio = System.currentTimeMillis();
					do {
						do {
							try {
								System.out.println("diga as coordenadas na vertical:");
								V = leitura.nextInt();
								System.out.println("diga as coordenadas na horizontal:");
								H = leitura.nextInt();
								if (V < 0 || V > tabuleiro.getLargura() || H < 0 || H > tabuleiro.getComprimento()) {
									ArrayIndexOutOfBoundsException erro3 = new ArrayIndexOutOfBoundsException();
									throw erro3;
								}
							} catch (ArrayIndexOutOfBoundsException erro3) {
								System.err.println("na dificuldade escolhida, as coordenadas na vertical vão de 0 até "
										+ tabuleiro.getLargura() + " e as da horizontal vão de 0 até "
										+ tabuleiro.getComprimento());
							} catch(InputMismatchException e) {
			                    System.out.println("Por favor digite um numero\n"); }
							leitura.nextLine();
						} while (V < 0 || V > tabuleiro.getLargura() || H < 0 || H > tabuleiro.getComprimento());
						do {
							try {
								System.out.println("desejas selecionar uma bandeira?\n1-Sim\t2-Nao");
								bandeira = leitura.nextInt();
								matriz = tabuleiro.stringarMatriz(continuar, V, H, bandeira, jogada, tipoJogo);
							} catch (ExceptionEscolha erro4) {
								System.err.println(erro4.getMessage());
							} catch(InputMismatchException e) {
			                    System.out.println("Por favor digite um numero\n"); }
							leitura.nextLine();
						} while (bandeira != 1 && bandeira != 2);
						System.out.println(matriz);
						if (tabuleiro.venceuJogo(tipoJogo) == true) {
							long fim = System.currentTimeMillis();
							tempo = String.valueOf(inicio - fim);
							SalvarRanking.gravarRanking(tempo, "dadosRanking.txt");
							System.out.println("você venceu!!");
							Salvar.deletarArquivo("dadoDificuldade.dat");
							Salvar.deletarArquivo("dadoTipoJogo.dat");
							System.exit(1);
						}
						if(tabuleiro.fimDeJogo(V, H, tipoJogo) == true) {
							System.out.println("você perdeu!!");
							Salvar.deletarArquivo("dadoDificuldade.dat");
							Salvar.deletarArquivo("dadoTipoJogo.dat");
							System.exit(1);
						}
						try {
						System.out.println("desejas encerrar o jogo?\n1-Sim\t2-Nao");
						sair = leitura.nextInt();
						} catch(InputMismatchException e) {
		                    System.out.println("Por favor digite um numero\n"); }
						leitura.nextLine();
						jogada++;
					} while (sair != 1);
					long fim = System.currentTimeMillis();
					SalvarRanking.gravarTempo((fim - inicio), "dadosTempo.txt");
					break;
				}
				case 2: {
					continuar = 1;
						dificuldade = Salvar.lerEscolha("dadoDificuldade.dat");
						try {
						verificar = tabuleiro.dificuldade(dificuldade);
					} catch(NullPointerException erro) {
						System.out.println("\n");
						continue;
					} catch (ExceptionDificuldade erro2) {
						System.err.println(erro2.getMessage());
					}
					try {
						tipoJogo = Salvar.lerEscolha("dadoTipoJogo.dat");
					} catch(NullPointerException erro) {
						System.out.println("\n");
						continue;
					}
					long inicio = System.currentTimeMillis();
					inicio = inicio + SalvarRanking.lerTempo("dadosTempo.txt");
					do {
						do {
							try {
								System.out.println("diga as coordenadas na vertical:");
								V = leitura.nextInt();
								System.out.println("diga as coordenadas na horizontal:");
								H = leitura.nextInt();
							
								if (V < 0 && V > tabuleiro.getLargura() && H < 0 && H > tabuleiro.getComprimento()) {
									ArrayIndexOutOfBoundsException erro3 = new ArrayIndexOutOfBoundsException();
									throw erro3;
								} 
							} catch (ArrayIndexOutOfBoundsException err3) {
								System.err.println("na dificuldade escolhida, as coordenadas na vertical vão de 0 até "
										+ tabuleiro.getLargura() + " e as da horizontal vão de 0 até "
										+ tabuleiro.getComprimento());
							} catch(InputMismatchException e) {
			                    System.out.println("Por favor digite um numero\n"); }
							leitura.nextLine();
						} while (V < 0 && V > tabuleiro.getLargura() && H < 0 && H > tabuleiro.getComprimento());
						do {
							try {
								System.out.println("desejas selecionar uma bandeira?\n1-Sim\t2-Nao");
								bandeira = leitura.nextInt();
								matriz = tabuleiro.stringarMatriz(continuar, V, H, bandeira, jogada, tipoJogo);
							} catch (ExceptionEscolha erro1) {
								System.err.println(erro1.getMessage());
							} catch(InputMismatchException e) {
			                    System.out.println("Por favor digite um numero\n"); }
							leitura.nextLine();
						} while (bandeira != 1 && bandeira != 2);
						System.out.println(matriz);
						if (tabuleiro.venceuJogo(tipoJogo) == true) {
							long fim = System.currentTimeMillis();
							tempo = String.valueOf(inicio - fim);
							SalvarRanking.gravarRanking(tempo, "dadosRanking.txt");
							System.out.println("você venceu!!");
							Salvar.deletarArquivo("dadoDificuldade.dat");
							Salvar.deletarArquivo("dadoTipoJogo.dat");
							System.exit(1);
						}
						if(tabuleiro.fimDeJogo(V, H, tipoJogo) == true) {
							System.out.println("você perdeu!!");
							Salvar.deletarArquivo("dadoDificuldade.dat");
							Salvar.deletarArquivo("dadoTipoJogo.dat");
							System.exit(1);
						}
						try {
						System.out.println("desejas encerrar o jogo?\n1-Sim\t2-Nao");
						sair = leitura.nextInt();
						} catch(InputMismatchException e) {
		                    System.out.println("Por favor digite um numero\n"); }
						leitura.nextLine();
						jogada++;
					} while (sair != 1);
					long fim = System.currentTimeMillis();
					SalvarRanking.gravarTempo((fim - inicio), "dadosTempo.txt");
					break;
				}
				case 3:
					SalvarRanking.lerRanking("dadosRanking.txt");
					break;
				case 4:
					System.exit(1);
					break;
				default:
					ExceptionMenu erro5 = new ExceptionMenu();
					throw erro5;
				}

			} catch (ExceptionMenu erro5) {
				System.err.println(erro5.getMessage());
			}
		} while (menu != '4');
	}
	
}