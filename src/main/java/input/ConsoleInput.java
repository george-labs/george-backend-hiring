package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {

    private String message;

    public ConsoleInput(String message){
        this.message = message;
    }

    @Override
    public String getString() {
        try{
            System.out.print(this.message);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Could not read input. Something happened");
            throw new RuntimeException(e);
        }
    }
}
