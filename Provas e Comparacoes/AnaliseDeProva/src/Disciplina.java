import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Disciplina implements GerenciadorCadastro<Disciplina>, GeradorCodigoUnico
{
    private static ArrayList<Integer> ArrayCodigos = new ArrayList<Integer>();

    private String nome;
    private int cargaHoraria;
    private int codigo;
    private ArrayList<Professor> ArrayProfessor = new ArrayList<Professor>();
    private ArrayList<Turma> ArrayTurma =  new ArrayList<Turma>();
    private DadosSistema objDadosSistema;

    public Disciplina()
    {
        objDadosSistema = new DadosSistema();
    }

    @Override
    public Disciplina Cadastro(Disciplina objDisciplina)
    {
        Scanner teclado = new Scanner(System.in);
         try 
        {
            System.out.println("Digite o nome da disciplina: ");
            objDisciplina.setNome(teclado.nextLine());
            System.out.println("Digite a carga horaria da disciplina: ");
            objDisciplina.setCargaHoraria(teclado.nextInt());
            teclado.nextLine();

        } catch (Exception e) 
        {
            System.out.println("Erro ao ler valor inserido, por favor digite um valor valido!");
        }
        objDisciplina.setCodigo(GerarCodigoUnico());
        
        if (!objDadosSistema.getArrayProfessores().isEmpty()) {
            ArrayList<Professor> ArrayProfessoresSelecionados = new ArrayList<Professor>();
            boolean continuar = true;
    
            while (continuar) {
                System.out.println("Escolha um professor para adicionar à disciplina ou digite 0 para finalizar:\n");
                int contador = 1;
    
                for (Professor professor : objDadosSistema.getArrayProfessores()) 
                {
                    if (!ArrayProfessoresSelecionados.contains(professor)) 
                    {
                        System.out.println("Opção " + contador);
                        System.out.println("Professor(a): " + professor.getNome());
                        System.out.println("Área de formação: " + professor.getAreaDeFormacao() + "\n");
                    }
                    contador++;
                }
    
                int opcao = teclado.nextInt();
                teclado.nextLine();
    
                if (opcao == 0) 
                {
                    continuar = false;
                } else if (opcao > 0 && opcao <= objDadosSistema.getArrayProfessores().size()) 
                {
                    Professor professorEscolhido = objDadosSistema.getArrayProfessores().get(opcao - 1);
                    if (!ArrayProfessoresSelecionados.contains(professorEscolhido)) 
                    {
                        objDisciplina.adicionarProfessor(professorEscolhido);
                        ArrayProfessoresSelecionados.add(professorEscolhido);
                        System.out.println("\nProfessor " + professorEscolhido.getNome() + " adicionado com sucesso!\n");
                    } else 
                    {
                        System.out.println("\nProfessor já foi selecionado. Escolha outro.\n");
                    }
                } else 
                {
                    System.out.println("\nOpção inválida! Tente novamente.\n");
                }
            }
        } else 
        {
            System.out.println("\nErro ao cadastrar disciplina, você deve ter ao menos um professor cadastrado!\n");
            return null;
        }

        System.out.println("O codigo da disciplina gerado foi: " + this.codigo);

        String textoArquivo = ("\nDisciplina \nCodigo:\n" + objDisciplina.getCodigo() + "\n");
        textoArquivo += ("Nome: \n" + objDisciplina.getNome() + "\n");
        textoArquivo += ("Carga Horaria: \n" + objDisciplina.getCargaHoraria() + "\n");
        textoArquivo += ("Professor(es)-----\n\n");
        if (!ArrayProfessor.isEmpty()) 
        {
            for (Professor professor : objDadosSistema.getArrayProfessores()) 
            {
                textoArquivo +=("Professor(a):\n" + professor.getNome() + "\n");
                textoArquivo +=("Area de formacao:\n" + professor.getAreaDeFormacao() + "\n");
            }
        }
        textoArquivo += ("Turmas:\n");
        if (!ArrayTurma.isEmpty()) 
        {
            for (Turma turma : ArrayTurma) 
            {
                textoArquivo += ("Codigo da turma:\n" + turma.getCodigo() + "\n");
            }
        }
        else
        {
            textoArquivo += ("Nenhuma turma possui essa disciplina ainda!");
        }
        objDadosSistema.GuardarDados(textoArquivo);
        return objDisciplina;
    }

    @Override
    public int GerarCodigoUnico()
    {
        Random random = new Random();
        int codigo = 1000 + random.nextInt(9000);	
		while(ArrayCodigos.contains(codigo))
		{
			codigo = 1000 + random.nextInt(9000);	
		}
		ArrayCodigos.add(codigo);
        return codigo;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public void setCargaHoraria(int cargaHoraria)
    {
        this.cargaHoraria = cargaHoraria;
    }
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    public void adicionarProfessor(Professor professor)
    {
        this.ArrayProfessor.add(professor);
    }
    public void adicionarTurma(Turma turma)
    {
        this.ArrayTurma.add(turma);
    }

    public String getNome()
    {
        return this.nome;
    }
    public int getCargaHoraria()
    {
        return this.cargaHoraria;
    }
    public int getCodigo()
    {
        return this.codigo;
    }
    public ArrayList<Professor> getArrayProfessor()
    {
        return this.ArrayProfessor;
    }
    public ArrayList<Turma> getArrayTurma()
    {
        return this.ArrayTurma;
    }
}
