package wordcounter.validator;

import wordcounter.WordValidator;

public class EuropeanWordValidator implements WordValidator {
    @Override
    public boolean isValidWord(String word) {
        String REGEX = "^[a-zA-Z-]+[.,!?]?$";
        return word.matches(REGEX);
    }
}
