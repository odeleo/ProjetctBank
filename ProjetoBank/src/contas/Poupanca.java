package contas;

public class Poupanca extends ContaCorrente {

	public Poupanca() {

	}

	public Poupanca(String nome, int numero) {
		setTitular(nome);
		setNumConta(numero);
	}

	public void resgatar(double valor, ContaCorrente destino) {
		if (getSaldo() >= valor) {
			setSaldo(getSaldo() - valor); 
			destino.depositar(valor);

		} else {
			System.out.println("saldo insuficiente: Saldo atual: " + getSaldo());
		}
	}

	@Override
	public void mostrarSaldo() {
		System.out.println("Saldo atual da Poupança: " + getSaldo());
	}

	@Override
	public void dadosDaConta() {
		System.out.println("+-------------------------------+");
		System.out.println("| Titular Poupança: " + getTitular());
		System.out.println("| Numero da Conta Poupança: " + getNumConta() + "-1");
		System.out.println("| Saldo atual: " + getSaldo());
		System.out.println("+-------------------------------+\n");
	}


}
