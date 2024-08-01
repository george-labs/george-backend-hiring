package com.george.interview.input.model;

import java.util.Arrays;

public record InputOptions(String providedFile, boolean isIndexingRequired) {

  private static final String INDEX_INPUT = "-index";

  public static class Builder {

    public InputOptions buildFromCommandLineArgs(String[] commandLineArgs) {

      if (commandLineArgs == null || commandLineArgs.length == 0) {
        return new InputOptions(null, false);
      }
      if (commandLineArgs.length == 1) {
        return extractFromOneArg(commandLineArgs[0]);
      }
      if (commandLineArgs.length == 2) {
        return new InputOptions(extractFileName(commandLineArgs), extractIndex(commandLineArgs));
      }
      return null;
    }

    private boolean extractIndex(String[] commandLineArgs) {

      var indexStringOptional = Arrays.stream(commandLineArgs)
        .filter(INDEX_INPUT::equals)
        .findFirst();

      return indexStringOptional.isPresent();
    }

    private String extractFileName(String[] commandLineArgs) {

      return Arrays.stream(commandLineArgs)
        .filter(arg -> !INDEX_INPUT.equals(arg))
        .findFirst().orElse(null);
    }

    private InputOptions extractFromOneArg(String commandLineArg) {

      if (INDEX_INPUT.equals(commandLineArg)) {
        return new InputOptions(null, true);
      }
      return new InputOptions(commandLineArg, false);
    }
  }
}

