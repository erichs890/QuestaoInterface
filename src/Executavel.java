import java.util.Scanner;

public class Executavel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        ContaBancaria contaSelecionada = null;

        while (true) {
            if (contaSelecionada == null) {
                System.out.println("Menu:");
                System.out.println("1. Criar conta");
                System.out.println("2. Selecionar conta");
                System.out.println("3. Remover conta");
                System.out.println("4. Gerar relatório");
                System.out.println("5. Finalizar");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Informe o tipo de conta (1: Corrente, 2: Poupança):");
                        int tipo = scanner.nextInt();
                        System.out.println("Informe o número da conta:");
                        int numero = scanner.nextInt();
                        if (tipo == 1) {
                            System.out.println("Informe a taxa de operação:");
                            double taxa = scanner.nextDouble();
                            banco.inserir(new ContaCorrente(numero, taxa));
                        } else {
                            System.out.println("Informe o limite da conta poupança:");
                            double limite = scanner.nextDouble();
                            banco.inserir(new ContaPoupanca(numero, limite));
                        }
                        System.out.println("Conta criada com sucesso.");
                        break;

                    case 2:
                        System.out.println("Informe o número da conta:");
                        numero = scanner.nextInt();
                        contaSelecionada = banco.procurarConta(numero);
                        if (contaSelecionada == null) {
                            System.out.println("Conta não encontrada.");
                        }
                        break;

                    case 3:
                        System.out.println("Informe o número da conta a ser removida:");
                        numero = scanner.nextInt();
                        ContaBancaria conta = banco.procurarConta(numero);
                        if (conta != null) {
                            banco.remover(conta);
                            System.out.println("Conta removida com sucesso.");
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                        break;

                    case 4:
                        banco.mostrarDados();
                        break;

                    case 5:
                        System.out.println("Finalizando...");
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } else {
                System.out.println("Menu da Conta " + contaSelecionada.numeroConta + ":");
                System.out.println("a. Depositar");
                System.out.println("b. Sacar");
                System.out.println("c. Transferir");
                System.out.println("d. Gerar relatório");
                System.out.println("e. Retornar ao menu anterior");
                char opcaoConta = scanner.next().charAt(0);

                switch (opcaoConta) {
                    case 'a':
                        System.out.println("Informe o valor a ser depositado:");
                        double valor = scanner.nextDouble();
                        contaSelecionada.depositar(valor);
                        System.out.println("Valor depositado com sucesso.");
                        break;

                    case 'b':
                        System.out.println("Informe o valor a ser sacado:");
                        valor = scanner.nextDouble();
                        contaSelecionada.sacar(valor);
                        System.out.println("Saque realizado com sucesso.");
                        break;

                    case 'c':
                        System.out.println("Informe o número da conta destino:");
                        int numeroDestino = scanner.nextInt();
                        ContaBancaria contaDestino = banco.procurarConta(numeroDestino);
                        if (contaDestino != null) {
                            System.out.println("Informe o valor a ser transferido:");
                            valor = scanner.nextDouble();
                            contaSelecionada.transferir(valor, contaDestino);
                            System.out.println("Transferência realizada com sucesso.");
                        } else {
                            System.out.println("Conta destino não encontrada.");
                        }
                        break;

                    case 'd':
                        contaSelecionada.mostrarDados();
                        break;

                    case 'e':
                        contaSelecionada = null;
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        }
    }
}
