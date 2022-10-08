package com.exercicio1;

import java.util.Locale;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		double valor;
		Locale.setDefault(Locale.US);
		Conta c1 = new Conta();
		Conta c2 = new Conta("Mario", 1002);

		Scanner sc = new Scanner(System.in);
		boolean sucessoLeitura = false;
		while (!sucessoLeitura) {
			try {
				System.out.println("          $ Banco Ragnarook  $       \n");

				System.out.print("Cadastre o nome do titular da conta: ");
				String titular = sc.next();

				System.out.print("Cadastre o n�mero da conta: ");
				int conta = sc.nextInt();

				System.out.print("Deseja fazer um dep�sito inicial ? (s/n): ");
				char resp = sc.next().charAt(0);
				if (resp == 's' || resp == 'S') {
					System.out.print("Insira o dep�sito: ");
					double deposito = sc.nextDouble();
					c1.depositar(deposito);
					c1 = new Conta(titular, conta, deposito);
					System.out.println("concl�ido....");
				} else {
					c1 = new Conta(titular, conta);
					System.out.println("conclu�do com sucesso....");
				}

				c1.info();
				System.out.println();

				System.out.print("         MENU     \n\n1 - TRANSFER�NCIA\n2 - SAQUE\n3 - DEPOSITO \n>>");
				int menu = sc.nextInt();

				switch (menu) {

				case 1: {

					System.out.println("   - MENU DE TRANSFER�NCIA -   \n");
					System.out.print("Insira o valor da transfer�ncia: ");
					valor = sc.nextDouble();
					System.out.print("Qual a conta do destinat�rio ? ");
					int contaDestino = sc.nextInt();
					if (contaDestino == 1002) {
						c2.confirmar();
						System.out.print("Confirma a transfer�ncia ? (s/n): ");
						char conf = sc.next().charAt(0);
						if (conf == 's' || conf == 'S') {
							c1.trasnferir(valor, c2);
						} else {
							System.out.println("Transfer�ncia cancelada !");
						}
					} else {
						System.out.println("Conta inv�lida");
						return;
					}
					break;
				}
				case 2: {
					System.out.println("   MENU DE SAQUE   \n");
					System.out.print("Insira o valor do saque: ");
					valor = sc.nextDouble();
					c1.sacar(valor);

					break;
				}
				case 3: {
					System.out.println("   MENU DE DEPOSITO   \n");
					System.out.print("Insira o valor do deposito: ");
					valor = sc.nextDouble();
					c1.depositar(valor);
					break;
				}

				default: {
					System.out.println("OP��O INEXISTENTE");
				}
				}

				sucessoLeitura = true;
			} catch (Exception e) {
				System.out.println("==========================================================================");
				System.out.println(
						"\nOcorreu o seguinte erro -> '" + e.getMessage() + "'\n\nPor favor, insira outro valor.\n");
				System.out.println("==========================================================================\n");
			}

		}
		sc.close();

	}
}
