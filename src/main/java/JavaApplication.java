import gyurix.worldcounter.WorldCounter;

import java.util.Scanner;

public class JavaApplication {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        iteration1();
    }
    public static void iteration1() {
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        WorldCounter worldCounter = new WorldCounter();
        worldCounter.setInput(text);
        worldCounter.doWork();
        System.out.println("Number of words: "+worldCounter.getResult());
    }
}
