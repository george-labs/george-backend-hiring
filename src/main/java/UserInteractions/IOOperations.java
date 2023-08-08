package UserInteractions;

import operations.StringOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOOperations
{
    public static String fetchSentence()
    {
        System.out.println("Enter text: ");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Invalid Input");
        }

        return null;
    }
}
