package service;

public interface IOService {

    <OutputType> void outputValue(OutputType output);

    String readStringWithPrompt(String prompt);

    String extractStringFromFile(String nameOfFile);
}
