import java.util.Scanner;

public class calculadoraDeImc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita peso e altura do usuário
        System.out.print("Digite seu peso (kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura (m): ");
        double altura = scanner.nextDouble();

        // Calcula o IMC
        double imc = peso / (altura * altura);

        // Classificação do IMC
        String resultado;
        if (imc <= 18.5) {
            resultado = "Abaixo do peso";
        } else if (imc <= 24.9) {
            resultado = "Peso ideal";
        } else if (imc <= 29.9) {
            resultado = "Levemente acima do peso";
        } else if (imc <= 34.9) {
            resultado = "Obesidade Grau I";
        } else if (imc <= 39.9) {
            resultado = "Obesidade Grau II (Severa)";
        } else {
            resultado = "Obesidade III (Mórbida)";
        }

        // Exibe o resultado
        System.out.printf("Seu IMC é: %.2f - %s%n", imc, resultado);

        scanner.close();
    }
}
