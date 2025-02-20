public class Endereco {
    private String rua;
    private String cidade;
    private String cep;

    public Endereco(String rua, String cidade, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
    }

    // Getters e Setters para os atributos
    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }
}
