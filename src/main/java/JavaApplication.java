import gyurix.worldcounter.WorldCounter;

import java.io.IOException;
import java.util.Scanner;

public class JavaApplication {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        run();
    }
    public static void run() throws IOException {
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        WorldCounter worldCounter = new WorldCounter("stopwords.txt");
        worldCounter.setInput(text);
        worldCounter.doWork();
        System.out.println("Number of words: "+worldCounter.getResult());
    }
}
