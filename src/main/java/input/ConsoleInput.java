package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {

    private String message;
    private InputStream inputStream;

    public ConsoleInput(String message){
        this.message = message;
        this.inputStream = System.in;
    }

    public ConsoleInput(String message, InputStream inputStream){
        this.message = message;
        this.inputStream = inputStream;
    }

    @Override
    public String getString() {
        try{
            System.out.print(this.message);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(this.inputStream));
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Could not read input. Something happened");
            throw new RuntimeException(e);
        }
    }
}
