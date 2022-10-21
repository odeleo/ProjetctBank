package banco;

import java.util.Scanner;

import contas.ContaCorrente;
import contas.Poupanca;

public class Main {

	// private static float valor;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ContaCorrente cc = new ContaCorrente();
		
		Poupanca cp = new Poupanca();

		String nome;
		int num, opcao;
		double valor, depositoInicial = 0;

		do {
			System.out.println("+====================================+");
			System.out.println("|      *******G7 Bank*******         |");
			System.out.println("|          MENU DE OPÇÕES            |");
			System.out.println("|        1 - Inserir dados           |");
			System.out.println("|        2 - Mostrar dados           |");
			System.out.println("|        3 - Depositar valor         |");
			System.out.println("|        4 - Sacar valor             |");
			System.out.println("|        5 - Aplicar                 |");
			System.out.println("|        6 - Resgatar                |");
			System.out.println("|        7 - Mostrar saldo           |");
			System.out.println("|        0 - Sair                    |");
			System.out.println("+====================================+");

			opcao = input.nextInt();

			switch (opcao) {

			case 1:
				System.out.println("Nome titular da conta: ");
				input.next();
				
				nome = input.nextLine();
				
				System.out.println("Entre com o Numero da conta: ");
				num = input.nextInt();

				if (depositoInicial <= 0) {
					System.out.println("Seu saldo ?: " + depositoInicial);
					System.out.println("Deseja realizar um depósito? 1-SIM / 2-NÃO");
					int resposta = input.nextInt();
					
					if (resposta == 1) {
						System.out.print("Digite um valor inicial: ");
						depositoInicial = input.nextDouble();
						cc = new ContaCorrente(nome, num, depositoInicial);
						cp = new Poupanca(nome, num);
					} else {
						cc = new ContaCorrente(nome, num);
						cp = new Poupanca(nome, num);
					}
					
				} else {
					System.out.println("Seu saldo ?: " + depositoInicial + ", não precisa de depósito inicial.");
				}
				
				break;

			case 2:
				cc.dadosDaConta();
				cp.dadosDaConta();
				break;

			case 3:
				System.out.println("Entre com o valor a ser depositado: ");
				valor = input.nextDouble();
				cc.depositar(valor);
				break;

			case 4:
				cc.mostrarSaldo();
				cp.mostrarSaldo();
				System.out.println("Entre com o valor a ser sacado: ");
				valor = input.nextDouble();
				cc.sacar(valor);
				break;

			case 5:
				System.out.println("Insira um valor para transferir para Poupança: ");
				valor = input.nextDouble();
				cc.aplicar(valor, cp);
				break;

			case 6:
				System.out.println("Insira um valor para resgatar: ");
				valor = input.nextDouble();
				cp.resgatar(valor, cc);
				break;

			case 7:
				cc.mostrarSaldo();
				cp.mostrarSaldo();
				break;

			default:
				System.out.println("G7 BANK agradece, até logo!");
				
			}
			

		} while (opcao != 0);

		input.close();
	
	}
}


