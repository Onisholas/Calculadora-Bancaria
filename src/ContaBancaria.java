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
}
