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
    for (PessoaEleitora voter : pessoasEleitoras) {
      if (cpf.equals(voter.getCpf())) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }

    PessoaEleitora newVoter = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(newVoter);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}