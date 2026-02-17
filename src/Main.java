import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDeseja ver os livros disponíveis? (SIM/NAO): ");
            String resposta = scanner.nextLine().trim();

            if (resposta.equalsIgnoreCase("NAO")) {
                System.out.println("Obrigado por usar a biblioteca!");
                break;
            }

            if (resposta.equalsIgnoreCase("SIM")) {

                biblioteca.listarLivrosDisponiveis();

                System.out.print("\nDigite o ID do livro que deseja emprestar: ");
                int idLivro = Integer.parseInt(scanner.nextLine());

                Livro livroEscolhido = biblioteca.buscarLivroPorId(idLivro);

                if (livroEscolhido == null) {
                    System.out.println("Livro indisponível ou não encontrado.");
                    continue;
                }

                System.out.print("Digite seu nome: ");
                String nomeCliente = scanner.nextLine();

                biblioteca.realizarEmprestimo(livroEscolhido, nomeCliente);
                System.out.println("Empréstimo realizado com sucesso!");
            }
        }

        scanner.close();
    }
}

