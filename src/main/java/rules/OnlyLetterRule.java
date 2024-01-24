package rules;

public class OnlyLetterRule implements IRule{
    @Override
    public boolean process(String word) {
        return word.matches("[a-zA-Z]+");
    }
}
