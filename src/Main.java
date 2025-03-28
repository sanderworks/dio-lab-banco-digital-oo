import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Lab DIO - Banco Digital OO");
		try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {

			Cliente cliente = new Cliente();

			System.out.print("Insira seu nome: ");
			cliente.setNome(scanner.nextLine());

			Conta cc = new ContaCorrente(cliente);
			Conta poupanca = new ContaPoupanca(cliente);

			boolean sair = false;
			while (!sair) {
				System.out.println("\nEscolha uma opção:");
				System.out.println("1 - Depositar na Conta Corrente");
				System.out.println("2 - Transferir para a Conta Poupança");
				System.out.println("3 - Imprimir Extrato da Conta Corrente");
				System.out.println("4 - Imprimir Extrato da Conta Poupança");
				System.out.println("5 - Sair");
				System.out.print("Opção: ");

				int opcao = scanner.nextInt();

				switch (opcao) {
				case 1:
					System.out.print("Digite o valor para depósito: ");
					double valorDeposito = scanner.nextDouble();
					cc.depositar(valorDeposito);
					break;
				case 2:
					System.out.print("Digite o valor para transferência: ");
					double valorTransferencia = scanner.nextDouble();
					cc.transferir(valorTransferencia, poupanca);
					break;
				case 3:
					cc.imprimirExtrato();
					break;
				case 4:
					poupanca.imprimirExtrato();
					break;
				case 5:
					sair = true;
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
				}
			}

		} catch (InputMismatchException ime) {
            System.out.println("Erro! Digita apenas valores numéricos.");            
        } finally {
            System.out.println("Fim da execução.");
        }
	}

}
