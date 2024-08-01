package com.george.interview.input.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputOptionsTest {

  @Test
  void emptyCommandLineArgsAreProvided() {

    var builder = new InputOptions.Builder();
    var options = builder.buildFromCommandLineArgs(new String[] {});

    Assertions.assertFalse(options.isIndexingRequired());
    Assertions.assertNull(options.providedFile());
  }

  @Test
  void onlyIndexCommandLineArgIsProvided() {

    var builder = new InputOptions.Builder();
    var options = builder.buildFromCommandLineArgs(new String[] {"-index"});

    Assertions.assertTrue(options.isIndexingRequired());
    Assertions.assertNull(options.providedFile());
  }

  @Test
  void onlyFileNameCommandLineArgIsProvided() {

    var builder = new InputOptions.Builder();
    var options = builder.buildFromCommandLineArgs(new String[] {"not-an-index"});

    Assertions.assertFalse(options.isIndexingRequired());
    Assertions.assertNotNull(options.providedFile());
  }

  @Test
  void provideBothArgumentsButIndexIsFirst() {

    var builder = new InputOptions.Builder();
    var options = builder.buildFromCommandLineArgs(new String[] {"-index", "not-an-index"});

    Assertions.assertTrue(options.isIndexingRequired());
    Assertions.assertNotNull(options.providedFile());
  }

  @Test
  void provideBothArgumentsButIndexIsSecond() {

    var builder = new InputOptions.Builder();
    var options = builder.buildFromCommandLineArgs(new String[] {"not-an-index", "-index"});

    Assertions.assertTrue(options.isIndexingRequired());
    Assertions.assertNotNull(options.providedFile());
  }
}