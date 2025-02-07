import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication {

    public int getCountOfWords(String s) {
        String[] s1 = s.split(" ");
        System.out.println("length: " + s1.length);

        for (String string : s1) {
            System.out.println(doesStringMatchRegex(string));
        }

        return 0;
    }

    public boolean doesStringMatchRegex(String s) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

}
