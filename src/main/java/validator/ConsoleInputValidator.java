package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleInputValidator implements Validator{
    private String regex;

    public ConsoleInputValidator(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile(this.regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
