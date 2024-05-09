package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    String candidateName;
    int candidateNumber;
    String voterName;
    String voterCpf;

    outerLoop:
    while (true) {

      System.out.println("""
          Cadastrar pessoa candidata?
          1 - Sim
          2 - Não
          Entre com o número correspondente à opção desejada:""");

      int selectedCandidateOption = scanner.nextInt();

      if (selectedCandidateOption == 1) {
        System.out.println("Entre com o nome da pessoa candidata: ");
        candidateName = scanner.next();
        System.out.println("Entre com o número da pessoa candidata: ");
        candidateNumber = scanner.nextInt();

        gerenciamentoVotacao.cadastrarPessoaCandidata(candidateName, candidateNumber);

      } else if (selectedCandidateOption == 2) {

        while (true) {
          System.out.println("""
              Cadastrar pessoa eleitora?
              1 - Sim
              2 - Não
              Entre com o número correspondente à opção desejada:""");

          int selectedVoterOption = scanner.nextInt();

          if (selectedVoterOption == 1) {
            System.out.println("Entre com o nome da pessoa eleitora: ");
            voterName = scanner.next();
            System.out.println("Entre com o CPF da pessoa eleitora: ");
            voterCpf = scanner.next();

            gerenciamentoVotacao.cadastrarPessoaEleitora(voterName, voterCpf);

          } else if (selectedVoterOption == 2) {
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
                break outerLoop;
              }
            }
          }

        }

      }
    }
  }

}