package CampoMinado;

import Exceptions.ExceptionDificuldade;
import Exceptions.ExceptionEscolha;

public interface Interface {
	public int dificuldade(int escolha) throws ExceptionDificuldade;

	public String stringarMatriz(int continuar, int V, int H, int bandeira, int jogada, int tipoJogo) throws ExceptionEscolha;
}
