import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        boolean continuar = true;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        while (continuar) {
            System.out.println("Escolha o tipo de cadastro:");
            System.out.println("1. Pessoa Física");
            System.out.println("2. Pessoa Jurídica");
            System.out.println("3. Colaborador");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1: // Cadastro de Pessoa Física
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nome Fantasia: ");
                    String nomeFantasia = scanner.nextLine();
                    System.out.print("Logradouro: ");
                    String logradouro = scanner.nextLine();
                    System.out.print("Número: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Complemento: ");
                    String complemento = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("UF: ");
                    String uf = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("RG: ");
                    String rg = scanner.nextLine();
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();
                    System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                    String dataNascStr = scanner.nextLine();
                    Date nascimento = null;
                    try {
                        nascimento = formato.parse(dataNascStr);
                    } catch (ParseException e) {
                        System.out.println("Data inválida. Cadastro cancelado.");
                        continue;
                    }

                    pessoas.add(new Fisica(0, nome, nomeFantasia, logradouro, numero,
                            complemento, bairro, cep, cidade, uf, cpf, rg, genero, nascimento));
                    break;

                case 2: // Cadastro de Pessoa Jurídica
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Nome Fantasia: ");
                    nomeFantasia = scanner.nextLine();
                    System.out.print("Logradouro: ");
                    logradouro = scanner.nextLine();
                    System.out.print("Número: ");
                    numero = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Complemento: ");
                    complemento = scanner.nextLine();
                    System.out.print("Bairro: ");
                    bairro = scanner.nextLine();
                    System.out.print("CEP: ");
                    cep = scanner.nextLine();
                    System.out.print("Cidade: ");
                    cidade = scanner.nextLine();
                    System.out.print("UF: ");
                    uf = scanner.nextLine();
                    System.out.print("CNPJ: ");
                    String cnpj = scanner.nextLine();
                    System.out.print("Inscrição Estadual: ");
                    String inscricaoEstadual = scanner.nextLine();
                    System.out.print("Data de Fundação (dd/MM/yyyy): ");
                    dataNascStr = scanner.nextLine();
                    Date fundacao = null;
                    try {
                        fundacao = formato.parse(dataNascStr);
                    } catch (ParseException e) {
                        System.out.println("Data inválida. Cadastro cancelado.");
                        continue;
                    }

                    pessoas.add(new Juridica(0, nome, nomeFantasia, logradouro, numero,
                            complemento, bairro, cep, cidade, uf, cnpj, inscricaoEstadual, fundacao));
                    break;

                case 3: // Cadastro de Colaborador
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Nome Fantasia: ");
                    nomeFantasia = scanner.nextLine();
                    System.out.print("Logradouro: ");
                    logradouro = scanner.nextLine();
                    System.out.print("Número: ");
                    numero = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Complemento: ");
                    complemento = scanner.nextLine();
                    System.out.print("Bairro: ");
                    bairro = scanner.nextLine();
                    System.out.print("CEP: ");
                    cep = scanner.nextLine();
                    System.out.print("Cidade: ");
                    cidade = scanner.nextLine();
                    System.out.print("UF: ");
                    uf = scanner.nextLine();
                    System.out.print("CPF: ");
                    cpf = scanner.nextLine();
                    System.out.print("RG: ");
                    rg = scanner.nextLine();
                    System.out.print("Gênero: ");
                    genero = scanner.nextLine();
                    System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                    dataNascStr = scanner.nextLine();
                    nascimento = null;
                    try {
                        nascimento = formato.parse(dataNascStr);
                    } catch (ParseException e) {
                        System.out.println("Data inválida. Cadastro cancelado.");
                        continue;
                    }

                    System.out.print("STPS: ");
                    String stps = scanner.nextLine();
                    System.out.print("PIS: ");
                    String pis = scanner.nextLine();
                    System.out.print("Título de Eleitor: ");
                    String tituloEleitor = scanner.nextLine();
                    System.out.print("Reservista (true/false): ");
                    boolean reservista = scanner.nextBoolean();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Estado Civil: ");
                    String estadoCivil = scanner.nextLine();
                    System.out.print("Número de Dependentes: ");
                    int numDependentes = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Setor: ");
                    String setor = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Salário: ");
                    float salario = scanner.nextFloat();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Telefone 1: ");
                    String telefone1 = scanner.nextLine();
                    System.out.print("Telefone 2: ");
                    String telefone2 = scanner.nextLine();
                    System.out.print("Email Pessoal: ");
                    String emailPessoa = scanner.nextLine();
                    System.out.print("Email Corporativo: ");
                    String emailCorporativo = scanner.nextLine();

                    Colaborador colaborador = new Colaborador(0, nome, nomeFantasia, logradouro, numero,
                            complemento, bairro, cep, cidade, uf, cpf, rg, genero, nascimento,
                            stps, pis, tituloEleitor, reservista, estadoCivil, numDependentes, true,
                            setor, cargo, salario, telefone1, telefone2, emailPessoa, emailCorporativo);
                    pessoas.add(colaborador);
                    break;

                case 4: // Sair
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        // Relatório completo
        System.out.println("\nRelatório de Cadastrados:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Fisica) {
                Fisica fisica = (Fisica) pessoa;
                System.out.println("Pessoa Física: " + fisica.getNome() + ", CPF: " + fisica.getCpf() +
                        ", RG: " + fisica.getRg() + ", Gênero: " + fisica.getGenero() +
                        ", Data de Nascimento: " + formato.format(fisica.getNascimento()));
            } else if (pessoa instanceof Juridica) {
                Juridica juridica = (Juridica) pessoa;
                System.out.println("Pessoa Jurídica: " + juridica.getNome() + ", CNPJ: " + juridica.getCnpj() +
                        ", Inscrição Estadual: " + juridica.getInscricaoEstadual() +
                        ", Data de Fundação: " + formato.format(juridica.getFundacao()));
            } else if (pessoa instanceof Colaborador) {
                Colaborador colaboradorInfo = (Colaborador) pessoa;
                System.out.println("Colaborador: " + colaboradorInfo.getNome() + ", Cargo: " + colaboradorInfo.getCargo() +
                        ", Setor: " + colaboradorInfo.getSetor() + ", Salário: " + colaboradorInfo.getSalario() +
                        ", Telefone 1: " + colaboradorInfo.getTelefone1() +
                        ", Email Pessoal: " + colaboradorInfo.getEmailPessoa());
            }
        }

        scanner.close();
    }
}
