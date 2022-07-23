package com.trybe.acc.java.controledeacesso;

import java.util.LinkedList;

/** Classe de registro e armazenamento de dados. */
public class RegistroDeDados {
  static LinkedList<Short> menores = new LinkedList<>(); // armazenamento de dados de menores
  static LinkedList<Short> adultos = new LinkedList<>(); // armazenamento de dados de adultos
  static LinkedList<Short> idosos = new LinkedList<>(); // armazenamento de dados de pessoas +50

  /** Método para direcionar armazenamento de dados de cada grupo. */
  public static void acessarEstabelecimento(Short idade) {
    final String mensagemMenores = "Pessoa cliente menor de idade, catraca liberada!";
    final String mensagemAdultos = "Pessoa adulta, catraca liberada!";
    final String mensagemIdosos = "Pessoa adulta a partir de 50 anos, catraca liberada!";

    if (idade < 18) {
      armazenaDados(menores, idade, mensagemMenores);
    } else if (idade >= 18 && idade < 50) {
      armazenaDados(adultos, idade, mensagemAdultos);
    } else {
      armazenaDados(idosos, idade, mensagemIdosos);
    }
  }

  /** Método para armazenar dados nos grupos corretos. */
  public static void armazenaDados(LinkedList<Short> grupo, Short idade, String mensagem) {
    grupo.add(idade);
    System.out.println(mensagem);
  }
}
