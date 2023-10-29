public abstract class ContaBancaria {
    int numeroConta;
    double saldo;
    public ContaBancaria(int numeroConta, double saldo){
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }
    public abstract void sacar(double valor);
    public abstract void depositar (double valor);

}
