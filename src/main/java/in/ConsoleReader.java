package in;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {

    public String readLine() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
    }





    String name = reader.readLine();
System.out.println("Your name is: " + name);

}
