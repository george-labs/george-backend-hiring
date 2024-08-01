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

  @Test
  void provideTwoArgumentsThatAreBothIndex() {

    var builder = new InputOptions.Builder();
    var options = builder.buildFromCommandLineArgs(new String[] {"-index", "-index"});

    Assertions.assertTrue(options.isIndexingRequired());
    Assertions.assertNull(options.providedFile());
  }

  @Test
  void provideTwoArgumentsThatAreBothFileNames() {

    var builder = new InputOptions.Builder();
    var options = builder.buildFromCommandLineArgs(new String[] {"test-file-name", "test-file-name-two"});

    Assertions.assertNotNull(options.providedFile());
    Assertions.assertFalse(options.isIndexingRequired());
    Assertions.assertEquals("test-file-name", options.providedFile());
  }

  @Test
  void provideMoreThan2Arguments() {

    var builder = new InputOptions.Builder();
    var options = builder.buildFromCommandLineArgs(new String[] {"test-file-name", "test-file-name-two", "-input", "-input"});

    Assertions.assertNotNull(options.providedFile());
    Assertions.assertTrue(options.isIndexingRequired());
    Assertions.assertEquals("test-file-name", options.providedFile());
  }
}