import java.util.ArrayList;

public class Turma 
{
    private ArrayList<Aluno> ArrayAluno = new ArrayList<Aluno>();
    private int codigo;
    private ArrayList<Disciplina> ArrayDisciplina = new ArrayList<Disciplina>();
    private Professor professor;
    private int anoLetivo;

    public Turma(){}

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public void setAnoLetivo(int anoLetivo)
    {
        this.anoLetivo = anoLetivo;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }

    public void adicionarDisciplina(Disciplina disciplina)
    {
        this.ArrayDisciplina.add(disciplina);
    }

    public void adicionarAluno(Aluno aluno)
    {
        this.ArrayAluno.add(aluno);
    }

    public int getCodigo()
    {
        return this.codigo;
    }

    public int getAnoLetivo()
    {
        return this.anoLetivo;
    }

    public Professor getProfessor()
    {
        return this.professor;
    }
}
