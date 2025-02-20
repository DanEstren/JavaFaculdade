public abstract class Pessoa 
{
    private String nome;
    private String dataNascimento;
    private String telefone;
    private Endereco endereco;

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getDataNascimento()
    {
        return this.dataNascimento;
    }

    public String getTelefone()
    {
        return this.telefone;
    }

    public Endereco getEndereco()
    {
        return this.endereco;
    }
}
