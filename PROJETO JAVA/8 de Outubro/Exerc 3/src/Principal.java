import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

       List<ContaPoupanca> contasPoupancas = new ArrayList<>();
       List<ContaCorrente> contasCorrentes = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);

        int opcao = 7;

        SeguroDeVida tributo = new SeguroDeVida();

        do{
            System.out.println("\n\n\n");
            System.out.println("\t---Menu---");
            System.out.println("Selecione o tipo de conta desejada");
            System.out.println("1-Adicionar novas contas");
            System.out.println("2-Depositar");
            System.out.println("3-Sacar");
            System.out.println("4-Exibir contas");
            System.out.println("0-Sair");
            opcao = teclado.nextInt();

            //Adicionar novas contas
            if (opcao == 1){
                System.out.println("\tSelecione o tipo da conta");
                System.out.println("1-Conta Poupanca");
                System.out.println("2-Conta Corrente");
                int opcao2 = teclado.nextInt();
                
                if (opcao2 == 1){
                    System.out.println("Saldo de quantas pessoas deseja adicionar? ");
                    int opcao3 = teclado.nextInt();
    
                    for (int i = 0; i<opcao3;i++){
                        
                        System.out.println("Insira o Saldo da Conta Poupanca "+(i+1)+" : ");
                        double saldo1 = teclado.nextDouble();
        
                        contasPoupancas.add(new ContaPoupanca(saldo1));
                    }
    
                }
                else if (opcao2 == 2){
                    System.out.println("Saldo de quantas pessoas deseja adicionar? ");
                    int opcao3 = teclado.nextInt();
    
                    for (int i = 0; i<opcao3;i++){
                        
                        System.out.println("Insira o Saldo da Conta Corrente "+(i+1)+" : ");
                        double saldo1 = teclado.nextDouble();
        
                        contasCorrentes.add(new ContaCorrente(saldo1));
                    }
    
                }
    
                else{
                    System.out.println("Tente Insirir um tipo de conta valido!");
                }

            }
            //Depositar
            else if (opcao == 2){
                System.out.println("\tSelecione o tipo da conta");
                System.out.println("\t1-Conta Poupanca");
                System.out.println("\t2-Conta Corrente");
                int opcao2 = teclado.nextInt();

                if (opcao2 == 1){
                    if (contasPoupancas.size() <= 0){
                        System.out.println("Sem valores para leitura!");
                    }

                    else{

                        System.out.println("Seleciona a conta que deseja depositar :");
                        int opcao3 = teclado.nextInt() - 1;
                        
                        if (contasPoupancas.size() > opcao3 && contasPoupancas.get(opcao3) != null){
                            System.out.println("Quanto deseja adicionar a sua conta?");
                            double opcao4 = teclado.nextDouble();

                            contasPoupancas.get(opcao3).depositar(opcao4);
                        }

                        else{
                            System.out.println("Conta Invalida!");
                        }

                        
                        
                    }

                }

                else if (opcao2 == 2){

                    if (contasCorrentes.size() <= 0){
                        System.out.println("Sem valores para leitura!");
                    }

                    else{

                        System.out.println("Seleciona a conta que deseja depositar :");
                        int opcao3 = teclado.nextInt() - 1;
                                               
                        if (contasCorrentes.size() > opcao3 && contasCorrentes.get(opcao3) != null){
                            System.out.println("Quanto deseja adicionar a sua conta?");
                            double opcao4 = teclado.nextDouble();

                            contasCorrentes.get(opcao3).depositar(opcao4);
                        }

                        else{
                            System.out.println("Conta Invalida!");
                        }
                        
                    }


                }

                else{

                    System.out.println("Insira uma opcao valida de tipo de conta!");
                }

            }

            //Sacar
            else if (opcao == 3){
                System.out.println("\tSelecione o tipo da conta");
                System.out.println("\t1-Conta Poupanca");
                System.out.println("\t2-Conta Corrente");
                int opcao2 = teclado.nextInt();

                if (opcao2 == 1){
                    if (contasPoupancas.size() <= 0){
                        System.out.println("Sem valores para leitura!");
                    }

                    else{

                        System.out.println("Seleciona a conta que deseja sacar :");
                        int opcao3 = teclado.nextInt() - 1;
                                               
                        if (contasPoupancas.size() >= opcao3 && contasPoupancas.get(opcao3) != null){
                            System.out.println("Quanto deseja sacar da sua conta?");
                            double opcao4 = teclado.nextDouble();

                            if (contasPoupancas.get(opcao3).getSaldo() >= opcao4){

                                contasPoupancas.get(opcao3).sacar(opcao4, 0);
                            }

                            
                        }

                        else{
                            System.out.println("Conta Invalida!");
                        }
                        
                    }

                }

                else if (opcao2 == 2){
                    if (contasCorrentes.size() <= 0){
                        System.out.println("Sem valores para leitura!");
                    }

                    else{

                        System.out.println("Seleciona a conta que deseja depositar :");
                        int opcao3 = teclado.nextInt() - 1;
                                                
                        if (contasCorrentes.size() >= opcao3 && contasCorrentes.get(opcao3) != null){
                            System.out.println("Quanto deseja sacar da sua conta?");
                            double opcao4 = teclado.nextDouble();

                            if (contasCorrentes.get(opcao3).getSaldo() >= (opcao3+tributo.calculaTributos(opcao4))){

                                contasCorrentes.get(opcao3).sacar(opcao4, tributo.calculaTributos(opcao4));
                                
                            }

                           
                        }

                        else{
                            System.out.println("Conta Invalida!");
                        }

                        
                    }

                }

                else{

                    System.out.println("Insira uma opcao valida de tipo de conta!");
                }

            }
            //Exibir contas
            else if (opcao == 4){
                System.out.println("\tSelecione o tipo da conta");
                System.out.println("\t1-Conta Poupanca");
                System.out.println("\t2-Conta Corrente");
                int opcao2 = teclado.nextInt();

                if (opcao2 == 1){
                    if (contasPoupancas.size() <= 0){
                        System.out.println("Sem valores para leitura!");
                    }

                    else{

                        int e = 0;
                        for (ContaPoupanca contaspou : contasPoupancas){
                            e ++;
                            System.out.println("Conta "+e+" valor : "+ String.format("%.2f", contaspou.getSaldo()));
                        }
                        
                    }
                }

                else if (opcao2 == 2){

                    if (contasCorrentes.size() <= 0){
                        System.out.println("Sem valores para leitura!");
                    }

                    else{

                        int e = 0;
                        for (ContaCorrente contascorr : contasCorrentes){
                            e ++;
                            System.out.println("Conta "+e+" valor : "+ contascorr.getSaldo());
                        }
                        
                    }
                }

                else{

                    System.out.println("Insira uma opcao valida de tipo de conta!");
                }

            }

            else if (opcao == 0 ){

            }

            else{
                System.out.println("Insira uma opcao de Menu valida!");
            }
        } while (opcao != 0);

      

        teclado.close();

    }
    
}
