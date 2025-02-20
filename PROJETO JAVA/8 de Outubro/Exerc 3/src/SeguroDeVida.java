public class SeguroDeVida implements Tributavel {

    private double Seguro = 42;
    
    @Override
    public double calculaTributos(double valor){

    return ((valor*0.01) + Seguro);
    
}

    @Override
    public void imprimeTributos(double valor){
        System.out.println("O total de Tributos deu : "+calculaTributos(valor));
    }

   
}
