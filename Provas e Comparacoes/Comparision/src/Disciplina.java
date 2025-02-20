import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private String codigo;
    private List<Professor> professores;

    public Disciplina(String nome, int cargaHoraria, String codigo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.professores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public static void listarDisciplinas() {
        String caminhoArquivo3 = "ArquivoDisciplinas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo3))) {
            String linha;
            System.out.println("Conteúdo do arquivo:");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
    public static void cadastrodeDisciplinas(List<Disciplina> disciplinas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();

        int cargaHoraria;
        while (true) {
            System.out.print("Carga horária (em horas): ");
            try {
                cargaHoraria = scanner.nextInt();
                scanner.nextLine(); 
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Carga horária inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); 
            }
        }

        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();

        // Create the new discipline and add it to the list of disciplines
        Disciplina novaDisciplina = new Disciplina(nome, cargaHoraria, codigo);
        disciplinas.add(novaDisciplina);

        System.out.println("Disciplina cadastrada com sucesso: " + novaDisciplina.getNome());
        salvarDisciplinaTxt(disciplinas);
    }


    public static void salvarDisciplinaTxt(List<Disciplina> disciplinas) {
        try (FileWriter writer = new FileWriter("ArquivoDisciplinas.txt")) {
            writer.write("Disciplinas>>\n");

            for (Disciplina disciplina : disciplinas) {
                writer.write("Nome: " + disciplina.getNome() + "\n");
                writer.write("Carga Horaria: " + disciplina.getCargaHoraria() + "\n");
                writer.write("Codigo: " + disciplina.getCodigo() + "\n");
                writer.write("\t...\n"); // Linha separadora
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
}


    public static void listarAlunosPorDisciplina() {
        String caminhoArquivoNotas = "ArquivoNotas.txt";
        Set<String> disciplinas = new HashSet<>();
       
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoNotas))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Disciplina:")) {
                    String disciplina = linha.split(":")[1].trim();
                    disciplinas.add(disciplina); // Adiciona a disciplina ao conjunto
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de notas: " + e.getMessage());
            return;
        }

        // Exibe disciplinas disponíveis
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina encontrada.");
            return;
        }

        System.out.println("Disciplinas disponíveis:");
        disciplinas.forEach(disciplina -> System.out.println("- " + disciplina));

        // Recebe a escolha da disciplina
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da disciplina para ver os alunos: ");
        String disciplinaEscolhida = scanner.nextLine().trim();

        System.out.printf("Alunos cadastrados na disciplina %s:%n", disciplinaEscolhida);

        
        Set<String> alunosExibidos = new HashSet<>(); 
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoNotas))) {
            String linha;
            String nomeAluno = null;
            String disciplinaAtual = null;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome:")) {
                    nomeAluno = linha.split(":")[1].trim();
                } else if (linha.startsWith("Disciplina:")) {
                    disciplinaAtual = linha.split(":")[1].trim();
                } else if (linha.startsWith("Nota:")) {
                    if (disciplinaAtual != null && disciplinaAtual.equalsIgnoreCase(disciplinaEscolhida)) {
                        if (!alunosExibidos.contains(nomeAluno)) {
                            System.out.println("- " + nomeAluno);
                            alunosExibidos.add(nomeAluno); // Marca o aluno como exibido
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de notas: " + e.getMessage());
        }
    }

    
}
