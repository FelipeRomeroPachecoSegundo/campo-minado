package campo_mimado;
import java.util.Scanner;
public class Campo_Mimado {

	public static void main(String[] args) {
		Tabulerio tabulerio = new Tabulerio();
		Scanner leitura = new Scanner(System.in);
		int verificação1, X;
		char escolha, Y;
		System.out.println("vamos começar o jogo, primeiro escolha uma dificuldade. \n1-Facil  2-Medio  3-Dificil");
		do {
		escolha = leitura.next().charAt(0);
		verificação1 = tabulerio.dificuldade(escolha);
		} while(verificação1 == 0);
		do {
		tabulerio.imprimirMatriz();
		} while(true);
		
	}

}
