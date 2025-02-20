import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private String codigo;
    private List<Professor> professores;

    public Disciplina(String nome, int cargaHoraria, String codigo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.professores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public static void salvarDisciplinas(List<Disciplina> disciplinas) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("arquivos/disciplinas.txt"))) {
        for (Disciplina disciplina : disciplinas) {
            // Salvando os dados da disciplina: nome, carga horária e código
            writer.write(disciplina.getNome() + "," 
                         + disciplina.getCargaHoraria() + "," 
                         + disciplina.getCodigo());
            
            // Salvando os nomes dos professores associados à disciplina
            for (Professor professor : disciplina.getProfessores()) {
                writer.write("," + professor.getNome()); // Salva o nome do professor
            }
            writer.newLine();  // Quebra de linha após cada disciplina
        }
        System.out.println("Disciplinas salvas com sucesso.");
    } catch (IOException e) {
        System.out.println("Erro ao salvar as disciplinas: " + e.getMessage());
    }
}

  public static void carregarDisciplinas(List<Disciplina> disciplinas, List<Professor> professores) {
    try (BufferedReader reader = new BufferedReader(new FileReader("arquivos/disciplinas.txt"))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            
            // Carregar os dados da disciplina
            String nomeDisciplina = dados[0];
            int cargaHoraria = Integer.parseInt(dados[1]);
            String codigoDisciplina = dados[2];
            
            // Criar a disciplina
            Disciplina disciplina = new Disciplina(nomeDisciplina, cargaHoraria, codigoDisciplina);
            
            // Associar professores à disciplina
            for (int i = 3; i < dados.length; i++) {
                String nomeProfessor = dados[i];
                Professor professor = null;
                for (Professor p : professores) {
                    if (p.getNome().equals(nomeProfessor)) {
                        professor = p;
                        break;
                    }
                }
                if (professor != null) {
                    disciplina.getProfessores().add(professor);  // Adiciona o professor à disciplina
                } else {
                    System.out.println("Professor " + nomeProfessor + " não encontrado.");
                }
            }
            
            // Adicionar a disciplina à lista de disciplinas
            disciplinas.add(disciplina);
        }
        System.out.println("Disciplinas carregadas com sucesso.");
    } catch (IOException e) {
        System.out.println("Erro ao carregar as disciplinas: " + e.getMessage());
    }
}


}
