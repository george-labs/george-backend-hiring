package utils;

public enum RegexPatterns {

    ALPHABET_PATTERN("^[a-zA-Z]+$");

    private String value;
    private RegexPatterns(String value) {
        this.value = value;
    }

    public String getPattern() {
        return value;
    }
}
