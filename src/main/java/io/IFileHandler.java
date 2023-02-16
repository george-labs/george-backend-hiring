package io;

import java.util.Set;

public interface IFileHandler {

    String getInput(String inputFileName);

    Set<String> populateStopWords();
}
