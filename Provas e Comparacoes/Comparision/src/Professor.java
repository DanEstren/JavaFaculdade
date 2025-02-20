import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor extends Pessoa implements GerenciadorCadastroProfessor {
    private String areaDeFormacao;
    private int anoDeAdmissao;
    private String email;

    
    public Professor(String nome, String dataNascimento, String telefone, String areaDeFormacao,
                     int anoDeAdmissao, String email, String rua, String cidade, String cep) {
        super(nome, dataNascimento, telefone, rua, cidade, cep); 
        this.areaDeFormacao = areaDeFormacao;
        this.anoDeAdmissao = anoDeAdmissao;
        this.email = email;
    }


    public String getAreaDeFormacao() {
        return areaDeFormacao;
    }

    public int getAnoDeAdmissao() {
        return anoDeAdmissao;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void cadastrarProfessor(List<Professor> professores) {
        Scanner scanner = new Scanner(System.in);

        // Coleta de dados do professor
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Rua: ");
        String rua = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Área de Formação: ");
        String areaDeFormacao = scanner.nextLine();

        System.out.print("Ano de Admissão: ");
        int anoDeAdmissao = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

       
        Professor novoProfessor = new Professor(nome, dataNascimento, telefone, areaDeFormacao, anoDeAdmissao, email, rua, cidade, cep);
        professores.add(novoProfessor);

        System.out.println("Professor cadastrado com sucesso!");
        salvarProfessorTxt(professores);
    }

    public static void cadastroDeProfessores(List<Professor> professores, List<Disciplina> disciplinas) {
        String caminhoArquivoDisciplinas = "ArquivoDisciplinas.txt";
        
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
            return;
        }

        // Verificar se há disciplinas carregadas
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas. Cadastre uma disciplina antes de cadastrar uma turma.");
            return;
        }
       
        Professor professor = new Professor("", "", "", "", 0, "", "", "", "");
        professor.cadastrarProfessor(professores); 

       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma disciplina para associar ao professor:");

        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + " - " + disciplinas.get(i).getNome());
        }

        System.out.print("Escolha o número da disciplina: ");
        int disciplinaIndex = scanner.nextInt() - 1;

        if (disciplinaIndex < 0 || disciplinaIndex >= disciplinas.size()) {
            System.out.println("Opção inválida. Professor não foi associado a nenhuma disciplina.");
        } else {
            Disciplina disciplinaEscolhida = disciplinas.get(disciplinaIndex);
            disciplinaEscolhida.getProfessores().add(professor); // Associa o professor à disciplina
            System.out.println("Professor associado à disciplina: " + disciplinaEscolhida.getNome());
        }
    }
   
    public static void salvarProfessorTxt(List<Professor> professores) {
            try (FileWriter writer = new FileWriter("ArquivoProfessores.txt")) {
                writer.write("Professores>>\n");

                for (Professor professor : professores) {
                    writer.write("Nome: " + professor.getNome() + "\n");
                    writer.write("Data de Nascimento: " + professor.getDataNascimento() + "\n");
                    writer.write("Telefone: " + professor.getTelefone() + "\n");
                    writer.write("Rua: " + professor.endereco.getRua() + "\n");
                    writer.write("Cidade: " + professor.endereco.getCidade() + "\n");
                    writer.write("Area de Formacao: " + professor.getAreaDeFormacao() + "\n");
                    writer.write("Ano de Admissao: " + professor.getAnoDeAdmissao() + "\n");
                    writer.write("\t...\n\n"); 
                }
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public static void listarProfessores() {
        String caminhoArquivo2 = "ArquivoProfessores.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo2))) {
            String linha;
            System.out.println("Conteúdo do arquivo:");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
    @Override
    public String toString() {
        return nome + "";
    }
}
