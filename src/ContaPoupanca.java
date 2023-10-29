public class ContaPoupanca extends ContaBancaria implements Imprimivel{
    double limite;

    public ContaPoupanca(int numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor
    }

    @Override
    public void mostrarDados() {

    }
}
