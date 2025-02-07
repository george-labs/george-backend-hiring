import static java.lang.String.format;

public class Constants {
    public static final String PATTERN = "^[a-zA-Z]+$";
    public static final String DELIMETER = " ";
    public static final String DEFAULT_PATH = ".\\src\\main\\resources\\%s";
    public static final String STOP_WORDS_PATH = format(DEFAULT_PATH, "stopwords.txt");
    public static final String EMPTY_FILE_PATH = format(DEFAULT_PATH, "empty.txt");
    public static final String MOCK_USER_INPUT = "Mary had a little lamb";

}
