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

				System.out.print("Cadastre o número da conta: ");
				int conta = sc.nextInt();

				System.out.print("Deseja fazer um depósito inicial ? (s/n): ");
				char resp = sc.next().charAt(0);
				if (resp == 's' || resp == 'S') {
					System.out.print("Insira o depósito: ");
					double deposito = sc.nextDouble();
					c1.depositar(deposito);
					c1 = new Conta(titular, conta, deposito);
					System.out.println("conclúido....");
				} else {
					c1 = new Conta(titular, conta);
					System.out.println("concluído com sucesso....");
				}

				c1.info();
				System.out.println();

				System.out.print("         MENU     \n\n1 - TRANSFERÊNCIA\n2 - SAQUE\n3 - DEPOSITO \n>>");
				int menu = sc.nextInt();

				switch (menu) {

				case 1: {

					System.out.println("   - MENU DE TRANSFERÊNCIA -   \n");
					System.out.print("Insira o valor da transferência: ");
					valor = sc.nextDouble();
					System.out.print("Qual a conta do destinatário ? ");
					int contaDestino = sc.nextInt();
					if (contaDestino == 1002) {
						c2.confirmar();
						System.out.print("Confirma a transferência ? (s/n): ");
						char conf = sc.next().charAt(0);
						if (conf == 's' || conf == 'S') {
							c1.trasnferir(valor, c2);
						} else {
							System.out.println("Transferência cancelada !");
						}
					} else {
						System.out.println("Conta inválida");
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
					System.out.println("OPÇÃO INEXISTENTE");
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
