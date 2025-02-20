public class Pessoa {
    protected String nome;
    protected int idade;

   public Pessoa(String nome, int idade){
    this.nome = nome;
    this.idade = idade;
   }

   public String getNome(){
    return this.nome;
   }
   
    public int getIdade(){
    return this.idade;
   }

   public void definirNome(String nome){
 
    this.nome = nome;

   }

   public void definirIdade(int idade){

    this.idade = idade;
   }


}
