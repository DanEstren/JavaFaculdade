import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turma {
    private int codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;
    private int anoLetivo;

    public Turma(int codigo, Disciplina disciplina, Professor professor, Aluno aluno, int anoLetivo) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.anoLetivo = anoLetivo;
        this.alunos = new ArrayList<>(); // Certifique-se de que a lista é inicializada
        if (aluno != null) {
            this.alunos.add(aluno); // Adiciona o aluno inicial se fornecido
        }
    }
    

    public int getCodigo() {
        return codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() { //necessario ver como vou usar esse Array
        return alunos;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public static void cadastrarTurma(List<Disciplina> disciplinas, List<Professor> professores, List<Aluno> alunos, List<Turma> turmas) {
        Scanner scanner = new Scanner(System.in);

        // Verificar se há disciplinas cadastradas
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas. Cadastre uma disciplina antes de cadastrar uma turma.");
            return;
        }

        // Verificar se há professores cadastrados
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados. Cadastre um professor antes de cadastrar uma turma.");
            return;
        }

        // Verificar se há alunos cadastrados
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados. Cadastre um aluno antes de cadastrar uma turma.");
            return;
        }

        System.out.println("==== Cadastro de Turma ====");

        // Exibir as disciplinas cadastradas para o usuário escolher
        System.out.println("Disciplinas disponíveis:");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + " - " + disciplinas.get(i).getNome());
        }
        System.out.print("Escolha uma disciplina (número): ");
        int disciplinaIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o newline

        if (disciplinaIndex < 0 || disciplinaIndex >= disciplinas.size()) {
            System.out.println("Opção inválida. A turma não foi criada.");
            return;
        }
        Disciplina disciplinaEscolhida = disciplinas.get(disciplinaIndex);

        // Exibir os professores cadastrados para o usuário escolher
        System.out.println("Professores disponíveis:");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println((i + 1) + " - " + professores.get(i).getNome());
        }
        System.out.print("Escolha um professor (número): ");
        int professorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o newline

        if (professorIndex < 0 || professorIndex >= professores.size()) {
            System.out.println("Opção inválida. A turma não foi criada.");
            return;
        }
        Professor professorEscolhido = professores.get(professorIndex);

        // Exibir os alunos cadastrados
        System.out.println("Alunos disponíveis:");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i + 1) + " - " + alunos.get(i).getNome());
        }
        System.out.print("Escolha um aluno (número): ");
        int alunoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir o newline

        if (alunoIndex < 0 || alunoIndex >= alunos.size()) {
            System.out.println("Opção inválida. A turma não foi criada.");
            return;
        }
        Aluno alunoEscolhido = alunos.get(alunoIndex);

        // Solicitar o código da turma (garantir que seja numérico)
        System.out.print("Digite o código da turma (numérico): ");
        int codigoTurma = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline

        // Solicitar o ano letivo da turma
        System.out.print("Digite o ano letivo da turma: ");
        int anoLetivo = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline

        // Criar e adicionar a turma
        Turma novaTurma = new Turma(codigoTurma, disciplinaEscolhida, professorEscolhido, alunoEscolhido, anoLetivo);
        turmas.add(novaTurma); // Adiciona a turma à lista
        System.out.println("Turma cadastrada com sucesso: " + codigoTurma
                + " - Disciplina: " + disciplinaEscolhida.getNome()
                + " - Professor: " + professorEscolhido.getNome()
                + " - Aluno: " + alunoEscolhido.getNome());
    }
    

    public static void salvarTurmas(List<Turma> turmas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("arquivos/turmas.txt"))) {
            for (Turma turma : turmas) {
                // Salvando informações básicas da turma
                writer.write(turma.getCodigo() + ","
                             + turma.getDisciplina().getCodigo() + ","
                             + turma.getProfessor().getNome() + ","
                             + turma.getAnoLetivo());
                
                // Salvando os alunos
                for (Aluno aluno : turma.getAlunos()) {
                    writer.write("," + aluno.getNome()); // Adiciona o nome de cada aluno
                }
                writer.newLine();  // Quebra de linha após cada turma
            }
            System.out.println("Turmas salvas com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar as turmas: " + e.getMessage());
        }
    }
    

    public static void carregarTurmas(List<Turma> turmas, List<Disciplina> disciplinas, List<Professor> professores, List<Aluno> alunos) {
        try (BufferedReader reader = new BufferedReader(new FileReader("arquivos/turmas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                
                // Carregar informações básicas da turma
                int codigoTurma = Integer.parseInt(dados[0]);
                String codigoDisciplina = dados[1];
                String nomeProfessor = dados[2];
                int anoLetivo = Integer.parseInt(dados[3]);
                
                // Buscar a disciplina pelo código
                Disciplina disciplina = null;
                for (Disciplina d : disciplinas) {
                    if (d.getCodigo().equals(codigoDisciplina)) {
                        disciplina = d;
                        break;
                    }
                }
                
                // Buscar o professor pelo nome
                Professor professor = null;
                for (Professor p : professores) {
                    if (p.getNome().equals(nomeProfessor)) {
                        professor = p;
                        break;
                    }
                }
                
                // Criar a turma
                Turma turma = new Turma(codigoTurma, disciplina, professor, null, anoLetivo);
                
                // Adicionar os alunos à turma
                for (int i = 4; i < dados.length; i++) {  // Começa no índice 4 (onde começam os alunos)
                    String nomeAluno = dados[i];
                    Aluno aluno = null;
                    
                    // Buscar o aluno pelo nome (ou por outra propriedade, como matrícula)
                    for (Aluno a : alunos) {
                        if (a.getNome().equals(nomeAluno)) {
                            aluno = a;
                            break;
                        }
                    }
                    
                    if (aluno != null) {
                        turma.getAlunos().add(aluno);  // Adiciona o aluno à turma
                    } else {
                        System.out.println("Aluno com nome " + nomeAluno + " não encontrado.");
                    }
                }
                
                // Adicionar a turma à lista de turmas
                turmas.add(turma);
            }
            System.out.println("Turmas carregadas com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar as turmas: " + e.getMessage());
        }
    }

   
}
