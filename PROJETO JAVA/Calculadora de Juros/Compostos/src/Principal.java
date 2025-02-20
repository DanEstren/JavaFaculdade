import java.util.Scanner;
public class Principal{


    public static void main(String[] args) {
        double juros;
        int tempo;
        double capital;
        double aportes;
        int  opcao2;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Dica: a Taxa Selic atualmente de 10.75%\nAo ano descontando os impostos e a inflacao, isso deve dar em torno de 5% ao ano");
        System.out.println("Calculadora de Juros");
        System.out.println("Opcao 1 = Simples\nOpcao 2 = Composto");
        int opcao = teclado.nextInt();

        if(opcao == 1){

            System.out.println("Insira o Capital Inicial");
            capital = teclado.nextDouble();

            System.out.println("Insira o Juros anual, ps: ja descontado os impostos e a inflacao");
            juros = teclado.nextDouble();

            System.out.println("Insira a quantidade em anos que deseja investir");
            tempo = teclado.nextInt();

            System.out.println("Deseja aportar a cada mês?\n1-Sim\n2-Nao desejo aportar");
            opcao2 = teclado.nextInt();

            if (opcao2 == 1){

                System.out.println("Quanto deseja investir por mes?");
                aportes = teclado.nextDouble();


            }
            else if (opcao2 ==2){
                aportes = 0;

            }
            else{
                aportes = 0;
                System.out.println("Insercao invalida continuando sem aportes");
            }

            Simples juros1 = new Simples(juros,tempo,capital,aportes);

            System.out.println("Com a taxa de juros anual de "+juros+"\nCapital inicial de "+capital+" durante "+tempo+" anos"+"\nAportando por mes "+aportes);
            System.out.println("Resultado foi de: "+juros1.FuncaoSimples());
        }
        else if(opcao == 2){
            System.out.println("Insira o Capital Inicial");
            capital = teclado.nextDouble();

            System.out.println("Insira o Juros anual, ps: ja descontado os impostos e a inflacao");
            juros = teclado.nextDouble();

            System.out.println("Insira a quantidade em anos que deseja investir");
            tempo = teclado.nextInt();

            System.out.println("Deseja aportar a cada mês?\n1-Sim\n2-Nao desejo aportar");
            opcao2 = teclado.nextInt();

            if (opcao2 == 1){

                System.out.println("Quanto deseja investir por mes?");
                aportes = teclado.nextDouble();


            }
            else if (opcao2 ==2){
                aportes = 0;

            }
            else{
                aportes = 0;
                System.out.println("Insercao invalida continuando sem aportes");
            }

            Compostos juros2 = new Compostos(juros,tempo,capital,aportes);

            System.out.println("Com a taxa de juros anual de "+juros+"\nCapital inicial de "+capital+" durante "+tempo+" anos"+"\nAportando por mes "+aportes);
            System.out.println("Resultado foi de: "+juros2.FuncaoComposta());
        
        }

        else{
            System.out.println("Erro escolha um valor valido!");
        }

        teclado.close();

    }
}