public abstract class Conta {

    protected double saldo;

    public abstract void depositar(double valor);

    public abstract void sacar(double valor,double tributos);

    public abstract double getSaldo();
    
    
}
