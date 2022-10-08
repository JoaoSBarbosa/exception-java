package com.exercicio1;

public class Conta {
	private String nome;
	private double saldo;
	private int conta;

	// Construtores
	public Conta() {

	}

	public Conta(String nome, int conta, double saldo) {

		this.nome = nome;
		this.saldo = saldo;
		this.conta = conta;
	}
	public Conta(String nome, int conta) {

		this.nome = nome;
		this.conta = conta;
	}

	// Get e Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getConta() {
		return conta;
	}

	// m�todo - DEPOSITAR
	public void depositar(double valor) {

		if (valor <= 0) {
			throw new RuntimeException("VALOR '" + valor + "' � INV�LIDO");
		} else if (valor > 20000) {
			System.out.println("Valor muito alto, entre em contato com a gerente");
		} else {
			saldo += valor;
			System.out.println("Deposito de R$ " + String.format("%.2f", valor) + " realizado com sucesso !");
		}

		System.out.println();
	}
	
	// m�todo -> SACAR
	public void sacar(double valor) {
		if (valor > saldo) {
			throw new RuntimeException("SALDO INSUFICIENTE");

		} else if (valor <= 0) {
			throw new RuntimeException("VALOR '" + String.format("%.2f", valor) + "' � INV�LIDO");
		} else if (valor > 20000) {
			throw new RuntimeException(
					"VALOR '" + String.format("%.2f", valor) + "' � MUITO ALTO, CONTATO O SEU GERENTE");
		} else {
			saldo -= valor;
			System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso");
		}
		System.out.println();
	}

	// m�todo -> TRANSFERIR
	public void trasnferir(double valor, Conta destino) {
		if (valor > saldo) {
			throw new RuntimeException("SALDO INSUFICIENTE");

		} else if (valor <= 0) {
			throw new RuntimeException("VALOR '" + String.format("%.2f", valor) + "' � INV�LIDO");
		} else if (valor > 20000) {
			System.out.println("Valor muito alto, entre em contato com a gerente");
		} else {
			saldo -= valor;
			destino.saldo+= valor;
			System.out.println("***************************************************");
			System.out.println("\nTransfer�ncia de R$ " + String.format("%.2f", valor) 
				+ " realizado com sucesso !\n"
				+ "\nDestinatario: " +destino.nome 
				+"\nConta: "+conta
				+"\nValor: R$ "+valor);
			System.out.println("***************************************************");
		}
		System.out.println();
	}
	
	// IMPRESS�ES
	public void info() {
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("Titular: "+nome);
		System.out.println("Conta: " + conta);
		System.out.println("Saldo: " + String.format("%.2f", saldo));
		System.out.println("***************************************************");
	}
	@Override
	public String toString() {
		return "\n    Atualiza��o  \n  --<><><><><>--\nNome:"+ nome +"\nNovo saldo: R$ "+saldo+"\n  --<><><><><>--";
	}
	public void confirmar() {
		System.out.println();
		System.out.println("Destinatario: "+nome+"\nConta: "+conta);
	}

}
