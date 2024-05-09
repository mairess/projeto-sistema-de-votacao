package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {

    for (PessoaCandidata candidate : pessoasCandidatas) {
      if (candidate.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }

    PessoaCandidata newCandidate = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(newCandidate);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora elector : pessoasEleitoras) {
      if (cpf.equals(elector.getCpf())) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }

    PessoaEleitora newVoter = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(newVoter);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : cpfsComputados) {
      if (cpf.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }

    cpfsComputados.add(cpfPessoaEleitora);

    for (PessoaCandidata candidate : pessoasCandidatas) {
      if (numeroPessoaCandidata == candidate.getNumero()) {
        candidate.receberVoto();
        return;
      }
    }
  }

  @Override
  public void mostrarResultado() {
    int computedVotes = cpfsComputados.size();
    float votesPercentage = 0;

    if (computedVotes == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    for (PessoaCandidata candidate : pessoasCandidatas) {
      String name = candidate.getNome();
      int votesQuantity = candidate.getVotos();
      votesPercentage = (float) votesQuantity / computedVotes * 100;

      System.out.println(
          "Nome: " + name + " - " + votesQuantity + " votos " + "( " + votesPercentage + "%" + " )"
      );
    }

    System.out.println("Total de votos: " + computedVotes);
  }
}