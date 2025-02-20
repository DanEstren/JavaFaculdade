public class ContaPoupanca implements Conta {

    private double saldo;
    public ContaPoupanca(double saldo){
        this.saldo = saldo;
    }

    @Override
    public double GetSaldo(){
        return this.saldo;
    }

    @Override
    public void depositar(double valor){
         this.saldo = this.saldo+valor;
         System.out.println("o valor de : "+valor+" foi depositado na sua conta");
}

    @Override
    public void sacar(double valor){
        if (saldo >= valor){
            this.saldo = this.saldo - valor;
            System.out.println("o valor de : "+valor+" foi sacado da sua conta");
        }
        else{
            System.out.println("Saldo insuficiente!");
        }

    }
    
}
