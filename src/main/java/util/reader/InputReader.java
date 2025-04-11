package util.reader;

import java.util.Scanner;

public class InputReader {

    public String readInput() {
        System.out.print("Enter text: ");
        if (System.in == null) {
            return "";
        }

        Scanner myObj = new Scanner(System.in);
        String line = myObj.nextLine();
        if (line == null || line.isBlank()) {
            return "";
        }
        return line;
    }
}
