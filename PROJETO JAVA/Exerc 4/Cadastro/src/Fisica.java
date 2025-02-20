import java.util.Date;

public class Fisica extends Pessoa {

    protected String cpf;
    protected String rg;
    protected String genero;
    protected Date nascimento;

    // Construtor
    public Fisica(int id, String nome, String nomeFantasia, String logradouro, int numero,
                  String complemento, String bairro, String cep, String cidade, String uf,
                  String cpf, String rg, String genero, Date nascimento) {
        super(id, nome, nomeFantasia, logradouro, numero, complemento, bairro, cep, cidade, uf);
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.nascimento = nascimento;
    }

    // Métodos get e set
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
