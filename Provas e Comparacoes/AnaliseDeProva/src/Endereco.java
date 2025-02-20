public class Endereco 
{
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(){}

    public void setLogradouro(String logradouro)
    {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getLograoduro()
    {
        return this.logradouro;
    }

    public int getNumero()
    {
        return this.numero;
    }

    public String getBairro()
    {
        return this.bairro;
    }

    public String getCidade()
    {
        return this.cidade;
    }

    public String getEstado()
    {
        return this.estado;
    }

    public void setEnderecoCompleto(String endereco)
    {
        String[] partes = endereco.split(", ");
        if (partes.length == 5) {
            this.logradouro = partes[0];
            try {
                this.numero = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                System.out.println("Número do endereço inválido");
                return;
            }
            this.bairro = partes[2];
            this.cidade = partes[3];
            this.estado = partes[4];
        } else 
        {
            System.out.println("Formato de endereço inválido");
        }
    }

    public String getEnderecoCompleto()
    {
        return this.logradouro + ", " + this.numero + ", " + this.bairro + ", " + this.cidade + ", " + this.estado;
    }
}
