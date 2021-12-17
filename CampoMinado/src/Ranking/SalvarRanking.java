package Ranking;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class SalvarRanking {

	private static final String newLine = System.getProperty("line.separator");

	public static void gravarRanking(String msg, String nomeArq) {
		PrintWriter printWriter = null;
		File file = new File(nomeArq);
		try {
			if (!file.exists())
				file.createNewFile();
			printWriter = new PrintWriter(new FileOutputStream(nomeArq, true));
			printWriter.write(newLine + msg);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	public static void lerRanking(String nomeArq) {
		String linha = null;
		try {
			FileReader arq = new FileReader(nomeArq);
			BufferedReader lerArq = new BufferedReader(arq);
			linha = lerArq.readLine();
			while (linha != null) {
				try {
					System.out.printf("%d\n", Integer.parseInt(linha));
				} catch (NumberFormatException erro) {
					System.out.print("-");
				}finally {
					linha = lerArq.readLine();
				}
			}

			arq.close();
		} catch (IOException e) {
			System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		System.out.println();
	}

	public static void gravarTempo(long tempo, String nomeArq) {
		Long escolhaO = Long.valueOf(tempo);
		File arq = new File(nomeArq);
		try {
			arq.delete();
			arq.createNewFile();

			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			objOutput.writeObject(tempo);
			objOutput.close();

		} catch (IOException erro) {
			System.out.printf("Erro: %s", erro.getMessage());
		}
	}

	public static Long lerTempo(String nomeArq) {
		Long tempo = null;
		try {
			File arq = new File(nomeArq);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				tempo = (Long) objInput.readObject();
				objInput.close();
			}
		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}

		return (tempo);
	}

}