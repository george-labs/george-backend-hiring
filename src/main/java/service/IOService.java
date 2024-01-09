package service;

public interface IOService {

    public <OutputType> void outputValue(OutputType output);

    int readInt();

    int readIntWithPrompt(String prompt);

    String readStringWithPrompt(String prompt);
}
