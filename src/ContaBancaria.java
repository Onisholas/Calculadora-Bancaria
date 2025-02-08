import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private boolean usandoChequeEspecial;

    public ContaBancaria(double saldoInicial, double chequeEspecial) {
        this.saldo = saldoInicial;
        this.chequeEspecial = chequeEspecial;
        this.usandoChequeEspecial = false;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarChequeEspecial() {
        return chequeEspecial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0) {
            if (saldo + chequeEspecial >= valor) {
                saldo -= valor;
                if (saldo < 0) {
                    usandoChequeEspecial = true;
                }
                System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar o saque.");
            }
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }

    public void pagarBoleto(double valor) {
        if (valor > 0) {
            if (saldo + chequeEspecial >= valor) {
                saldo -= valor;
                if (saldo < 0) {
                    usandoChequeEspecial = true;
                }
                System.out.println("Boleto de R$ " + valor + " pago com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para pagar o boleto.");
            }
        } else {
            System.out.println("Valor do boleto inválido.");
        }
    }

    public boolean isUsandoChequeEspecial() {
        return usandoChequeEspecial;
    }

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