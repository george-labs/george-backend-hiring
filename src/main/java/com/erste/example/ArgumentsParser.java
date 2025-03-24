package com.erste.example;

import com.erste.example.dto.Argument;
import java.util.ArrayList;
import java.util.List;

/**
 * Parse input arguments
 */
public class ArgumentsParser {

  public static final String ARGUMENT_NAME_FILENAME = "filename";
  public static final String ARGUMENT_NAME_INDEX = "index";
  public static final String ARGUMENT_NAME_DICTIONARY = "dictionary";
  public static final String ARGUMENT_PREFIX_DICTIONARY = "-dictionary=";

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
        arguments.add(new Argument(ARGUMENT_NAME_FILENAME, arg));
      } else if (arg.equals("-index")) {
        arguments.add(new Argument(ARGUMENT_NAME_INDEX, ""));
      } else if (arg.startsWith(ARGUMENT_PREFIX_DICTIONARY)) {
        arguments.add(new Argument(ARGUMENT_NAME_DICTIONARY, arg.replace(ARGUMENT_PREFIX_DICTIONARY, "")));
      }
    }
    return arguments;
  }

}
