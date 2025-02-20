import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Turma {
    private int codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;
    private int anoLetivo;

    public Turma(int codigo, Disciplina disciplina, Professor professor, int anoLetivo) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.anoLetivo = anoLetivo;
        this.alunos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDisciplina() {
        return disciplina.getNome();
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    
    public static void cadastrarTurma(List<Disciplina> disciplinas, List<Professor> professores, List<Turma> turmas) {
        Scanner scanner = new Scanner(System.in);

        String caminhoArquivoDisciplinas = "ArquivoDisciplinas.txt";
        String caminhoArquivoProfessores = "ArquivoProfessores.txt";

        // Carregar disciplinas
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoDisciplinas))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Ignora linhas de separação ou vazias
                if (linha.trim().isEmpty() || linha.contains("Disciplina")) {
                    continue;
                }

                String nome = linha.split(": ")[1];
                int cargaHoraria = Integer.parseInt(br.readLine().split(": ")[1]);
                String codigo = br.readLine().split(": ")[1];
                disciplinas.add(new Disciplina(nome, cargaHoraria, codigo));

                // Pula uma linha após cada disciplina
                br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar disciplinas: " + e.getMessage());
        }

        // Verificar se há disciplinas carregadas
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas. Cadastre uma disciplina antes de cadastrar uma turma.");
            return;
        }

        // Carregar professores
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoProfessores))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Ignora linhas de separação ou vazias
                if (linha.trim().isEmpty() || linha.contains("Professores")) {
                    continue;
                }

                String nome = linha.split(": ")[1];
                String dataNascimento = br.readLine().split(": ")[1];
                String telefone = br.readLine().split(": ")[1];
                String rua = br.readLine().split(": ")[1];
                String cidade = br.readLine().split(": ")[1];
                String areaDeFormacao = br.readLine().split(": ")[1];
                int anoDeAdmissao = Integer.parseInt(br.readLine().split(": ")[1]);

                // Cria o professor e adiciona à lista
                Professor professor = new Professor(nome, dataNascimento, telefone, areaDeFormacao, anoDeAdmissao, "", rua, cidade, "");
                professores.add(professor);

                // Pula uma linha em branco entre registros
                br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar professores: " + e.getMessage());
        }

        // Verificar se há professores carregados
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados. Cadastre um professor antes de cadastrar uma turma.");
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

        System.out.print("Digite o código da turma (numérico): ");
        String idTurma = scanner.nextLine();

        if (turmas.contains(idTurma.equals(idTurma))) {
            System.out.println("Esse codigo de turma já existe");
        }

        System.out.print("Digite o ano letivo da turma: ");
        int anoLetivo = scanner.nextInt();
        scanner.nextLine(); // Consome o newline

        try {
            int codigoTurma = Integer.parseInt(idTurma); // Converte para int
            Turma novaTurma = new Turma(codigoTurma, disciplinaEscolhida, professorEscolhido, anoLetivo);
            turmas.add(novaTurma); // Adiciona a turma à lista
            System.out.println("Turma cadastrada com sucesso: " + codigoTurma
                    + " - Disciplina: " + disciplinaEscolhida.getNome()
                    + " - Professor: " + professorEscolhido.getNome());

            salvarTurmasTxt(turmas);
        } catch (NumberFormatException e) {
            System.out.println("Erro: o código da turma deve ser um número.");
        }
    }

    
    public static void listarTurmas() {
        String caminhoArquivo4 = "ArquivoTurmas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo4))) {
            String linha;
            System.out.println("Conteúdo do arquivo:");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }


    public static void salvarTurmasTxt(List<Turma> turmas) {
        try (FileWriter writer = new FileWriter("ArquivoTurmas.txt")) {
            writer.write("Turmas>>\n");

            for (Turma turma : turmas) {
                writer.write("Codigo: " + turma.getCodigo() + "\n");
                writer.write("Disciplina: " + turma.getDisciplina() + "\n");
                writer.write("Ano Letivo: " + turma.getAnoLetivo() + "\n");
                writer.write("Professor Responsavel: " + turma.getProfessor() + "\n");
                writer.write("\t...\n\n"); // Adiciona uma linha em branco entre cada aluno
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void listarProfessoresETurmas() {
        String caminhoArquivoTurmas = "ArquivoTurmas.txt";
        Set<String> professores = new HashSet<>();

        // Primeira leitura para identificar os professores
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoTurmas))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Professor Responsável:")) {
                    String professor = linha.split(":")[1].trim();
                    professores.add(professor);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de turmas: " + e.getMessage());
            return;
        }

        // Exibe professores disponíveis
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor encontrado.");
            return;
        }

        System.out.println("Professores disponíveis:");
        professores.forEach(professor -> System.out.println("- " + professor));

        // Recebe a escolha do professor
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do professor para ver as turmas: ");
        String professorEscolhido = scanner.nextLine().trim();

        System.out.printf("Turmas do professor %s:%n", professorEscolhido);

        // Segunda leitura para listar turmas do professor escolhido
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoTurmas))) {
            String linha;
            boolean turmaEncontrada = false;
            String codigo = null, disciplina = null, anoLetivo = null, professor = null;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Codigo:")) {
                    codigo = linha.split(":")[1].trim();
                } else if (linha.startsWith("Disciplina:")) {
                    disciplina = linha.split(":")[1].trim();
                } else if (linha.startsWith("Ano Letivo:")) {
                    anoLetivo = linha.split(":")[1].trim();
                } else if (linha.startsWith("Professor Responsável:")) {
                    professor = linha.split(":")[1].trim();

                    // Exibe turma se o professor for o escolhido
                    if (professor.equalsIgnoreCase(professorEscolhido)) {
                        System.out.printf("Código: %s | Disciplina: %s | Ano Letivo: %s%n", codigo, disciplina, anoLetivo);
                        turmaEncontrada = true;
                    }
                }
            }

            if (!turmaEncontrada) {
                System.out.printf("Nenhuma turma encontrada para o professor %s.%n", professorEscolhido);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de turmas: " + e.getMessage());
        }
    }


}
