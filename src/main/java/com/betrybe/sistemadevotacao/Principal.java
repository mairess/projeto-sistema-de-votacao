package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  private static final Scanner scanner = new Scanner(System.in);
  private static final GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    while (true) {
      System.out.println("""
          Cadastrar pessoa candidata?
          1 - Sim
          2 - Não
          Entre com o número correspondente à opção desejada:""");

      int selectedCandidateOption = scanner.nextInt();

      if (selectedCandidateOption == 1) {
        registerCandidate();

      } else if (selectedCandidateOption == 2) {

        boolean registerElector = registerElector();

        if (registerElector) {
          break;
        }

      }
    }
    scanner.close();
  }

  private static void registerCandidate() {
    System.out.println("Entre com o nome da pessoa candidata: ");
    String candidateName = scanner.next();

    System.out.println("Entre com o número da pessoa candidata: ");
    int candidateNumber = scanner.nextInt();

    gerenciamentoVotacao.cadastrarPessoaCandidata(candidateName, candidateNumber);
  }

  private static boolean registerElector() {
    while (true) {
      System.out.println("""
          Cadastrar pessoa eleitora?
          1 - Sim
          2 - Não
          Entre com o número correspondente à opção desejada:""");

      int selectedElectorOption = scanner.nextInt();

      if (selectedElectorOption == 1) {
        System.out.println("Entre com o nome da pessoa eleitora: ");
        String electorName = scanner.next();

        System.out.println("Entre com o CPF da pessoa eleitora: ");
        String electorCpf = scanner.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(electorName, electorCpf);

      } else if (selectedElectorOption == 2) {

        boolean vote = vote();

        if (vote) {
          return true;
        }

      }
    }
  }

  private static boolean vote() {
    while (true) {
      System.out.println("""
          Entre com o número correspondente à opção desejada:
          1 - Votar
          2 - Resultado Parcial
          3 - Finalizar Votação""");

      int selectedOption = scanner.nextInt();

      if (selectedOption == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora: ");
        String cpfPessoaEleitora = scanner.next();

        System.out.println("Entre com o número da pessoa candidata: ");
        int numeroPessoaCandidata = scanner.nextInt();

        gerenciamentoVotacao.votar(cpfPessoaEleitora, numeroPessoaCandidata);
      } else if (selectedOption == 2) {

        gerenciamentoVotacao.mostrarResultado();

      } else if (selectedOption == 3) {

        gerenciamentoVotacao.mostrarResultado();
        return true;
      }

    }
  }
}