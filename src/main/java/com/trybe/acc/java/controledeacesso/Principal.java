package com.trybe.acc.java.controledeacesso;

import java.util.Scanner;

/** Classe principal. */
public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    // ESCREVA SEU CÓDIGO AQUI
    Scanner scan = new Scanner(System.in);

    int opcaoSelecionada;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n2 - Finalizar sistema e mostrar relatório");
      opcaoSelecionada = scan.nextInt();
      lidaComOpcaoMenuInicial(scan, opcaoSelecionada);
    } while (opcaoSelecionada != 2);
    scan.close();
  }

  /**
   * Método para direcionar aplicação de acordo com opção escolhina no menu
   * inicial.
   */
  public static void lidaComOpcaoMenuInicial(Scanner scan, int opcaoSelecionada) {
    if (opcaoSelecionada == 1) {
      System.out.println("Entre com a sua idade:");
      short idade = scan.nextShort();

      RegistroDeDados.acessarEstabelecimento(idade);
    } else if (opcaoSelecionada == 2) {
      RelatorioDeResultados.gerarRelatorios();
    } else {
      System.out.println("Entre com uma opção válida!");
    }
  }
}
