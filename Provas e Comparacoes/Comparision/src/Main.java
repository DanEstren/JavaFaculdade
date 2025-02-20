import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {

    static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Aluno.cadastroDeAlunos(alunos);
                    break;
                case 2:
                    Professor.cadastroDeProfessores(professores, disciplinas);
                    break;
                case 3:
                    Disciplina.cadastrodeDisciplinas(disciplinas);
                    break;
                case 4:
                    Turma.cadastrarTurma(disciplinas, professores, turmas);
                    break; 
                case 5:
                    Nota.adicionarNota(alunos, disciplinas);
                    break;
                case 6:
                    Aluno.listarAlunos();
                    break;
                case 7:
                    Professor.listarProfessores();
                    break;
                case 8:
                    Disciplina.listarDisciplinas();
                    break;
                case 9:
                    Turma.listarTurmas();
                    break;
                case 10:
                    Nota.media();
                    break;
                case 11:
                    Aluno.quantidadeAlunos();
                case 12:
                    Nota.alunoComMaiorNota();
                    break;
                case 13:
                    Disciplina.listarAlunosPorDisciplina();
                    break;
                case 14:
                    Turma.listarProfessoresETurmas();
                    break;
                case 15:
                System.out.println("Saindo...");
                   break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 15);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=========================");
        System.out.println("      MENU PRINCIPAL     ");
        System.out.println("=========================");
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Professor");
        System.out.println("3 - Cadastrar Disciplina");
        System.out.println("4 - Cadastrar Turma");
        System.out.println("5 - Inserir Nota");
        System.out.println("6 - Relatório Alunos");
        System.out.println("7 - Relatório Professores");
        System.out.println("8 - Relatório Disciplinas");
        System.out.println("9 - Relatório Turmas");
        System.out.println("10 - Relatório de Aluno x Notas x Média");
        System.out.println("11 - Quantidade de Alunos Cadastrados");
        System.out.println("12 - Nome do Aluno com a Maior Nota");
        System.out.println("13 - Listar Alunos de uma Determinada Disciplina");
        System.out.println("14 - Listar as turmas que estão associadas a um determinado professor");
        System.out.println("15 - Sair");
    }
        
}
