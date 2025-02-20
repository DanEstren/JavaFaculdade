import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Nota {
    private Aluno aluno;
    private Disciplina disciplina;
    private double valor;
    private String data;

    public Nota(Aluno aluno, Disciplina disciplina, double valor, String data) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.valor = valor;
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

     public static void adicionarNota(List<Aluno> alunos,List<Disciplina> disciplinas) {
        
        String caminhoAlunos = "ArquivoAlunos.txt";
        String caminhoDisciplinas = "ArquivoDisciplinas.txt";

        
        alunos.clear(); 
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoAlunos))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.contains("Alunos")) {
                    continue;
                }

                String nome = linha.split(": ")[1];
                String dataNascimento = br.readLine().split(": ")[1];
                String telefone = br.readLine().split(": ")[1];
                String rua = br.readLine().split(": ")[1];
                String cidade = br.readLine().split(": ")[1];
                String cep = br.readLine().split(": ")[1];
                String matricula = br.readLine().split(": ")[1];
                int anoIngresso = Integer.parseInt(br.readLine().split(": ")[1]);
                Aluno aluno = new Aluno(nome, dataNascimento, telefone, matricula, anoIngresso, rua, cidade, cep);
                alunos.add(aluno);

                br.readLine(); // Pular linha entre registros
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar alunos: " + e.getMessage());
            return;
        }

        // Carregar disciplinas do arquivo
        disciplinas.clear(); // Limpar lista de disciplinas para evitar duplicados
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDisciplinas))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty() || linha.contains("Disciplinas")) {
                    continue;
                }

                String nome = linha.split(": ")[1];
                int cargaHoraria = Integer.parseInt(br.readLine().split(": ")[1]);
                String codigo = br.readLine().split(": ")[1];
                Disciplina disciplina = new Disciplina(nome, cargaHoraria, codigo);
                disciplinas.add(disciplina);

                br.readLine(); // Pular linha entre registros
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar disciplinas: " + e.getMessage());
            return;
        }

        // Verificar se há alunos e disciplinas carregados
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado. Cadastre um aluno primeiro.");
            return;
        }
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada. Cadastre uma disciplina primeiro.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        // Exibir lista de alunos e solicitar seleção
        System.out.println("Escolha o número do aluno:");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i + 1) + ". " + alunos.get(i).getNome());
        }
        int alunoIndex;
        while (true) {
            System.out.print("Número do aluno: ");
            alunoIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            if (alunoIndex >= 0 && alunoIndex < alunos.size()) {
                break;
            } else {
                System.out.println("Opção inválida. Escolha um número da lista.");
            }
        }
        Aluno alunoSelecionado = alunos.get(alunoIndex);

        // Exibir lista de disciplinas e solicitar seleção
        System.out.println("Escolha o número da disciplina:");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + ". " + disciplinas.get(i).getNome());
        }
        int disciplinaIndex;
        while (true) {
            System.out.print("Número da disciplina: ");
            disciplinaIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            if (disciplinaIndex >= 0 && disciplinaIndex < disciplinas.size()) {
                break;
            } else {
                System.out.println("Opção inválida. Escolha um número da lista.");
            }
        }
        Disciplina disciplinaSelecionada = disciplinas.get(disciplinaIndex);

        // Solicitar valor da nota
        double valorNota;
        while (true) {
            System.out.print("Informe o valor da nota (0-10): ");
            try {
                valorNota = scanner.nextDouble();
                scanner.nextLine();
                if (valorNota >= 0 && valorNota <= 10) {
                    break;
                } else {
                    System.out.println("Nota inválida. Insira uma nota entre 0 e 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Insira um número.");
                scanner.nextLine();
            }
        }

        // Solicitar data da nota
        System.out.print("Informe a data da nota (dd/mm/yyyy): ");
        String dataNota = scanner.nextLine();

        // Criar e adicionar nota ao aluno
        Nota novaNota = new Nota(alunoSelecionado, disciplinaSelecionada, valorNota, dataNota);
        alunoSelecionado.getNotas().add(novaNota);


        salvarNotasTxt(alunos);
    }

    public static void salvarNotasTxt(List<Aluno> alunos) {
        try (FileWriter writer = new FileWriter("ArquivoNotas.txt", true)) {  // Modifiquei para 'true'
            
            File file = new File("ArquivoNotas.txt");
            if (file.length() == 0) {
                writer.write("Notas>>\n");
            }

            // Itera sobre cada aluno
            for (Aluno aluno : alunos) {
                // Para cada aluno, escreve as notas de cada disciplina
                for (Nota nota : aluno.getNotas()) {
                    // Escreve o nome do aluno, nome da disciplina e a nota
                    writer.write("Nome: " + aluno.getNome() + "\n");
                    writer.write("Disciplina: " + nota.getDisciplina().getNome() + "\n");
                    writer.write("Nota: " + nota.getValor() + "\n");
                    writer.write("\t...\n"); // Linha separadora entre as notas de cada aluno
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório de notas: " + e.getMessage());
        }
    }

    public static void media() {
        String caminhoArquivoNotas = "ArquivoNotas.txt";
        Scanner scanner = new Scanner(System.in);

        
        List<String> nomesAlunos = new ArrayList<>();

        
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoNotas))) {
            String linha;
            String nomeAtual = null;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome:")) {
                    nomeAtual = linha.split(":")[1].trim();
                    if (!nomesAlunos.contains(nomeAtual)) {
                        nomesAlunos.add(nomeAtual); // Adiciona o nome do aluno se não estiver na lista
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de notas: " + e.getMessage());
            return;
        }

      
        System.out.println("Alunos disponíveis:");
        for (int i = 0; i < nomesAlunos.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, nomesAlunos.get(i));
        }

        
        System.out.print("Escolha o número do aluno para gerar o relatório: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); 

        if (escolha < 1 || escolha > nomesAlunos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        String nomeAlunoEscolhido = nomesAlunos.get(escolha - 1);

   
        double somaNotas = 0;
        int quantidadeNotas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoNotas))) {
            String linha;
            boolean alunoEncontrado = false;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome:")) {
                    String nome = linha.split(":")[1].trim();
                    alunoEncontrado = nome.equals(nomeAlunoEscolhido);
                } else if (alunoEncontrado && linha.startsWith("Nota:")) {
                    double nota = Double.parseDouble(linha.split(":")[1].trim());
                    somaNotas += nota;
                    quantidadeNotas++;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de notas: " + e.getMessage());
            return;
        }

     
        if (quantidadeNotas > 0) {
            double media = somaNotas / quantidadeNotas;
            System.out.printf("Relatório para o aluno: %s%n", nomeAlunoEscolhido);
            System.out.printf("Total de Notas: %d%n", quantidadeNotas);
            System.out.printf("Média: %.2f%n", media);
        } else {
            System.out.printf("Nenhuma nota encontrada para o aluno %s.%n", nomeAlunoEscolhido);
        }
    }


    public static void alunoComMaiorNota() {
        String caminhoArquivoNotas = "ArquivoNotas.txt";

        String alunoMaiorNota = null;
        double maiorNota = -1; 

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoNotas))) {
            String linha;
            String nomeAtual = null;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome:")) {
                    nomeAtual = linha.split(":")[1].trim();
                } else if (linha.startsWith("Nota:")) {
                    double nota = Double.parseDouble(linha.split(":")[1].trim());

                    // Verifica se essa nota é maior que a maior nota registrada até agora
                    if (nota > maiorNota) {
                        maiorNota = nota;
                        alunoMaiorNota = nomeAtual;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de notas: " + e.getMessage());
            return;
        }

        if (alunoMaiorNota != null) {
            System.out.printf("Aluno com a maior nota:%nNome: %s%nNota: %.2f%n", alunoMaiorNota, maiorNota);
        } else {
            System.out.println("Nenhuma nota encontrada no arquivo.");
        }
    }


}
