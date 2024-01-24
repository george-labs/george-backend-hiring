package rules;

public class OnlyLetterRule implements IRule{
    @Override
    public boolean isValid(String word) {
        return word.matches("[a-zA-Z]+");
    }
}
