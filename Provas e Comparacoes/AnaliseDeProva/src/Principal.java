import java.util.Scanner;

public class Principal 
{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) 
    {
        DadosSistema objDadosSistema = new DadosSistema();
        objDadosSistema.AtualizarDados();
        int opcaoMenu = 0;
        do 
        {
            opcaoMenu = Menu();
            if (opcaoMenu < 1 || opcaoMenu > 15) 
            {
                System.out.println("\nDigite uma opcao valida por favor!\n");
            }
            switch (opcaoMenu) {
                case 1:
                    try 
                    {
                        Aluno objAluno = new Aluno();
                        objDadosSistema.getArrayAlunos().add(objAluno.Cadastro(objAluno));
                    } catch (Exception e) 
                    {
                        System.out.println("Falha ao cadastrar aluno");
                    }
                    break;
                case 2:
                    try 
                    {
                        Professor objProfessor = new Professor();
                        objDadosSistema.getArrayProfessores().add(objProfessor.Cadastro(objProfessor));
                    } catch (Exception e) {
                        System.out.println("Falha ao cadastrar professor");
                    }
                    break;
                case 3:
                    try 
                    {
                        Disciplina objDisciplina = new Disciplina();
                        objDadosSistema.getArrayDisciplinas().add(objDisciplina.Cadastro(objDisciplina));
                    } catch (Exception e) 
                    {
                        System.out.println("Falha ao cadastrar disciplina!");
                    }
                    break;
                case 4:
                    break;
                    
                case 6:
                    System.out.println("\n\n-----Alunos-----\n");
                    for (Aluno aluno : objDadosSistema.getArrayAlunos()) 
                    {
                        System.out.println("\n*******************");
                        System.out.println("Matricula: " + aluno.getMatricula());
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("Data de nascimento: " + aluno.getDataNascimento());
                        System.out.println("Telefone: " + aluno.getTelefone());
                        System.out.println("Codigo da turma: " + aluno.getTurma().getCodigo());
                        System.out.println("Endereco: " + aluno.getEndereco().getEnderecoCompleto());
                        System.out.println("Ano de ingresso: " + aluno.getAnoIngresso());
                        System.out.println("*******************\n");
                    }
                    break;
                case 7: 
                    System.out.println("\n\n-----Professor-----\n");
                    for (Professor professor : objDadosSistema.getArrayProfessores()) 
                    {
                        System.out.println("\n*******************");
                        System.out.println("Nome: " + professor.getNome());
                        System.out.println("Data de nascimento: " + professor.getDataNascimento());
                        System.out.println("Telefone: " + professor.getTelefone());
                        System.out.println("Endereco: " + professor.getEndereco().getEnderecoCompleto());
                        System.out.println("Email: " + professor.getEmail());
                        System.out.println("Area de formacao: " + professor.getAreaDeFormacao());
                        System.out.println("Ano de admissao: " + professor.getAnoDeAdmissao());
                        System.out.println("*******************\n");
                    }
                    break;
                default:
                    break;
            }
        } while (opcaoMenu != 15);
        
        
        
        

        /*for (String string : objDadosSistema.getArrayTextoArquivo()) \\mostrar todo o arquivo
        {
            System.out.println(string);
        }*/
    }

    public static int Menu()
    {
        int escolhaMenu = 0;
        do 
        {
            System.out.println("-----MENU-----");
            System.out.println("1- Cadastrar aluno");
            System.out.println("2- Cadastrar professor");
            System.out.println("3- Cadastrar disciplina");
            System.out.println("4- Cadastrar Turma");
            System.out.println("5- Inserir nota");
            System.out.println("6- Relatorio alunos");
            System.out.println("7- Relatorio professores");
            System.out.println("8- Relatorio disciplinas");
            System.out.println("9- Relatorio turmas");
            System.out.println("10- Relatorio de aluno x Notas x Media");
            System.out.println("11- Quantidade de alunos cadastrados");
            System.out.println("12- Nome do aluno que possui a maior nota");
            System.out.println("13- Listar os alunos de uma determinada disciplina");
            System.out.println("14- Listar as turmas que estao associadas a um determinado professor");
            System.out.println("15- Sair");
            System.out.println("Escolha uma opcao: ");
            try 
            {
                escolhaMenu = teclado.nextInt();
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println("Valor digitado invalido!");
            }
        } while (escolhaMenu < 1 || escolhaMenu > 15);
        return escolhaMenu;
    }
}