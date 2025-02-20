import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Aluno extends Pessoa implements GerenciadorCadastroAluno {
    private String matricula;
    private int anoIngresso;
    private List<Nota> notas;

    // Ajustado para instanciar endereço diretamente a partir de rua, cidade e cep
    public Aluno(String nome, String dataNascimento, String telefone, String matricula, int anoIngresso, String rua, String cidade, String cep) {
        super(nome, dataNascimento, telefone, rua, cidade, cep); // Passa dados de endereço para Pessoa
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
        this.notas = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    @Override
    public void cadastrarAluno(List<Aluno> alunos) {
        Scanner scanner = new Scanner(System.in);

        // Coleta de dados do aluno
        System.out.print("Nome do Aluno: ");
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

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Ano de Ingresso: ");
        int anoIngresso = scanner.nextInt();

       
        Aluno novoAluno = new Aluno(nome, dataNascimento, telefone, matricula, anoIngresso, rua, cidade, cep);
        alunos.add(novoAluno); 

        System.out.println("Aluno cadastrado com sucesso!");
        salvarAlunoTxt(alunos);
    }

    
    public static void cadastroDeAlunos(List<Aluno> alunos) {
        Aluno aluno = new Aluno("", "", "", "", 0, "", "", "");  
        aluno.cadastrarAluno(alunos);  
    }

    public static void listarAlunos() {
        String caminhoArquivo1 = "ArquivoAlunos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo1))) {
            String linha;
            System.out.println("Conteúdo do arquivo:");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void salvarAlunoTxt(List<Aluno> alunos) {
        try (FileWriter writer = new FileWriter("ArquivoAlunos.txt")) {
            
            writer.write("Alunos >>\n");

            for (Aluno aluno : alunos) {
                writer.write("Nome: " + aluno.getNome() + "\n");
                writer.write("Data de Nascimento: " + aluno.getDataNascimento() + "\n");
                writer.write("Telefone: " + aluno.getTelefone() + "\n");
                writer.write("Rua: " + aluno.endereco.getRua() + "\n");
                writer.write("Cidade: " + aluno.endereco.getCidade() + "\n");
                writer.write("Cep: " + aluno.endereco.getCep() + "\n");
                writer.write("ID Matricula: " + aluno.getMatricula() + "\n");
                writer.write("Ano de Ingresso: " + aluno.getAnoIngresso() + "\n");
                writer.write("\t...\n\n"); 
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    
    public static void quantidadeAlunos() {
        String caminhoArquivo1 = "ArquivoAlunos.txt";
        int contadorLinhas = 0;
        int conta = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo1))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                contadorLinhas++; 
            }

            conta = contadorLinhas / 8;
            System.out.println("Numero de alunos cadastrados: " + conta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}