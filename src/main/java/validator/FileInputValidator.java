package validator;

import java.util.List;

public class FileInputValidator implements Validator{

    private List<String> stopWords;

    public FileInputValidator(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public boolean isValidInput(String input) {
        return List.of().contains(input);
    }
}
