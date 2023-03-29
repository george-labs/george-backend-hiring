package com.george.wordcounter.providers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProviderFactory {

  public static InputProvider create(String args[]) throws FileNotFoundException {
    if (args != null && args.length != 0 && args[0] != null && !args[0].isBlank()) {
      return new FileProvider(new FileInputStream(args[0]));
    } else {
      return new SystemInProvider(System.in);
    }
  }

}
