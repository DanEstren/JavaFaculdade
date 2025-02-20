import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Aluno extends Pessoa implements GeradorCodigoUnico, GerenciadorCadastro <Aluno>
{
    private static ArrayList<Integer> ArrayMatriculas = new ArrayList<Integer>();

    private int matricula;
    private int anoIngresso;
    private ArrayList<Nota> ArrayNota = new ArrayList<Nota>();
    private Turma turma;
    private DadosSistema objDadosSistema;

    public Aluno()
    {
        Endereco objEndereco = new Endereco();
        this.setEndereco(objEndereco);
        Turma objTurma = new Turma();
        this.turma = objTurma;
        objDadosSistema = new DadosSistema();
    }

    @Override
    public Aluno Cadastro(Aluno objAluno)
    {
        Scanner teclado = new Scanner(System.in);
        try 
        {
            System.out.println("Digite o nome do aluno: ");
            objAluno.setNome(teclado.nextLine());
            System.out.println("Digite a data de nascimento: ");
            objAluno.setDataNascimento(teclado.nextLine());
            System.out.println("Digite o telefone: ");
            objAluno.setTelefone(teclado.nextLine());
            System.out.println("Digite o ano de ingresso: ");
            objAluno.setAnoIngresso(teclado.nextInt());
            teclado.nextLine();
            System.out.println("Endereco");
            System.out.println("Digite o logradouro: ");
            objAluno.getEndereco().setLogradouro(teclado.nextLine());
            System.out.println("Digite o numero: ");
            objAluno.getEndereco().setNumero(teclado.nextInt());
            teclado.nextLine();
            System.out.println("Digite o bairro: ");
            objAluno.getEndereco().setBairro(teclado.nextLine());
            System.out.println("Digite a cidade: ");
            objAluno.getEndereco().setCidade(teclado.nextLine());
            System.out.println("Digite o estado: ");
            objAluno.getEndereco().setEstado(teclado.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao ler valor inserido, por favor digite um valor valido!");
        }
        objAluno.setMatricula(GerarCodigoUnico());
        String textoArquivo = ("Aluno\nMatricula: \n" + objAluno.getMatricula() + "\n");
        textoArquivo += ("Nome: \n" + objAluno.getNome() + "\n");
        textoArquivo += ("Data de nascimento: \n" + objAluno.getDataNascimento() + "\n");
        textoArquivo += ("Telefone: \n" + objAluno.getTelefone() + "\n");
        textoArquivo += ("Turma: \n" + objAluno.getTurma().getCodigo() + "\n");
        textoArquivo += ("Endereco: \n" + objAluno.getEndereco().getEnderecoCompleto() + "\n");
        textoArquivo += ("Ano de ingresso: \n" + objAluno.getAnoIngresso() + "\n");
        objDadosSistema.GuardarDados(textoArquivo);
        System.out.println("A matricula do aluno cadastrado e: " + objAluno.getMatricula());
        return objAluno;
    }

    @Override
    public int GerarCodigoUnico()
    {
        Random random = new Random();
        int codigo = 1000 + random.nextInt(9000);	
		while(ArrayMatriculas.contains(codigo))
		{
			codigo = 1000 + random.nextInt(9000);	
		}
		ArrayMatriculas.add(codigo);
        return codigo;
    }

    public void setMatricula(int matricula)
    {
        this.matricula = matricula;
    }

    public void setAnoIngresso(int anoIngresso)
    {
        this.anoIngresso = anoIngresso;
    }

    public void setTurma(Turma turma)
    {
        this.turma = turma;
    }

    public int getMatricula()
    {
        return this.matricula;
    }

    public int getAnoIngresso()
    {
        return this.anoIngresso;
    }

    public Turma getTurma()
    {
        return this.turma;
    }

    public ArrayList<Nota> getArrayNota()
    {
        return this.ArrayNota;
    }
}