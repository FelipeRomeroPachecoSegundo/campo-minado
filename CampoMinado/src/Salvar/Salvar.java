package Salvar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Tabuleiro.Celula;
import Tabuleiro.Tabuleiro;

public class Salvar {

	public static void gravarTabuleiro(Celula[][] tabuleiro, String nomeArq) {
		File arq = new File(nomeArq);
		try {
			arq.delete();
			arq.createNewFile();
			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			objOutput.writeObject(tabuleiro);
			objOutput.close();

		} catch (IOException erro) {
			System.out.printf("Erro: %s", erro.getMessage());
		}
	}

	public static Celula[][] lerTabuleiro(String nomeArq) {
		Tabuleiro tabu = new Tabuleiro();
		Celula[][] tabuleiro = new Celula[tabu.getLarguraN()][tabu.getComprimentoN()];
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				tabuleiro = (Celula[][]) objInput.readObject();
				objInput.close();
			}
		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}

		return (tabuleiro);
	}
	public static void gravarEscolha(int list, String nomeArq) {
		Integer listP = Integer.valueOf(list);
		try {
			FileOutputStream arq = new FileOutputStream(nomeArq);
			DataOutputStream gravarArq = new DataOutputStream(arq);
			gravarArq.writeInt(listP);
			arq.close();
		} catch (IOException erro) {
			System.out.printf("Erro: %s", erro.getMessage());
		}
	}

	public static Integer lerEscolha(String nomeArq) {
		Integer list = null;
		try {
			FileInputStream arq = new FileInputStream(nomeArq);
			DataInputStream lerArq = new DataInputStream(arq);
			list = lerArq.readInt();
			arq.close();
		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		}

		return (list);
	}

	public static void deletarArquivo(String nomeArq) {
		File file = new File(nomeArq);
		file.delete();
	}
}
