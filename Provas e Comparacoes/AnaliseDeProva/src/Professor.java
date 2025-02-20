import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Pessoa implements GerenciadorCadastro <Professor>
{
    private String areaDeFormacao;
    private int anoDeAdmissao;
    private String email;
    private ArrayList<Disciplina> ArrayDisciplina = new ArrayList<Disciplina>();
    private DadosSistema objDadosSistema;

    public Professor()
    {
        Endereco objEndereco = new Endereco();
        this.setEndereco(objEndereco);
        objDadosSistema = new DadosSistema();
    }

    @Override
    public Professor Cadastro(Professor objProfessor)
    {
        
        Scanner teclado = new Scanner(System.in);
        try 
        {
            System.out.println("Digite o nome do professor: ");
            objProfessor.setNome(teclado.nextLine());
            System.out.println("Digite a data de nascimento: ");
            objProfessor.setDataNascimento(teclado.nextLine());
            System.out.println("Digite o telefone: ");
            objProfessor.setTelefone(teclado.nextLine());
            System.out.println("Digite o email: ");
            objProfessor.setEmail(teclado.nextLine());
            System.out.println("Digite o ano de admissao: ");
            objProfessor.setAnoDeAdmissao(teclado.nextInt());
            teclado.nextLine();
            System.out.println("Digite a area de formacao: ");
            objProfessor.setAreaDeFormacao(teclado.nextLine());
            System.out.println("Endereco");
            System.out.println("Digite o logradouro: ");
            objProfessor.getEndereco().setLogradouro(teclado.nextLine());
            System.out.println("Digite o numero: ");
            objProfessor.getEndereco().setNumero(teclado.nextInt());
            teclado.nextLine();
            System.out.println("Digite o bairro: ");
            objProfessor.getEndereco().setBairro(teclado.nextLine());
            System.out.println("Digite a cidade: ");
            objProfessor.getEndereco().setCidade(teclado.nextLine());
            System.out.println("Digite o estado: ");
            objProfessor.getEndereco().setEstado(teclado.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao ler valor inserido, por favor digite um valor valido!");
        }
   
        String textoArquivo = ("Professor \nNome: " + objProfessor.getNome() + "\n");
        textoArquivo += ("Data de nascimento: " + objProfessor.getDataNascimento() + "\n");
        textoArquivo += ("Telefone: " + objProfessor.getTelefone() + "\n");
        textoArquivo += ("Endereco: " + objProfessor.getEndereco().getEnderecoCompleto() + "\n");
        textoArquivo += ("Email: " + objProfessor.getEmail() + "\n");
        textoArquivo += ("Area de formacao: " + objProfessor.getAreaDeFormacao() + "\n");
        textoArquivo += ("Ano de admissao: " + objProfessor.getAnoDeAdmissao() + "\n");
        objDadosSistema.GuardarDados(textoArquivo);
        System.out.println("Professor cadastrado com sucesso!");
        return objProfessor;
    }

    public void setAreaDeFormacao(String areaDeFormacao)
    {
        this.areaDeFormacao = areaDeFormacao;
    }
    public void setAnoDeAdmissao(int anoDeAdmissao)
    {
        this.anoDeAdmissao = anoDeAdmissao;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void adicionarDisciplina(Disciplina disciplina)
    {
        this.ArrayDisciplina.add(disciplina);
    }

    public String getAreaDeFormacao()
    {
        return this.areaDeFormacao;
    }
    public int getAnoDeAdmissao()
    {
        return this.anoDeAdmissao;
    }
    public String getEmail()
    {
        return this.email;
    }
    public ArrayList<Disciplina> getArrayDisciplina()
    {
        return this.ArrayDisciplina;
    }
}
