public class ContaCorrente extends ContaBancaria implements Imprimivel{
double taxaDeOperacao;

    public ContaCorrente(int numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    @Override
    public void sacar(double valor) {
        if(valor + taxaDeOperacao <= saldo){
            saldo = saldo - valor + taxaDeOperacao;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor - taxaDeOperacao;
    }

    @Override
    public void mostrarDados() {
        System.out.println();
    }
}
