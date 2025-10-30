import gyurix.worldcounter.WorldCounter;

import java.io.IOException;
import java.util.Scanner;

public class JavaApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        WorldCounter worldCounter = new WorldCounter("stopwords.txt");
        setInput(args, worldCounter);
        worldCounter.doWork();
        System.out.println("Number of words: " + worldCounter.getResult());
    }

    private static void setInput(String[] args, WorldCounter worldCounter) throws IOException {
        if (args.length == 0) {
            System.out.print("Enter text: ");
            String text = scanner.nextLine();
            worldCounter.setInput(text);
        } else {
            worldCounter.setFileInput(args[0]);
        }
    }
}
