import input.OneLineScanner;
import input.InputReader;

import java.util.Scanner;

public class JavaApplication {


    public static void main(String[] args) {

        WordCounterApp app = new WordCounterApp(new InputReader(new OneLineScanner(new Scanner(System.in))), "stopwords.txt");
        String result = app.run();
        System.out.println(result);
        app.shutDown();


    }
}
