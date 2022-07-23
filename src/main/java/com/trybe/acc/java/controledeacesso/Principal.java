package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

/** Classe principal. */
public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    // ESCREVA SEU CÓDIGO AQUI
    Locale locale = new Locale("en", "US");
    Scanner scan = new Scanner(System.in);
    LinkedList<Short> menores = new LinkedList<>();
    LinkedList<Short> adultos = new LinkedList<>();
    LinkedList<Short> idosos = new LinkedList<>();

    int opcaoSelecionada;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n2 - Finalizar sistema e mostrar relatório");
      opcaoSelecionada = scan.nextInt();
      if (opcaoSelecionada == 1) {
        System.out.println("Entre com a sua idade:");
        short idade = scan.nextShort();
        if (idade < 18) {
          menores.add(idade);
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (18 <= idade && idade < 50) {
          adultos.add(idade);
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          idosos.add(idade);
          System.out.println("Pessoa adulta a partir de 50 anos, catraca liberada!");
        }
      } else if (opcaoSelecionada > 2 || opcaoSelecionada < 1) {
        System.out.println("Entre com uma opção válida!");
      }
    } while (opcaoSelecionada != 2);
    scan.close();

    int qtdMenores = menores.size();
    int qtdAdultos = adultos.size();
    int qtdIdosos = idosos.size();
    float total = qtdMenores + qtdAdultos + qtdIdosos;
    DecimalFormat formatoDecimal = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    formatoDecimal.applyPattern("##0.0#");
    float floatMenores = (qtdMenores * 100) / total;
    float floatAdultos = (qtdAdultos * 100) / total;
    float floatIdosos = (qtdIdosos * 100) / total;
    String perMenores = formatoDecimal.format(floatMenores);
    String perAdultos = formatoDecimal.format(floatAdultos);
    String perIdosos = formatoDecimal.format(floatIdosos);
    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + qtdMenores);
    System.out.println("adultas: " + qtdAdultos);
    System.out.println("a partir de 50 anos: " + qtdIdosos);
    System.out.println("\n");
    System.out.println("----- Percentual -----");
    System.out.println("menores: " + perMenores);
    System.out.println("adultas: " + perAdultos);
    System.out.println("a partir de 50 anos: " + perIdosos);
    System.out.println("\n");
    System.out.println("TOTAL: " + total);
  }
}
