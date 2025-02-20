import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        criarPastaArquivos();
        
        Professor.carregarProfessores(professores);
        Disciplina.carregarDisciplinas(disciplinas, professores);
        Aluno.carregarAlunos(alunos, disciplinas); 
        Turma.carregarTurmas(turmas, disciplinas, professores, alunos);
        
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    Aluno.cadastrarAlunoNoMain(alunos);  //Aluno puxa a função que instancia e puxa a castrar na classe aluno
                    break;
                case 2:
                    Professor.cadastrarProfessorNoMain(professores, disciplinas); //Cadastra os Professores, puxa outra função dento da classe Professor
                    break;
                case 3:
                    cadastrarDisciplina(); //Cadastra as disciplinas
                    break;
                case 4:
                    Turma.cadastrarTurma(disciplinas,professores,alunos,turmas); //Cadastra as turmas 
                    break; 
                case 5:
                    adicionarNota(); //Adiciona nota para determinada disciplina, (revisar mas acho que está ok)
                    break;
                case 6:
                    listarAlunos(); //lista os alunos cadastrados,e os que tiverem nota são exibidos
                    break;
                case 7:
                    listarProfessores(); //lista os professores cadastrados
                    break;
                case 8:
                    listarDisciplinas(); //lista as disciplinas cadastradas
                    break;
                case 9:
                    listarTurmas(); //lista as turmas cadastradas
                    break;
                case 10:
                    relatorioAlunosNotasMedia(); //Funciona com mais disciplinas e notas atribuidas
                    break;
                case 11:
                    quantidadeAlunosCadastrados(); //FUNCIONA
                    break;
                case 12:
                    nomeAlunoMaiorNota(); //FUNCIONA
                    break;
                case 13:
                    listarAlunosDeUmaDisciplina(); //FUNCIONA
                    break;
                case 14:
                    listarTurmasDoProfessor(); //FUNCIONA
                    break;
                case 15:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 15);

        Aluno.salvarAlunos(alunos);
        Professor.salvarProfessores(professores);
        Disciplina.salvarDisciplinas(disciplinas);
        Turma.salvarTurmas(turmas);

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
        System.out.println("6 - Listar Alunos");
        System.out.println("7 - Listar Professores");
        System.out.println("8 - Listar Disciplinas");
        System.out.println("9 - Listar Turmas");
        System.out.println("10 - Relatório de Aluno x Notas x Média");
        System.out.println("11 - Quantidade de Alunos Cadastrados");
        System.out.println("12 - Nome do Aluno com a Maior Nota");
        System.out.println("13 - Listar Alunos de uma Determinada Disciplina");
        System.out.println("14 - Listar as turmas que estão associadas a um determinado professor");
        System.out.println("15 - Sair");
    }




    private static void cadastrarDisciplina() {
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();

        int cargaHoraria;
        while (true) {
            System.out.print("Carga horária (em horas): ");
            try {
                cargaHoraria = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break; // Exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Carga horária inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();

        // Create the new discipline and add it to the list of disciplines
        Disciplina novaDisciplina = new Disciplina(nome, cargaHoraria, codigo);
        disciplinas.add(novaDisciplina);

        System.out.println("Disciplina cadastrada com sucesso: " + novaDisciplina.getNome());
    }

    
    private static void adicionarNota() {
        Scanner scanner = new Scanner(System.in);

        // Verify if there are registered students and disciplines
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado. Cadastre um aluno primeiro.");
            scanner.close();
            return;
        }
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada. Cadastre uma disciplina primeiro.");
            scanner.close();
            return;
        }

        // Display the list of students and ask the user to select one
        System.out.println("Escolha o número do aluno:");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i + 1) + ". " + alunos.get(i).getNome());
        }

        int alunoIndex;
        while (true) {
            System.out.print("Número do aluno: ");
            alunoIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline
            if (alunoIndex >= 0 && alunoIndex < alunos.size()) {
                break;
            } else {
                System.out.println("Opção inválida. Por favor, escolha um número da lista.");
            }
        }
        Aluno alunoSelecionado = alunos.get(alunoIndex);

        // Display the list of disciplines and ask the user to select one
        System.out.println("Escolha o número da disciplina:");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
        }

        int disciplinaIndex;
        while (true) {
            System.out.print("Número da disciplina: ");
            disciplinaIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline
            if (disciplinaIndex >= 0 && disciplinaIndex < disciplinas.size()) {
                break;
            } else {
                System.out.println("Opção inválida. Por favor, escolha um número da lista.");
            }
        }
        Disciplina disciplinaSelecionada = disciplinas.get(disciplinaIndex);

        // Enter the grade value
        double valorNota;
        while (true) {
            System.out.print("Informe o valor da nota (0-10): ");
            try {
                valorNota = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (valorNota >= 0 && valorNota <= 10) {
                    break; // Valid grade
                } else {
                    System.out.println("Valor inválido. Insira uma nota entre 0 e 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Enter the date of the note
        System.out.print("Informe a data da nota (dd/mm/yyyy): ");
        String dataNota = scanner.nextLine();

        // Create and add the note to the student
        Nota novaNota = new Nota(alunoSelecionado, disciplinaSelecionada, valorNota, dataNota);
        alunoSelecionado.getNotas().add(novaNota);
       
        System.out.println("Nota adicionada com sucesso para o aluno " + alunoSelecionado.getNome() + " na disciplina " + disciplinaSelecionada.getNome());
    }


    private static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
        } else {
            System.out.println("Lista de Alunos:");
            for (int i = 0; i < alunos.size(); i++) {
                Aluno aluno = alunos.get(i);
                System.out.println((i + 1) + ". " + aluno.getNome() + " - Matrícula: " + aluno.getMatricula() + " - Ano de Ingresso: " + aluno.getAnoIngresso());
                
                // Verificar se o aluno tem notas
                if (!aluno.getNotas().isEmpty()) {
                    System.out.print(" - Notas: ");
                    // Imprimir as notas do aluno
                    for (Nota nota : aluno.getNotas()) {
                        // Aqui podemos mostrar a nota e a disciplina associada
                        System.out.print(nota.getValor() + " - ID Matéria: (" + nota.getDisciplina().getCodigo() + ") ");
                    }
                    System.out.println(); // Nova linha após as notas
                } else {
                    System.out.println(" - Nenhuma nota cadastrada.");
                }
            }
        }
    }
    

    private static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados.");
        } else {
            System.out.println("Lista de professores:");
            for (int i = 0; i < professores.size(); i++) {
                Professor professor = professores.get(i);
                System.out.println((i + 1) + ". " + professor.getNome() + " - Matéria: " + professor.getAreaDeFormacao() + " - Email: " + professor.getEmail()+ " - Ano de Admissao: " + professor.getAnoDeAdmissao());
            }
        }
    }

    private static void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas.");
        } else {
            System.out.println("Lista de Disciplinas:");
            for (int i = 0; i < disciplinas.size(); i++) {
                Disciplina disciplina = disciplinas.get(i);
                System.out.println((i + 1) + ". " + disciplina.getNome() + " - Código: " + disciplina.getCodigo());
            }
        }
    }

    private static void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Não há turmas cadastradas.");
        } else {
            System.out.println("Lista de Turmas:");
            for (int i = 0; i < turmas.size(); i++) {
                Turma turma = turmas.get(i);
                System.out.println((i + 1) + ". Código da Turma: " + turma.getCodigo() +
                        " - Disciplina: " + turma.getDisciplina().getNome() +
                        " - Professor: " + turma.getProfessor().getNome() +
                        " - Ano Letivo: " + turma.getAnoLetivo() +
                        " - Quantidade de Alunos: " + turma.getAlunos().size());
    
                // Exibindo os nomes dos alunos
                System.out.print("   Alunos: ");
                if (turma.getAlunos().isEmpty()) {
                    System.out.println("Nenhum aluno cadastrado.");
                } else {
                    for (Aluno aluno : turma.getAlunos()) {
                        System.out.print(aluno.getNome() + " ");
                    }
                    System.out.println(); // Quebra de linha após listar todos os alunos
                }
            }
        }
    }
    

    private static void relatorioAlunosNotasMedia() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }
    
        // Lista os alunos para o usuário escolher
        System.out.println("Escolha um aluno para ver o relatório de notas e média:");
    
        // Exibe todos os alunos para o usuário escolher
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i + 1) + ". " + alunos.get(i).getNome() + " - Matrícula: " + alunos.get(i).getMatricula());
        }
    
        int alunoIndex;
        while (true) {
            System.out.print("Número do aluno: ");
            alunoIndex = scanner.nextInt() - 1; // Decrementa 1 para o índice correto
            scanner.nextLine(); // Consumir o newline
            if (alunoIndex >= 0 && alunoIndex < alunos.size()) {
                break;
            } else {
                System.out.println("Opção inválida. Por favor, escolha um número da lista.");
            }
        }
    
        Aluno alunoSelecionado = alunos.get(alunoIndex);
        System.out.println("Relatório de notas e média para o aluno: " + alunoSelecionado.getNome());
    
        // Verifica se o aluno tem notas
        if (alunoSelecionado.getNotas().isEmpty()) {
            System.out.println("  Nenhuma nota registrada.");
        } else {
            double totalNotas = 0;
            int contadorNotas = 0; // Contador de notas válidas
    
            // Exibe todas as notas válidas do aluno
            for (Nota nota : alunoSelecionado.getNotas()) {
                if (nota.getValor() >= 0) { // Verifica se a nota é válida (não negativa)
                    totalNotas += nota.getValor();
                    contadorNotas++;
                    System.out.println("  Disciplina: " + nota.getDisciplina().getNome() +
                            " - Nota: " + nota.getValor() + " - Data: " + nota.getData());
                } else {
                    // Se a nota for inválida (menor que 0), exibe um aviso
                    System.out.println("  Aviso: Nota inválida para a disciplina " + nota.getDisciplina().getNome());
                }
            }
    
            // Verifica se há notas válidas para calcular a média
            if (contadorNotas > 0) {
                double media = totalNotas / contadorNotas;
                System.out.println("  Média: " + String.format("%.2f", media));  // Exibe média com 2 casas decimais
            } else {
                // Se não houver notas válidas, avisa que a média não pode ser calculada
                System.out.println("  Média: Não há notas válidas para calcular a média.");
            }
        }
    }
    

    private static void quantidadeAlunosCadastrados() {
        System.out.println("Quantidade de alunos cadastrados: " + alunos.size());
    }

    private static void nomeAlunoMaiorNota() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }

        Aluno alunoMaiorNota = null;
        double maiorNota = -1;

        for (Aluno aluno : alunos) {
            for (Nota nota : aluno.getNotas()) {
                if (nota.getValor() > maiorNota) {
                    maiorNota = nota.getValor();
                    alunoMaiorNota = aluno;
                }
            }
        }

        if (alunoMaiorNota == null) {
            System.out.println("Nenhuma nota registrada.");
        } else {
            System.out.println("Aluno com a maior nota: " + alunoMaiorNota.getNome() +
                    " - Nota: " + maiorNota);
        }
    }

    private static void listarAlunosDeUmaDisciplina() {
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas.");
            return;
        }
    
        // Exibe a lista de disciplinas
        System.out.println("Lista de disciplinas:");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
        }
    
        // Solicita ao usuário o nome da disciplina
        String nomeDisciplina;
        Disciplina disciplinaSelecionada = null;
    
        while (true) {
            System.out.print("Digite o nome da disciplina: ");
            nomeDisciplina = scanner.nextLine().trim();  // Captura o nome da disciplina e remove espaços extras
    
            // Procura a disciplina pelo nome
            for (Disciplina disciplina : disciplinas) {
                if (disciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
                    disciplinaSelecionada = disciplina;
                    break;
                }
            }
    
            // Se a disciplina foi encontrada, sai do loop
            if (disciplinaSelecionada != null) {
                break;
            } else {
                System.out.println("Disciplina não encontrada. Tente novamente.");
            }
        }
    
        // Flag para verificar se há alunos na disciplina
        boolean encontrouAluno = false;
    
        System.out.println("Verificando se há Alunos na disciplina " + disciplinaSelecionada.getNome() + ":");
        for (Aluno aluno : alunos) {
            for (Nota nota : aluno.getNotas()) {
                if (nota.getDisciplina().equals(disciplinaSelecionada)) {
                    System.out.println("  " + aluno.getNome() + " - Matrícula: " + aluno.getMatricula());
                    encontrouAluno = true;  // Encontrou ao menos um aluno
                    break; // Exibe cada aluno uma única vez
                }
            }
        }
    
        // Se nenhum aluno foi encontrado para a disciplina
        if (!encontrouAluno) {
            System.out.println("Não há alunos cadastrados nesta disciplina.");
        }
    }
    
    

    private static void listarTurmasDoProfessor() {
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados.");
            return;
        }
    
        // Exibe a lista de professores
        System.out.println("Lista de professores:");
        for (int i = 0; i < professores.size(); i++) {
            Professor professor = professores.get(i);
            System.out.println((i + 1) + ". " + professor.getNome() + " - Matéria: " + professor.getAreaDeFormacao() + " - Email: " + professor.getEmail());
        }
    
        // Solicita ao usuário o nome do professor
        String nomeProfessor;
        Professor professorSelecionado = null;
    
        while (true) {
            System.out.print("Digite o nome do professor: ");
            nomeProfessor = scanner.nextLine();
    
            // Verifica se existe um professor com o nome digitado
            for (Professor professor : professores) {
                if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                    professorSelecionado = professor;
                    break;
                }
            }
    
            if (professorSelecionado != null) {
                break;  // Professor encontrado
            } else {
                System.out.println("Nenhum professor encontrado com esse nome. Tente novamente.");
            }
        }
    
        // Flag para verificar se o professor tem turmas
        boolean encontrouTurmas = false;
    
        // Exibe as turmas sob a responsabilidade do professor
        System.out.println("Turmas sob a responsabilidade do professor " + professorSelecionado.getNome() + ":");
    
        for (Turma turma : turmas) {
            // Verifica se o professor está associado à turma
            if (turma.getProfessor().equals(professorSelecionado)) {
                System.out.println("  Código da Turma: " + turma.getCodigo() + 
                                   " - Disciplina: " + turma.getDisciplina().getNome() + 
                                   " - Ano Letivo: " + turma.getAnoLetivo());
                System.out.print("  Alunos: ");
                if (turma.getAlunos().isEmpty()) {
                    System.out.println("Nenhum aluno cadastrado.");
                } else {
                    for (Aluno aluno : turma.getAlunos()) {
                        System.out.print(aluno.getNome() + " ");
                    }
                    System.out.println(); // Quebra de linha após listar todos os alunos
                }
                encontrouTurmas = true;
            }
        }
    
        // Caso o professor não tenha turmas
        if (!encontrouTurmas) {
            System.out.println("  Nenhuma turma encontrada para o professor " + professorSelecionado.getNome() + ".");
        }
    }
    
    
    
    
    
    public static void criarPastaArquivos() {
    // Caminho relativo para a pasta "arquivos"
    File pasta = new File("arquivos");
    
    // Verifica se a pasta existe, se não, cria a pasta
    if (!pasta.exists()) {
        try {
            if (pasta.mkdir()) {
                System.out.println("Pasta 'arquivos' criada com sucesso.");
            } else {
                System.out.println("Falha ao criar a pasta 'arquivos'.");
            }
        } catch (SecurityException e) {
            System.out.println("Erro ao tentar criar a pasta: " + e.getMessage());
        }
    }
}

    

}
