import java.util.Date;

public class Colaborador extends Fisica {

    private String stps;
    private String pis;
    private String tituloEleitor;
    private boolean reservista;
    private String estadoCivil;
    private int numDependentes;
    private boolean ativo;
    private String setor;
    private String cargo;
    private float salario;
    private String telefone1;
    private String telefone2;
    private String emailPessoa;
    private String emailCorporativo;

    // Construtor
    public Colaborador(int id, String nome, String nomeFantasia, String logradouro, int numero,
                       String complemento, String bairro, String cep, String cidade, String uf,
                       String cpf, String rg, String genero, Date nascimento,
                       String stps, String pis, String tituloEleitor, boolean reservista,
                       String estadoCivil, int numDependentes, boolean ativo, String setor,
                       String cargo, float salario, String telefone1, String telefone2,
                       String emailPessoa, String emailCorporativo) {
        super(id, nome, nomeFantasia, logradouro, numero, complemento, bairro, cep, cidade, uf,
              cpf, rg, genero, nascimento);
        this.stps = stps;
        this.pis = pis;
        this.tituloEleitor = tituloEleitor;
        this.reservista = reservista;
        this.estadoCivil = estadoCivil;
        this.numDependentes = numDependentes;
        this.ativo = ativo;
        this.setor = setor;
        this.cargo = cargo;
        this.salario = salario;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.emailPessoa = emailPessoa;
        this.emailCorporativo = emailCorporativo;
    }

    // Métodos get e set
    public String getStps() {
        return stps;
    }

    public void setStps(String stps) {
        this.stps = stps;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public boolean isReservista() {
        return reservista;
    }

    public void setReservista(boolean reservista) {
        this.reservista = reservista;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getNumDependentes() {
        return numDependentes;
    }

    public void setNumDependentes(int numDependentes) {
        this.numDependentes = numDependentes;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    // Métodos para admitir e demitir
    public void admitir() {
        this.ativo = true;
        System.out.println("Colaborador admitido: " + getNome());
    }

    public void demitir() {
        this.ativo = false;
        System.out.println("Colaborador demitido: " + getNome());
    }
}
