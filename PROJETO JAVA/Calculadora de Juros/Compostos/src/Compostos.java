public class Compostos extends Atributos{

    
    Compostos(double juros,int tempo,double capital, double aportes){
        super(juros,tempo,capital,aportes);
    }


    double FuncaoComposta(){
        double resultado;
        double juroscomposto;
        int tempo2;
        juros = juros/100;
        try{
            if(aportes!=0){
                juros = 1+juros;
                juroscomposto = juros;
                tempo2 = tempo*12;
                for(int i = 0; i < tempo;i++){
                    juroscomposto = juros*juroscomposto;
                }
                resultado = (capital+(tempo2*aportes))*juroscomposto;
                return resultado;
            }
            else{
                resultado = capital*(tempo*juros);
                return resultado+capital;
            }

        }

        catch (Exception e) {
            System.out.println("Ocorreu um erro ao calcular o valor final: " + e.getMessage());
            return 0; // Ou lançar uma nova exceção mais específica
        }

        
    }
    
}
