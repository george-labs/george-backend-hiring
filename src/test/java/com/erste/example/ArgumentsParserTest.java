package com.erste.example;

import static com.erste.example.ArgumentsParser.ARGUMENT_NAME_DICTIONARY;
import static com.erste.example.ArgumentsParser.ARGUMENT_NAME_FILENAME;
import static com.erste.example.ArgumentsParser.ARGUMENT_NAME_INDEX;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.erste.example.dto.Argument;
import java.util.List;
import org.junit.jupiter.api.Test;

class ArgumentsParserTest {

  @Test
  void shouldCheckAllParsedArguments() {
    ArgumentsParser argumentsParser = new ArgumentsParser();
    String[] args = new String[] {"filename.txt", "-index", "-parse", "-dictionary=dict.txt"};
    List<Argument> arguments = argumentsParser.parseArguments(args);

    assertEquals(3, arguments.size());
    Argument filenameArgument = getArgument(arguments, ARGUMENT_NAME_FILENAME);
    assertEquals("filename.txt", filenameArgument.getValue());
    Argument indexArgument = getArgument(arguments, ARGUMENT_NAME_INDEX);
    assertEquals("", indexArgument.getValue());
    Argument dictionaryArgument = getArgument(arguments, ARGUMENT_NAME_DICTIONARY);
    assertEquals("dict.txt", dictionaryArgument.getValue());
  }

  private Argument getArgument(List<Argument> arguments, String filename) {
    return arguments.stream()
                    .filter(arg -> arg.getName().equals(filename))
                    .findFirst()
                    .orElseThrow();
  }

}