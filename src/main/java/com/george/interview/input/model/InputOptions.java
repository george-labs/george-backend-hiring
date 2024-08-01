package com.george.interview.input.model;

public record InputOptions(String providedFile, boolean isIndexingRequired) {

  public static class Builder {

    public InputOptions buildFromCommandLineArgs(String[] commandLineArgs) {

      return null;
    }
  }
}

