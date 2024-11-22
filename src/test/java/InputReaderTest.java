import input.ConsoleScanner;
import input.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class InputReaderTest {

    private InputStream inputStream;
    private InputReader inputReader;


    @Test
    void getInput_valid(){
        String originalInput = "Hello World";
        inputStream = new ByteArrayInputStream(originalInput.getBytes());
        inputReader = new InputReader(new ConsoleScanner(new Scanner(inputStream)));
        String resultInput = inputReader.getInput();
        Assertions.assertEquals(originalInput, resultInput);
    }

    @Test
    void getInput_null(){
        inputReader = new InputReader(null);
        Assertions.assertThrows(NullPointerException.class, () -> inputReader.getInput());
    }

}