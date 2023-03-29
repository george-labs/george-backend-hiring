package com.george.wordcounter.providers;

import java.io.InputStream;
import java.util.Scanner;


public class SystemInProvider implements InputProvider {

  private final InputStream inputStream;

  public SystemInProvider(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  @Override
  public String readFromInput() {
    Scanner scan = new Scanner(inputStream);
    System.out.print("Enter text: ");

    return scan.nextLine();
  }
}
