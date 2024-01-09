package service;

public interface IOService {

    <OutputType> void outputValue(OutputType output);

    int readInt();

    int readIntWithPrompt(String prompt);

    String readStringWithPrompt(String prompt);

    String extractStringFromFile(String nameOfFile);
}
