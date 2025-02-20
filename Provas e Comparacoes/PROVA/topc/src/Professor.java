import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Professor extends Pessoa implements GerenciadorCadastroProfessor {
    private String areaDeFormacao;
    private int anoDeAdmissao;
    private String email;

    public Professor(String nome, String dataNascimento, String telefone, Endereco endereco,
                     String areaDeFormacao, int anoDeAdmissao, String email) {
        super(nome, dataNascimento, telefone, endereco);
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

        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Rua: ");
        String rua = scanner.nextLine();

        System.out.print("cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("cep: ");
        String cep = scanner.nextLine();
        Endereco endereco = new Endereco(rua, cidade, cep);  // Exemplo simples; ajuste conforme a classe Endereco.

        System.out.print("Área de Formação: ");
        String areaDeFormacao = scanner.nextLine();

        int anoDeAdmissao = 0;
        try {
            System.out.print("Digite o ano de Admissao: ");
            anoDeAdmissao = scanner.nextInt();  // Aqui o scanner tenta pegar um número inteiro
        } catch (java.util.InputMismatchException e) {
            // O InputMismatchException ocorre quando o valor não é um número válido
            System.out.println("Entrada inválida! Esperava-se um número inteiro.");
        } catch (java.util.NoSuchElementException e) {
            // O NoSuchElementException ocorre quando não há dados disponíveis para ler
            System.out.println("Entrada inválida! Nenhum dado disponível.");
        } catch (IllegalStateException e) {
            // O IllegalStateException ocorre se o scanner for fechado de forma incorreta
            System.out.println("Erro no scanner: " + e.getMessage());
        }

        scanner.nextLine();  // Limpa o buffer
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Professor novoProfessor = new Professor(nome, dataNascimento, telefone, endereco, areaDeFormacao, anoDeAdmissao, email);
        professores.add(novoProfessor);

        System.out.println("Professor cadastrado com sucesso!");
    }

    public static void cadastrarProfessorNoMain(List<Professor> professores, List<Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada. Cadastre uma disciplina antes de cadastrar um professor.");
            return;
        }

        // Instancia um Professor para chamar o método de cadastro
        Professor professor = new Professor("", "", "", new Endereco("", "", ""), "", 0, "");
        professor.cadastrarProfessor(professores);  // Chama o método para coletar os dados do novo professor

        // Após o cadastro, associe o professor a uma disciplina existente
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

    public static void salvarProfessores(List<Professor> professores) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("arquivos/professores.txt"))) {
        for (Professor professor : professores) {
            // Salvando o nome, área de formação, ano de admissão, e-mail, e endereço
            writer.write(professor.getNome() + "," 
                         + professor.getAreaDeFormacao() + "," 
                         + professor.getAnoDeAdmissao() + ","
                         + professor.getEmail() + ","
                         + professor.getEndereco().getRua() + ","
                         + professor.getEndereco().getCidade() + ","
                         + professor.getEndereco().getCep());
            writer.newLine();
        }
        System.out.println("Professores salvos com sucesso.");
    } catch (IOException e) {
        System.out.println("Erro ao salvar os professores: " + e.getMessage());
    }   
}

public static void carregarProfessores(List<Professor> professores) {
    try (BufferedReader reader = new BufferedReader(new FileReader("arquivos/professores.txt"))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            // Carregando o endereço de forma adequada
            Endereco endereco = new Endereco(dados[4], dados[5], dados[6]);  // Rua, Cidade, CEP
            Professor professor = new Professor(dados[0], "", "", endereco, dados[1], Integer.parseInt(dados[2]), dados[3]);
            professores.add(professor);
        }
        System.out.println("Professores carregados com sucesso.");
    } catch (IOException e) {
        System.out.println("Erro ao carregar os professores: " + e.getMessage());
    }
}


}
