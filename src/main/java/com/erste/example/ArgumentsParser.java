package com.erste.example;

import com.erste.example.dto.Argument;
import java.util.ArrayList;
import java.util.List;

public class ArgumentsParser {

  public List<Argument> parseArguments(String[] args) {
    List<Argument> arguments = new ArrayList<>();
    for (int i = 0; i < args.length; i++) {
      if (!args[i].contains("-")) {
        arguments.add(new Argument(i, "filaname"));
      } else if (args[i].equals("-index")) {
        arguments.add(new Argument(i, "index"));
      }
    }
    return arguments;
  }
}
