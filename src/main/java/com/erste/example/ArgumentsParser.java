package com.erste.example;

import com.erste.example.dto.Argument;
import java.util.ArrayList;
import java.util.List;

/**
 * Parse input arguments
 */
public class ArgumentsParser {

  /**
   * Parse argument and find out the value and position.
   *
   * @param args input arguments
   * @return list of {@link Argument}
   */
  public List<Argument> parseArguments(String[] args) {
    List<Argument> arguments = new ArrayList<>();
    for (String arg : args) {
      if (!arg.contains("-")) {
        arguments.add(new Argument("filename", arg));
      } else if (arg.equals("-index")) {
        arguments.add(new Argument("index", ""));
      }
    }
    return arguments;
  }
}
