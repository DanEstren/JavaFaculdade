public class Professor extends Pessoa{

    private String formacao;

    Professor(String nome, int idade, String formacao){

        super(nome,idade);

        this.formacao = formacao;

    }


    public void definirformacao(String formacao){
        this.formacao = formacao;
    }

    public String retornarFormacao(){
        return this.formacao;
    }
    
}
