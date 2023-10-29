import java.util.Scanner;

public class Executavel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Criar conta");
            System.out.println("2. Selecionar conta");
            System.out.println("5. Finalizar");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    System.out.println("Informe o número da conta:");
                    int numero = scanner.nextInt();
                    ContaBancaria conta = banco.procurarConta(numero);
                    if (conta != null) {
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }
}
