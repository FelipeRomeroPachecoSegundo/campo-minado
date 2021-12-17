package Tabuleiro;

import Salvar.Salvar;
import java.util.Random;
import Exceptions.ExceptionDificuldade;
import Exceptions.ExceptionEscolha;
import CampoMinado.Interface;

public class Tabuleiro implements Interface {
	private int largura, comprimento, contagemTotalDeMinas, insanidade;
	private Celula[][] tabuleiro;

	public int dificuldade(int dificuldade) throws ExceptionDificuldade {
		switch (dificuldade) {
		case 1:
			this.largura = 9;
			this.comprimento = 9;
			this.contagemTotalDeMinas = 10;
			this.insanidade = 6;
			break;
		case 2:
			this.largura = 16;
			this.comprimento = 16;
			this.contagemTotalDeMinas = 40;
			this.insanidade = 4;
			break;
		case 3:
			this.largura = 16;
			this.comprimento = 30;
			this.contagemTotalDeMinas = 99;
			this.insanidade = 3;
			break;
		default:
			largura = 0;
			ExceptionDificuldade erro = new ExceptionDificuldade();
			throw erro;
		}
		return largura;
	}

	public int getLargura() {
		return largura - 1;
	}

	public int getComprimento() {
		return comprimento - 1;
	}

	public int getLarguraN() {
		return largura;
	}

	public int getComprimentoN() {
		return comprimento;
	}

	public void encurtarAbrirVazios(int a, int b, int c, int d, int linha, int coluna) {
		for (int i = a; i <= c; i++)
			for (int j = b; j <= d; j++)
				this.tabuleiro[linha + i][coluna + j].setEscondidinho(false);
	}

	public void abrirVazios(int tipoJogo) {
		for (int linha = 0; linha < largura; linha++) {
			for (int coluna = 0; coluna < comprimento; coluna++) {
				if (tipoJogo == 1) {
					if (this.tabuleiro[linha][coluna] instanceof CelulaBomba != true
							&& this.tabuleiro[linha][coluna].isEscondidinho() == false
							&& ((CelulaPreencher) this.tabuleiro[linha][coluna]).isNumero() == 0) {
						if (coluna == 0 && linha != 0 && linha != largura - 1)
							encurtarAbrirVazios(-1, 0, 1, 1, linha, coluna);
						else if (coluna == comprimento - 1 && linha != 0 && linha != largura - 1)
							encurtarAbrirVazios(-1, -1, 1, 0, linha, coluna);
						else if (linha == 0 && coluna != 0 && coluna != comprimento - 1)
							encurtarAbrirVazios(0, -1, 1, 1, linha, coluna);
						else if (linha == largura - 1 && coluna != 0 && coluna != comprimento - 1)
							encurtarAbrirVazios(-1, -1, 0, 1, linha, coluna);
						else if (linha > 0 && linha < largura - 1 && coluna > 0 && coluna < comprimento - 1)
							encurtarAbrirVazios(-1, -1, 1, 1, linha, coluna);
						else if (linha == 0 && coluna == 0)
							encurtarAbrirVazios(0, 0, 1, 1, linha, coluna);
						else if (linha == largura - 1 && coluna == 0)
							encurtarAbrirVazios(-1, 0, 0, 1, linha, coluna);
						else if (linha == 0 && coluna == comprimento - 1)
							encurtarAbrirVazios(0, -1, 1, 0, linha, coluna);
						else if (linha == largura - 1 && coluna == comprimento - 1)
							encurtarAbrirVazios(-1, -1, 0, 0, linha, coluna);
					}
				}
				if (tipoJogo == 2) {
					if (((CelulaMaluca) this.tabuleiro[linha][coluna]).isBomba() != true
							&& this.tabuleiro[linha][coluna].isEscondidinho() == false
							&& ((CelulaMaluca) this.tabuleiro[linha][coluna]).getNumero() == 0) {
						if (coluna == 0 && linha != 0 && linha != largura - 1)
							encurtarAbrirVazios(-1, 0, 1, 1, linha, coluna);
						else if (coluna == comprimento - 1 && linha != 0 && linha != largura - 1)
							encurtarAbrirVazios(-1, -1, 1, 0, linha, coluna);
						else if (linha == 0 && coluna != 0 && coluna != comprimento - 1)
							encurtarAbrirVazios(0, -1, 1, 1, linha, coluna);
						else if (linha == largura - 1 && coluna != 0 && coluna != comprimento - 1)
							encurtarAbrirVazios(-1, -1, 0, 1, linha, coluna);
						else if (linha > 0 && linha < largura - 1 && coluna > 0 && coluna < comprimento - 1)
							encurtarAbrirVazios(-1, -1, 1, 1, linha, coluna);
						else if (linha == 0 && coluna == 0)
							encurtarAbrirVazios(0, 0, 1, 1, linha, coluna);
						else if (linha == largura - 1 && coluna == 0)
							encurtarAbrirVazios(-1, 0, 0, 1, linha, coluna);
						else if (linha == 0 && coluna == comprimento - 1)
							encurtarAbrirVazios(0, -1, 1, 0, linha, coluna);
						else if (linha == largura - 1 && coluna == comprimento - 1)
							encurtarAbrirVazios(-1, -1, 0, 0, linha, coluna);
					}
				}
			}
		}
	}

	public void encurtarPorVizinhos(int a, int b, int c, int d, int linha, int coluna, int numero, int tipoJogo) {
		for (int i = a; i <= c; i++) {
			for (int j = b; j <= d; j++) {
				if (tipoJogo == 1) {
					if (this.tabuleiro[linha][coluna] instanceof CelulaBomba != true

							&& this.tabuleiro[linha + i][coluna + j] instanceof CelulaBomba == true) {
						numero++;
						((CelulaPreencher) this.tabuleiro[linha][coluna]).setNumero(numero);
					}
				}
				if (tipoJogo == 2) {
					if (((CelulaMaluca) this.tabuleiro[linha][coluna]).isBomba() != true
							&& ((CelulaMaluca) this.tabuleiro[linha + i][coluna + j]).isBomba() == true) {
						numero++;

						((CelulaMaluca) this.tabuleiro[linha][coluna]).setNumero(numero);
					}
				}
			}
		}
	}

	public void porVizinho(int tipoJogo) {
		int numero;
		for (int linha = 0; linha < largura; linha++) {
			for (int coluna = 0; coluna < comprimento; coluna++) {
				numero = 0;
				if (coluna == 0 && linha != 0 && linha != largura - 1)
					encurtarPorVizinhos(-1, 0, 1, 1, linha, coluna, numero, tipoJogo);
				else if (coluna == comprimento - 1 && linha != 0 && linha != largura - 1)
					encurtarPorVizinhos(-1, -1, 1, 0, linha, coluna, numero, tipoJogo);
				else if (linha == 0 && coluna != 0 && coluna != comprimento - 1)
					encurtarPorVizinhos(0, -1, 1, 1, linha, coluna, numero, tipoJogo);
				else if (linha == largura - 1 && coluna != 0 && coluna != comprimento - 1)
					encurtarPorVizinhos(-1, -1, 0, 1, linha, coluna, numero, tipoJogo);
				else if (linha > 0 && linha < largura - 1 && coluna > 0 && coluna < comprimento - 1)
					encurtarPorVizinhos(-1, -1, 1, 1, linha, coluna, numero, tipoJogo);
				else if (linha == 0 && coluna == 0)
					encurtarPorVizinhos(0, 0, 1, 1, linha, coluna, numero, tipoJogo);
				else if (linha == largura - 1 && coluna == 0)
					encurtarPorVizinhos(-1, 0, 0, 1, linha, coluna, numero, tipoJogo);
				else if (linha == 0 && coluna == comprimento - 1)
					encurtarPorVizinhos(0, -1, 1, 0, linha, coluna, numero, tipoJogo);
				else if (linha == largura - 1 && coluna == comprimento - 1)
					encurtarPorVizinhos(-1, -1, 0, 0, linha, coluna, numero, tipoJogo);
			}
		}
	}

	public void porVazio(int tipoJogo) {
		for (int i = 0; i < largura; i++) {
			for (int l = 0; l < comprimento; l++) {
				if (tipoJogo == 1) {
					if (this.tabuleiro[i][l] instanceof CelulaBomba != true
							&& ((CelulaPreencher) this.tabuleiro[i][l]).isNumero() < 1) {
						((CelulaPreencher) this.tabuleiro[i][l]).setNumero(0);
					}
					if (tipoJogo == 2) {
						if (((CelulaMaluca) this.tabuleiro[i][l]).isBomba() != true
								&& ((CelulaMaluca) this.tabuleiro[i][l]).getNumero() < 1) {
							((CelulaMaluca) this.tabuleiro[i][l]).setNumero(0);
						}
					}
				}
			}
		}
	}

	public void porFalse() {
		for (int j = 0; j < largura; j++) {
			for (int k = 0; k < comprimento; k++)
				if (((CelulaMaluca) this.tabuleiro[10][10]).isBomba() != true)
					((CelulaMaluca) tabuleiro[j][k]).setNumero(0);
		}
	}

	public void porBomba(int tipoJogo) {
		tabuleiro = new Celula[largura][comprimento];
		Random aleatorio = new Random();
		int linha, coluna;
		boolean porMina;
		for (int i = 0; i < contagemTotalDeMinas; i++) {
			if (tipoJogo == 1) {
				do {
					linha = aleatorio.nextInt(this.largura);
					coluna = aleatorio.nextInt(this.comprimento);
					if (this.tabuleiro[linha][coluna] instanceof CelulaBomba == false)
						porMina = true;
					else
						porMina = false;
				} while (porMina == false);
				this.tabuleiro[linha][coluna] = new CelulaBomba();
				
			}
				
			if (tipoJogo == 2) {
				inicializarCelulaMaluca();

				do {
					linha = aleatorio.nextInt(this.largura);
					coluna = aleatorio.nextInt(this.comprimento);
					if (((CelulaMaluca) this.tabuleiro[linha][coluna]).isBomba() == false)
						porMina = true;
					else
						porMina = false;
				} while (porMina == false);
				((CelulaMaluca) this.tabuleiro[linha][coluna]).setBomba(true);

			}
		}
	}

	public void esconderCelulas() {
		for (int j = 0; j < largura; j++) {
			for (int k = 0; k < comprimento; k++)
				this.tabuleiro[j][k].setEscondidinho(true);
		}
	}

	public void inicializarResto() {
		for (int j = 0; j < largura; j++) {
			for (int k = 0; k < comprimento; k++)
				if (this.tabuleiro[j][k] instanceof CelulaBomba != true)
					this.tabuleiro[j][k] = new CelulaPreencher();
		}
	}

	public void inicializarCelulaMaluca() {
		tabuleiro = new Celula[largura][comprimento];
		for (int j = 0; j < largura; j++) {
			for (int k = 0; k < comprimento; k++)
				this.tabuleiro[j][k] = new CelulaMaluca();
		}
	}

	public void montarTabuleiro(int tipoJogo) {
		porVizinho(tipoJogo);
		porVazio(tipoJogo);
	}

	public boolean fimDeJogo(int V, int H, int tipoJogo) {
		boolean b = false;
		if (tipoJogo == 2) {
			if (this.tabuleiro[V][H].isEscondidinho() == false
					&& ((CelulaMaluca) this.tabuleiro[V][H]).isBomba() == true)
				b = true;
			else
				b = false;
		}
		if (tipoJogo == 1) {
			if (this.tabuleiro[V][H].isEscondidinho() == false && this.tabuleiro[V][H] instanceof CelulaBomba == true)
				b = true;
			else
				b = false;
		}
		return b;
	}

	public boolean venceuJogo(int tipoJogo) {
		if (tipoJogo == 2) {
			for (int j = 0; j < largura; j++) {
				for (int k = 0; k < comprimento; k++) {
					if (this.tabuleiro[j][k].isEscondidinho() == false
							|| ((CelulaMaluca) this.tabuleiro[j][k]).isBomba() == true)
						continue;
					else
						return false;
				}
			}
		}
		if (tipoJogo == 1) {
			for (int j = 0; j < largura; j++) {
				for (int k = 0; k < comprimento; k++) {
					if (this.tabuleiro[j][k].isEscondidinho() == false
							|| this.tabuleiro[j][k] instanceof CelulaBomba == true)
						continue;

					else
						return false;
				}
			}
		}
		return true;
	}

	public void novoJogo() {
		Salvar.deletarArquivo("dadosTabuleiro.dat");
	}

	public String stringarMatriz(int continuar, int V, int H, int bandeira, int jogada, int tipoJogo)
			throws ExceptionEscolha {
		String matriz = "\n";
		Random rand = new Random();
		boolean darErro = false;
		int n = 0;
		if (jogada == 1 && continuar == 2 && tipoJogo == 1) {
			porBomba(tipoJogo);
			inicializarResto();
			esconderCelulas();
		}
		if (jogada == 1 && continuar == 2 && tipoJogo == 2) {
			inicializarCelulaMaluca();
			porBomba(tipoJogo);
			esconderCelulas();
		}
		if (continuar == 1)
			this.tabuleiro = Salvar.lerTabuleiro("dadosTabuleiro.dat");
		if (bandeira != 1 && bandeira != 2) {
			darErro = true;
			ExceptionEscolha erro1 = new ExceptionEscolha();
			throw erro1;
		}
		if (tipoJogo != 1 && tipoJogo != 2) {
			darErro = true;
			ExceptionEscolha erro2 = new ExceptionEscolha();
			throw erro2;
		}
		if (tipoJogo == 2 && bandeira == 1 && rand.nextInt(this.insanidade) == 1
				&& this.tabuleiro[V][H].isBandeira() == false) {
			if (((CelulaMaluca) this.tabuleiro[V][H]).isBomba() == true) {
				((CelulaMaluca) this.tabuleiro[V][H]).setBomba(false);
				porFalse();
				montarTabuleiro(tipoJogo);
			} else
				montarTabuleiro(tipoJogo);
			if (((CelulaMaluca) this.tabuleiro[V][H]).isBomba() == false) {
				porFalse();
				((CelulaMaluca) this.tabuleiro[V][H]).setBomba(true);
				montarTabuleiro(tipoJogo);
			} else
				montarTabuleiro(tipoJogo);
		} else
			montarTabuleiro(tipoJogo);

		if (darErro == false) {
			do {
				if (tipoJogo == 1) {
					if (bandeira == 2 && this.tabuleiro[V][H].isBandeira() != true)
						if (this.tabuleiro[V][H] instanceof CelulaBomba == true
								|| ((CelulaPreencher) this.tabuleiro[V][H]).isNumero() != 0)
							this.tabuleiro[V][H].setEscondidinho(false);
						else {
							if (((CelulaPreencher) this.tabuleiro[V][H]).isNumero() == 0) {
								this.tabuleiro[V][H].setEscondidinho(false);
								abrirVazios(tipoJogo);
							}
						}
				}
				if (tipoJogo == 2) {
					if (bandeira == 2 && this.tabuleiro[V][H].isBandeira() != true)
						if (((CelulaMaluca) this.tabuleiro[V][H]).isBomba() == true
								|| ((CelulaMaluca) this.tabuleiro[V][H]).getNumero() != 0)
							this.tabuleiro[V][H].setEscondidinho(false);
						else {
							if (((CelulaMaluca) this.tabuleiro[V][H]).getNumero() == 0) {
								this.tabuleiro[V][H].setEscondidinho(false);
								abrirVazios(tipoJogo);
							}
						}
				}

				if (bandeira == 1 && this.tabuleiro[V][H].isEscondidinho() == true) {
					if (this.tabuleiro[V][H].isBandeira() != true) {
						this.tabuleiro[V][H].setBandeira(true);
						break;
					} else {
						this.tabuleiro[V][H].setBandeira(false);
						break;
					}
				}
				n++;
			} while (n != V + H + 1);
		}
		if (tipoJogo == 1)
			for (int i = 0; i < largura; i++) {
				for (int j = 0; j < comprimento; j++) {
					if (this.tabuleiro[i][j].isBandeira() == true)
						matriz = matriz + " B";
					else {
						if (this.tabuleiro[i][j].isEscondidinho() == true)
							matriz = matriz + " *";
						else {
							if (this.tabuleiro[i][j] instanceof CelulaBomba == true)
								matriz = matriz + " " + 9;
							else {
								if (((CelulaPreencher) this.tabuleiro[i][j]).isNumero() != 0)
									matriz = matriz + " " + ((CelulaPreencher) this.tabuleiro[i][j]).isNumero();
								if (((CelulaPreencher) this.tabuleiro[i][j]).isNumero() == 0)
									matriz = matriz + " " + 0;
							}
						}
					}
				}
				matriz = matriz + "\n";
			}
		if (tipoJogo == 2)
			for (int i = 0; i < largura; i++) {
				for (int j = 0; j < comprimento; j++) {
					if (this.tabuleiro[i][j].isBandeira() == true)
						matriz = matriz + " B";
					else {
						if (this.tabuleiro[i][j].isEscondidinho() == true)
							matriz = matriz + " *";
						else {
							if (((CelulaMaluca) this.tabuleiro[i][j]).isBomba() == true)
								matriz = matriz + " " + 9;
							else {
								if (((CelulaMaluca) this.tabuleiro[i][j]).getNumero() != 0)
									matriz = matriz + " " + ((CelulaMaluca) this.tabuleiro[i][j]).getNumero();
								if (((CelulaMaluca) this.tabuleiro[i][j]).getNumero() == 0)
									matriz = matriz + " " + 0;
							}
						}
					}
				}
				matriz = matriz + "\n";
			}
		Salvar.gravarTabuleiro(this.tabuleiro, "dadosTabuleiro.dat");
		return matriz;
	}
}