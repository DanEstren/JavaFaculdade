public class Pessoa {

    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public void definirNome(String nome){

        this.nome = nome;
        
    }
    public void retornarNome(){

        System.out.print(this.nome);

    }

    public void definirIdade(int idade){

        this.idade = idade;

    }

    public void retornarIdade(){

        System.out.print(this.idade);

    }

}