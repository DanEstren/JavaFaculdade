public class Simples extends Atributos{

    Simples(double juros,int tempo,double capital, double aportes){
        super(juros,tempo,capital,aportes);
    }


    double FuncaoSimples(){
        double resultado;
        juros = juros/100;
        try{
            if(aportes!=0){
                resultado = capital*(tempo*juros)+((tempo*12)*aportes);
                return resultado+capital;
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
