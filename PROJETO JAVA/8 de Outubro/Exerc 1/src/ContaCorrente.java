public class ContaCorrente implements Conta {

    private double saldo;
    private double taxaoperacao = 1.013;

    public ContaCorrente(double saldo){
        this.saldo = saldo;
        
    }

    @Override
    public double GetSaldo(){
        return this.saldo;
    }

    @Override
    public void sacar(double valor){
        if (saldo >= valor){
            this.saldo = this.saldo - (valor*taxaoperacao);
            System.out.println("Foi sacado "+valor+" da sua conta com uma taxa de "+ String.format("%.2f",valor*taxaoperacao));
        }
        else{
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void depositar(double valor){
        this.saldo = this.saldo + valor;
        System.out.println("O valor de "+valor+" foi depositado na sua conta");
    }

    
    
}
