package com.erste.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.erste.example.dto.Argument;
import java.util.List;
import org.junit.jupiter.api.Test;

class ArgumentsParserTest {

  @Test
  void shouldCheckAllParsedArguments() {
    ArgumentsParser argumentsParser = new ArgumentsParser();
    String[] args = new String[] {"filename.txt", "-index", "-parse"};
    List<Argument> arguments = argumentsParser.parseArguments(args);

    assertEquals(2, arguments.size());
    Argument filenameArgument = getArgument(arguments, "filename");
    assertEquals("filename.txt", filenameArgument.getValue());
    Argument indexArgument = getArgument(arguments, "index");
    assertEquals("", indexArgument.getValue());
  }

  private Argument getArgument(List<Argument> arguments, String filename) {
    return arguments.stream()
                    .filter(arg -> arg.getName().equals(filename))
                    .findFirst()
                    .orElseThrow();
  }

}