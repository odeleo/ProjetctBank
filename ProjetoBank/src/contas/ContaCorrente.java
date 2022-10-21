package contas;

public class ContaCorrente {

		private int numConta;
		private String titular;
		private double saldo;

		public ContaCorrente() {

		}

		public ContaCorrente(String nome, int numero, double saldoInicial) {
			this.titular = nome;
			this.numConta = numero;
			depositar(saldoInicial);
		}

		public ContaCorrente(String nome, int numero) {
			this.numConta = numero;
			this.titular = nome;
		}

		public int getNumConta() {
			return numConta;
		}

		public void setNumConta(int numConta) {
			this.numConta = numConta;
		}

		public String getTitular() {
			return titular;
		}

		public void setTitular(String titular) {
			this.titular = titular;
		}

		public double getSaldo() {
			return saldo;
		}

		protected void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public void sacar(double valor) {
			if (this.saldo < valor) {
				System.out.println("Saque nao Realizado");
			} else {
				this.saldo = this.saldo - valor;
				System.out.println("Saque Realizado");
			}
		}

		public void depositar(double valor) {
			this.saldo = this.saldo + valor;
		}

		public void dadosDaConta() {
			System.out.println("+-------------------------------+");
			System.out.println("|          DADOS DA CONTA        ");
			System.out.println("| Titular Conta Corrente: " + this.getTitular());
			System.out.println("| Numero da Conta: " + this.getNumConta());
			System.out.println("| Saldo atual: " + this.getSaldo());
			System.out.println("+-------------------------------+");
		}

		public void mostrarSaldo() {
			System.out.printf("Saldo Atual Conta Corrente: %.2f\n", this.getSaldo());

		}

		public void aplicar(double valor, Poupanca destino) {
			if (this.saldo >= valor) {
				this.saldo -= valor;
				destino.depositar(valor);
			}

		}

}
