import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        String nome,curso,formacao;
        int idade,quantidade,opcao = 7;

        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        ArrayList<Professor> listaProfessores = new ArrayList<>();


        while(opcao  != 0){
        System.out.print("\t---Sistem de Cadastro de Alunos---\n\nInsira se deseja inserir Aluno ou Professor\n\t1-Aluno\n\t2-Professor\n\t3-Imprimir lista Alunos\n\t4-Imprimir lista Professores\n\t0- Sair\n");
        opcao = teclado.nextInt();
            

        if(opcao == 1){
            System.out.print("Quantos Alunos deseja cadastrar? : ");
            quantidade = teclado.nextInt();


            for (int i = 0;i < quantidade;i++){
                System.out.print("Insira o Nome do Aluno "+(i+1)+" : ");
                nome = teclado.next();
                System.out.print("Insira a Idade do Aluno "+(i+1)+" : ");
                idade = teclado.nextInt();
                System.out.print("Insira o Curso do Aluno "+(i+1)+" : ");
                curso = teclado.next();

                System.out.println();

                Aluno objeto1 = new Aluno(nome,idade,curso);

                listaAlunos.add(objeto1);
            }
            

        }
        else if(opcao == 2){
            System.out.print("Quantos Professores deseja cadastrar? : ");
            quantidade = teclado.nextInt();


            for (int i = 0;i < quantidade;i++){
            
                System.out.print("Insira o Nome do Professor "+(i+1)+" : ");
                nome = teclado.next();
                System.out.print("Insira a Idade do Professor "+(i+1)+" : ");
                idade = teclado.nextInt();
                System.out.print("Insira o Formacao do Professor "+(i+1)+" : ");
                formacao = teclado.next();

                System.out.println();

                Professor objeto2 = new Professor(nome,idade,formacao);

                listaProfessores.add(objeto2);
            }
        }
        else if (opcao == 3) {
            if (listaAlunos.isEmpty()) {
                System.out.println("Não há alunos cadastrados!\n");
            } else {
                System.out.println("Lista de Alunos:");
                int i = 0;
                for (Aluno objeto1 : listaAlunos) {
                    i++;
                    System.out.println("Nome do aluno "+i+" : "+objeto1.nome);
                    System.out.println("Idade do aluno "+i+" : "+objeto1.idade);
                    System.out.println("Curso do aluno "+i+" : "+objeto1.retornarCurso());
                    
                }
            }
            
        }
        else if (opcao == 4) {
            if (listaProfessores.isEmpty()) {
                System.out.println("Não há professores cadastrados!\n");
            } else {
                System.out.println("Lista de Professores:");
                int i = 0;
                for (Professor objeto2 : listaProfessores) {
                    i++;
                    System.out.println("Nome do professor "+i+" : "+objeto2.nome);
                    System.out.println("Idade do professor "+i+" : "+objeto2.idade);
                    System.out.println("Formacao do professor "+i+" : "+objeto2.retornarFormacao());
                    
                    System.out.println();
                }
            }

        }
        else{
            System.out.println("Tente Inserir um valor valido!\n");
        }

        }

        teclado.close();

    }
}
