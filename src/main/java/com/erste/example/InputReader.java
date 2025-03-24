package com.erste.example;

import java.util.Scanner;

public class InputReader {

  public String readInput() {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter text: ");
    return scan.nextLine();
  }
}
