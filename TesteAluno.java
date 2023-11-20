import java.util.Scanner;

public class TesteAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aluno aluno = new Aluno();

        System.out.println("Informe o nome do aluno:");
        aluno.setNome(scanner.nextLine());

        System.out.println("Informe a idade do aluno:");
        int idade = Integer.parseInt(scanner.nextLine());
        aluno.setIdade(idade);

        System.out.println("Informe o email do aluno:");
        aluno.setEmail(scanner.nextLine());

        System.out.println("Informe o endereço do aluno:");
        aluno.setEndereco(scanner.nextLine());

        System.out.println("Informe o CEP do aluno:");
        aluno.setCep(scanner.nextLine());

        System.out.println("Informe o telefone do aluno:");
        aluno.setTelefone(scanner.nextLine());

        System.out.println("Informe o nome de usuário do aluno:");
        aluno.setUsuario(scanner.nextLine());

        System.out.println("Informe a senha do aluno:");
        aluno.setSenha(scanner.nextLine());

        System.out.println("Cursos disponíveis:");
        aluno.cursosDisponiveis();

        System.out.println("Observação do aluno:");
        aluno.setObservacao(scanner.nextLine());

        System.out.println("Status do aluno: " + aluno.getStatus());

        System.out.println("Informe o novo status do aluno (true para ativo, false para inativo):");
        boolean novoStatus = Boolean.parseBoolean(scanner.nextLine());
        aluno.setStatusAtivo(novoStatus);

        System.out.println("Novo status do aluno: " + aluno.getStatus());

        scanner.close();
    }
}
