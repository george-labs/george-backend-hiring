package com.george.interview.input.model;

import java.util.Arrays;

public record InputOptions(String providedFile, boolean isIndexingRequired) {

  private static final String INDEX_INPUT = "-index";

  public static class Builder {

    public InputOptions buildFromCommandLineArgs(String[] commandLineArgs) {

      if (commandLineArgs == null || commandLineArgs.length == 0) {
        return new InputOptions(null, false);
      }
      return new InputOptions(extractFileName(commandLineArgs), extractIndex(commandLineArgs));
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
  }
}

