package input;

import file.FileHandler;

import java.util.Arrays;

public class InputReaderFactory {
    public InputReader createInputReader(String[] args) {
        String inputTxtFileName = getInputTxtFileName(args);
        if (inputTxtFileName != null) {
            return new FileInputReader(new FileHandler(), inputTxtFileName);
        }
        return new UserInputReader(System.in);
    }

    protected String getInputTxtFileName(String[] args) {
        if (args == null) {
            return null;
        }
        return Arrays.stream(args)
                .filter(arg -> arg != null && arg.endsWith(".txt"))
                .findFirst()
                .orElse(null);
    }
}
