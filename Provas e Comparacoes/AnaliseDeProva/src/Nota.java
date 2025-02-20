public class Nota 
{
    private Disciplina disciplina;
    private double valor;
    private String data;
    

    public Nota(){}

    public void setDisciplina(Disciplina disciplina)
    {
        this.disciplina = disciplina;
    }
    public void setValor(double valor)
    {
        this.valor = valor;
    }
    public void setData(String data)
    {
        this.data = data;
    }

    public Disciplina getDisciplina()
    {
        return this.disciplina;
    }
    public double getValor()
    {
        return this.valor;
    }
    public String getData()
    {
        return this.data;
    }
}
