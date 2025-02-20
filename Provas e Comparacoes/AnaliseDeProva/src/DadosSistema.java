import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DadosSistema 
{
    private static ArrayList<Aluno> ArrayAlunos = new ArrayList<>();
    private static ArrayList<Disciplina> ArrayDisciplinas = new ArrayList<Disciplina>();
    private static ArrayList<Professor> ArrayProfessores = new ArrayList<Professor>();
    
    //private static ArrayList<String> textoArquivo = new ArrayList<String>();
    private FileWriter arquivoEscrita = null;
    private File caminhoArquivo = new File("Arquivo_log.txt");

    public DadosSistema(){}

    public void AtualizarDados()
    {
        try (FileWriter arquivoEscrita = new FileWriter(caminhoArquivo, true))
        {
            arquivoEscrita.append("");
        } catch (Exception e) 
        {
            System.out.println("Erro ao criar o aquivo para escrita.");
        }
        try (Scanner leituraArquivo = new Scanner(caminhoArquivo)) 
        {
            String linha = leituraArquivo.nextLine().trim();
            while (leituraArquivo.hasNextLine()) 
            {
                if (linha.trim().isEmpty()) {
                    linha = leituraArquivo.nextLine();  // Lê a próxima linha
                    continue;  // Ignora a linha vazia e vai para o próximo ciclo
                }
                
                if (linha.equals("Aluno")) 
                {
                    Aluno objAluno = new Aluno();
                    try {
                        
                        leituraArquivo.nextLine(); // Lê "Matricula:"
                        String linhaMatricula = leituraArquivo.nextLine().trim(); // Lê a matrícula (linha seguinte)
                        int matricula = Integer.parseInt(linhaMatricula);  // Converte para inteiro
                        objAluno.setMatricula(matricula);
                        leituraArquivo.nextLine();  // Lê "Nome:"
                        objAluno.setNome(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Data de nascimento:"
                        objAluno.setDataNascimento(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Telefone:"
                        objAluno.setTelefone(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Turma:"
                        String linhaTurma = leituraArquivo.nextLine().trim();
                        int codigoTurma = Integer.parseInt(linhaTurma);  // Converte para inteiro
                        objAluno.getTurma().setCodigo(codigoTurma);
                        leituraArquivo.nextLine();  // Lê "Endereco:"
                        objAluno.getEndereco().setEnderecoCompleto(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Ano de ingresso:"
                        String linhaAnoIngresso = leituraArquivo.nextLine().trim();
                        int anoIngresso = Integer.parseInt(linhaAnoIngresso);  // Converte para inteiro
                        objAluno.setAnoIngresso(anoIngresso);
                            
                        ArrayAlunos.add(objAluno); // Adiciona o aluno à lista
                    } catch (Exception e) 
                    {
                        System.out.println("Erro ao ler dados do aluno: " + e.getMessage());
                    }
                }
                if(linha.equals("Professor"))
                {
                    Professor objProfessor = new Professor();
                    try 
                    {
                        leituraArquivo.nextLine();  // Lê "Nome:"
                        objProfessor.setNome(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Data de nascimento:"
                        objProfessor.setDataNascimento(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Telefone:"
                        objProfessor.setTelefone(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Endereco:"
                        objProfessor.getEndereco().setEnderecoCompleto(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Email:"
                        objProfessor.setEmail(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Area de formacao::"
                        objProfessor.setAreaDeFormacao(leituraArquivo.nextLine());
                        leituraArquivo.nextLine(); // Lê "Ano de admissao:"
                        String linhaAnoDeAdmissao = leituraArquivo.nextLine().trim();
                        int anoDeAdmissao = Integer.parseInt(linhaAnoDeAdmissao);  // Converte para inteiro
                        objProfessor.setAnoDeAdmissao(anoDeAdmissao);

                        ArrayProfessores.add(objProfessor);
                    } catch (Exception e) 
                    {
                        System.out.println("Erro ao ler dados do professor: " + e.getMessage());
                    }
                }
                if (linha.equals("Disciplina")) 
                {
                    Disciplina objDisciplina = new Disciplina();
                    try 
                    {
                        leituraArquivo.nextLine();  // Lê "Codigo:"
                        String linhaCodigo = leituraArquivo.nextLine().trim();
                        int codigoDisciplina = Integer.parseInt(linhaCodigo);  // Converte para inteiro
                        objDisciplina.setCodigo(codigoDisciplina);
                        leituraArquivo.nextLine();  // Lê "Nome:"
                        objDisciplina.setNome(leituraArquivo.nextLine());
                        leituraArquivo.nextLine();  // Lê "Carga Horaria:"
                        String linhaCargaHoraria= leituraArquivo.nextLine().trim();
                        int cargaHorariaDisciplina = Integer.parseInt(linhaCargaHoraria);  // Converte para inteiro
                        objDisciplina.setCodigo(cargaHorariaDisciplina);
                        leituraArquivo.nextLine();  // Lê "Professor(es)-----"
                        while (!leituraArquivo.nextLine().equals("Turmas:")) 
                        {
                            
                        }

                        ArrayDisciplinas.add(objDisciplina);
                    } catch (Exception e) 
                    {
                        System.out.println("Erro ao ler dados do professor: " + e.getMessage());
                    }
                }
        
                //Lê a próxima linha, independentemente de ter processado ou não
                if (leituraArquivo.hasNextLine()) {
                    linha = leituraArquivo.nextLine();
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao acessar o arquivo para leitura.");
        }
    }

    public void GuardarDados(String textoArquivo)
    {
        try 
        {
            arquivoEscrita = new FileWriter(caminhoArquivo, true);
            arquivoEscrita.append(textoArquivo + "\n");
            arquivoEscrita.close();
        } catch (Exception e) {
            System.out.println("Erro ao acessar o aquivo para escrita.");
        } 
    }

    public ArrayList<Aluno> getArrayAlunos()
    {
        return ArrayAlunos;
    }

    public ArrayList<Disciplina> getArrayDisciplinas()
    {
        return ArrayDisciplinas;
    }

    public ArrayList<Professor> getArrayProfessores()
    {
        return ArrayProfessores;
    }
}