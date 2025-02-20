import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ContaCorrente[] contasCorrente = new ContaCorrente[5];
        ContaPoupanca[] contasPoupanca = new ContaPoupanca[5];

        // Leitura dos saldos iniciais
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o saldo inicial da Conta Corrente " + (i + 1) + ": ");
            double saldoCorrente = teclado.nextDouble();
            contasCorrente[i] = new ContaCorrente(saldoCorrente);

            System.out.print("Digite o saldo inicial da Conta Poupança " + (i + 1) + ": ");
            double saldoPoupanca = teclado.nextDouble();
            contasPoupanca[i] = new ContaPoupanca(saldoPoupanca);
        }

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Mostrar saldo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();

            if (opcao >= 1 && opcao <= 3) {
                System.out.print("Escolha o tipo de conta (1 - Corrente, 2 - Poupança): ");
                int tipoConta = teclado.nextInt();
                System.out.print("Escolha o número do cliente (1 a 5): ");
                int numeroCliente = teclado.nextInt() - 1;

                if (numeroCliente < 0 || numeroCliente >= 5) {
                    System.out.println("Número de cliente inválido!");
                    continue;
                }

                Conta conta = null;
                if (tipoConta == 1) {
                    conta = contasCorrente[numeroCliente];
                } else if (tipoConta == 2) {
                    conta = contasPoupanca[numeroCliente];
                } else {
                    System.out.println("Tipo de conta inválido!");
                    continue;
                }

                switch (opcao) {
                    case 1: // Depositar
                        System.out.print("Digite o valor a depositar: ");
                        double valorDeposito = teclado.nextDouble();
                        conta.depositar(valorDeposito);
                        break;
                    case 2: // Sacar
                        System.out.print("Digite o valor a sacar: ");
                        double valorSaque = teclado.nextDouble();
                        conta.sacar(valorSaque);
                        break;
                    case 3: // Mostrar saldo
                        System.out.println("Saldo atual: " + String.format("%.2f", conta.GetSaldo()));
                        break;
                }
            }
        } while (opcao != 0);

        teclado.close();
    }
}
