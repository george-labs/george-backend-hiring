package com.george.interview.input.model;

public record InputOptions(String providedFile, boolean isIndexingRequired) {

  public static class Builder {

    public InputOptions buildFromCommandLineArgs(String[] commandLineArgs) {

      if (commandLineArgs == null || commandLineArgs.length == 0) {
        return new InputOptions(null, false);
      }
      if (commandLineArgs.length == 1) {
        return extractFromOneArg(commandLineArgs[0]);
      }
      return null;
    }

    private InputOptions extractFromOneArg(String commandLineArg) {

      if ("-index".equals(commandLineArg)) {
        return new InputOptions(null, true);
      }
      return new InputOptions(commandLineArg, false);
    }
  }
}

