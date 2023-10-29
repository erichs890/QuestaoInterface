import java.util.ArrayList;

public class Banco implements Imprimivel {
    private ArrayList<ContaBancaria> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void inserir(ContaBancaria conta) {
        contas.add(conta);
    }

    public void remover(ContaBancaria conta) {
        contas.remove(conta);
    }

    public ContaBancaria procurarConta(int numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.numeroConta == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public void mostrarDados() {
        for (ContaBancaria conta : contas) {
            conta.mostrarDados();
        }
    }
}
