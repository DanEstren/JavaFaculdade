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
}
