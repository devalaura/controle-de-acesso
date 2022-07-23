package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/** Classe de cálculo, geração e impressão de relatórios. */
public class RelatorioDeResultados {

  /** Método para gerar e imprimir relatórios completos. */
  public static void gerarRelatorios() {
    final int[] qtds = qtdGrupos();
    final int total = totalAcessos(qtds[0], qtds[1], qtds[2]);
    final String perMenores = percentuaisFormatados(qtds[0], total);
    final String perAdultos = percentuaisFormatados(qtds[1], total);
    final String perIdosos = percentuaisFormatados(qtds[2], total);

    imprimeRelatorioQtd(qtds[0], qtds[1], qtds[2]);
    imprimeRelatorioPercentual(perMenores, perAdultos, perIdosos);
    imprimeRelatorioTotal(total);
  }

  /** Método para calcular quantidades totais de acessos por grupo. */
  public static int[] qtdGrupos() {
    final int qtdMenores = RegistroDeDados.menores.size();
    final int qtdAdultos = RegistroDeDados.adultos.size();
    final int qtdIdosos = RegistroDeDados.idosos.size();

    final int[] quantidades = { qtdMenores, qtdAdultos, qtdIdosos };

    return quantidades;
  }

  /** Método para calcular total de acessos. */
  public static int totalAcessos(int menores, int adultos, int idosos) {
    final int soma = menores + adultos + idosos;
    return soma;
  }

  /** Método para calcular e formatar valores percentuais. */
  public static String percentuaisFormatados(int qtdAcessosGrupo, float totalAcessos) {
    final float percentual = (qtdAcessosGrupo * 100f) / totalAcessos;

    Locale locale = new Locale("en", "US");
    DecimalFormat formatoDecimal = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    formatoDecimal.applyPattern("##0.0#");

    final String percentualFormatado = formatoDecimal.format(percentual);

    return percentualFormatado;
  }

  /** Método para imprimir relatórios de quantidades. */
  public static void imprimeRelatorioQtd(int menores, int adultos, int idosos) {
    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + menores);
    System.out.println("adultas: " + adultos);
    System.out.println("a partir de 50 anos: " + idosos);
    System.out.println("\n");
  }

  /** Método para imprimir relatórios percentuais. */
  public static void imprimeRelatorioPercentual(String menores, String adultos, String idosos) {
    System.out.println("----- Percentual -----");
    System.out.println("menores: " + menores + "%");
    System.out.println("adultas: " + adultos + "%");
    System.out.println("a partir de 50 anos: " + idosos + "%");
    System.out.println("\n");
  }

  public static void imprimeRelatorioTotal(int valor) {
    System.out.println("TOTAL: " + valor);
  }
}
