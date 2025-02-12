package utils;

public class StringValidator {


    public static boolean matchPattern(String string, RegexPatterns regex) {
        if (string == null) {
            return false;
        }
        return string.matches(regex.getPattern());
    }
}
