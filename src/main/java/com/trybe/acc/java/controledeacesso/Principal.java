package com.trybe.acc.java.controledeacesso;

import java.util.LinkedList;
import java.util.Scanner;
/** Classe principal. */
public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    // ESCREVA SEU CÓDIGO AQUI
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

  }
}
