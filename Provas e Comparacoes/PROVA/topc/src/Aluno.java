import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    public Aluno(String nome, String dataNascimento, String telefone, Endereco endereco, String matricula, int anoIngresso) {
        super(nome, dataNascimento, telefone, endereco);
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
        Scanner scanner = new Scanner(System.in); //Não fechar pois fecha no main, e para o opcao no menu 
    
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
        Endereco endereco = new Endereco(rua, cidade, cep);  // Criando o endereço
    
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
    
        // Declaração de anoIngresso fora do bloco try-catch
        int anoIngresso = 0;  // Valor padrão
    
        try {
            System.out.print("Digite o ano de ingresso: ");
            anoIngresso = scanner.nextInt();  // Aqui o scanner tenta pegar um número inteiro
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
    
        // Criação do novo aluno
        Aluno novoAluno = new Aluno(nome, dataNascimento, telefone, endereco, matricula, anoIngresso);
        alunos.add(novoAluno); // Adiciona o aluno à lista
    
        System.out.println("Ano de ingresso: " + anoIngresso); // Mostra o ano de ingresso
        System.out.println("Aluno cadastrado com sucesso!");
    }
    
    // Opcional: Adicionar um método estático para simplificar o código no Main
    public static void cadastrarAlunoNoMain(List<Aluno> alunos) {
        Aluno aluno = new Aluno("", "", "", new Endereco("", "", ""), "", 0);  // Instancia um Aluno
        aluno.cadastrarAluno(alunos);  // Chama o método cadastrarAluno
    }
    
    
    public static void salvarAlunos(List<Aluno> alunos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("arquivos/alunos_com_notas.txt"))) {
            for (Aluno aluno : alunos) {
                // Salvando o nome, matrícula, ano de ingresso e o endereço
                
                    writer.write(aluno.getNome() + "," + aluno.getMatricula() + "," + aluno.getAnoIngresso() + ","
                                 + aluno.getEndereco().getRua() + "," + aluno.getEndereco().getCidade() + "," 
                                 + aluno.getEndereco().getCep());

                               
                // Agora salvando as notas do aluno
                for (Nota nota : aluno.getNotas()) {
                    // Salvando a nota e o código da disciplina
                    writer.write("," + nota.getValor() + "," + nota.getDisciplina().getCodigo()+"," + nota.getData());
                }
    
                // Nova linha após cada aluno
                writer.newLine();
            }
            System.out.println("Alunos e suas notas salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os alunos: " + e.getMessage());
        }
    }
    public static void carregarAlunos(List<Aluno> alunos, List<Disciplina> disciplinas) {
        try (BufferedReader reader = new BufferedReader(new FileReader("arquivos/alunos_com_notas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Divide a linha pelos campos
                String[] dados = linha.split(",");
                
                // Remover espaços extras nos dados
                for (int i = 0; i < dados.length; i++) {
                    dados[i] = dados[i].trim();
                }
                
                // Carregar as informações do aluno
                String nome = dados[0];
                String matricula = dados[1];
                
                // Verifique se o valor para o ano de ingresso é válido antes de converter
                int anoIngresso = -1;
                try {
                    anoIngresso = Integer.parseInt(dados[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter ano de ingresso para o aluno " + nome + ". Valor inválido: " + dados[2]);
                }
                
                Endereco endereco = new Endereco(dados[3], dados[4], dados[5]);  // Rua, Cidade, CEP
                
                // Cria o aluno
                Aluno aluno = new Aluno(nome, "", "", endereco, matricula, anoIngresso);
    
                // Depuração: Verifique o aluno sendo carregado
                System.out.println("Carregando aluno: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
                
                // Carregar as notas (começa do índice 6, pois antes disso estão os dados do aluno)
                int i = 6; // Começa a partir da posição onde as notas começam
                while (i < dados.length) {
                    if (i + 1 < dados.length) {  // Garantir que há um código de disciplina
                        try {
                            double valorNota = Double.parseDouble(dados[i]);  // Nota
                            String codigoDisciplina = dados[i + 1];  // Código da disciplina
                            String dataNota = (i + 2 < dados.length) ? dados[i + 2] : "01/01/2024";  // Data da nota (caso não exista, usa valor padrão)
    
                            // Depuração: Verifique os dados das notas
                            System.out.println("Lendo Nota: " + valorNota + ", Código Disciplina: " + codigoDisciplina + ", Data da Nota: " + dataNota);
            
                            // Procurar a disciplina pelo código (com trim para garantir que não há espaços extras)
                            Disciplina disciplina = null;
                            for (Disciplina d : disciplinas) {
                                if (d.getCodigo().trim().equals(codigoDisciplina)) {
                                    disciplina = d;
                                    break;
                                }
                            }
            
                            if (disciplina != null) {
                                // Se a disciplina for encontrada, cria a nota e adiciona ao aluno
                                Nota novaNota = new Nota(aluno, disciplina, valorNota, dataNota);
                                aluno.getNotas().add(novaNota);
                            } else {
                                System.out.println("Disciplina com código " + codigoDisciplina + " não encontrada para o aluno " + aluno.getNome());
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Erro ao converter nota para o aluno " + aluno.getNome() + ". Valor inválido: " + dados[i]);
                        }
                    } else {
                        System.out.println("Dados incompletos para nota ou código da disciplina no aluno " + aluno.getNome());
                    }
                    i += 3;  // Avança 3 posições: uma para a nota, uma para o código da disciplina, uma para a data
                }
                
                // Verificar se as notas foram adicionadas corretamente
                if (!aluno.getNotas().isEmpty()) {
                    System.out.println("Notas carregadas para o aluno " + aluno.getNome() + ": " + aluno.getNotas().size() + " notas.");
                } else {
                    System.out.println("Nenhuma nota carregada para o aluno " + aluno.getNome());
                }
                
                // Adiciona o aluno à lista de alunos
                alunos.add(aluno);
            }
            
            System.out.println("Alunos e notas carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os alunos: " + e.getMessage());
        }
    }
    
    
    

}
