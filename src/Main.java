import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria(1000.0, 500.0); // Saldo inicial de R$ 1000 e cheque especial de R$ 500

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Consultar Cheque Especial");
            System.out.println("3. Depositar Dinheiro");
            System.out.println("4. Sacar Dinheiro");
            System.out.println("5. Pagar Boleto");
            System.out.println("6. Verificar se está usando Cheque Especial");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo: R$ " + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.println("Cheque Especial: R$ " + conta.consultarChequeEspecial());
                    break;
                case 3:
                    System.out.print("Digite o valor a depositar: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 4:
                    System.out.print("Digite o valor a sacar: R$ ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 5:
                    System.out.print("Digite o valor do boleto: R$ ");
                    double valorBoleto = scanner.nextDouble();
                    conta.pagarBoleto(valorBoleto);
                    break;
                case 6:
                    if (conta.isUsandoChequeEspecial()) {
                        System.out.println("A conta está usando cheque especial.");
                    } else {
                        System.out.println("A conta não está usando cheque especial.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
