public class ContaCorrente extends Conta implements Tributavel{

    public ContaCorrente(double saldo){
        this.saldo = saldo;
        
    }

    @Override
    public double getSaldo(){
        return this.saldo;
    }

    @Override
    public void sacar(double valor,double tributos){
        if (this.saldo >= valor+tributos){
            this.saldo = this.saldo - (valor+tributos);
            System.out.println("Foi sacado "+valor+" da sua conta com os tributos de : "+String.format("%.2f",tributos));
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

    @Override
    public void imprimeTributos(double valor){
        System.out.println("O total de Tributos deu : "+calculaTributos(valor));
    }

    @Override
    public double calculaTributos(double valor){
        return valor;
    }

    
    
}