import java.util.Date;

public class Juridica extends Pessoa {

    private String cnpj;
    private String inscricaoEstadual;
    private Date fundacao;

    // Construtor
    public Juridica(int id, String nome, String nomeFantasia, String logradouro, int numero,
                    String complemento, String bairro, String cep, String cidade, String uf,
                    String cnpj, String inscricaoEstadual, Date fundacao) {
        super(id, nome, nomeFantasia, logradouro, numero, complemento, bairro, cep, cidade, uf);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.fundacao = fundacao;
    }

    // Métodos get e set
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Date getFundacao() {
        return fundacao;
    }

    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
    }
}
