import java.util.Objects;

public abstract class Pessoa {
    protected String nome;
    protected String dataNascimento;
    protected String telefone;
    protected Endereco endereco;

    public Pessoa(String nome, String dataNascimento, String telefone, String rua, String cidade, String cep) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = new Endereco(rua, cidade, cep);
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

}
