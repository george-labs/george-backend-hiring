import input.OneLineScanner;
import input.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class InputReaderTest {

    private InputReader inputReader;


    @Test
    void getInput_valid(){
        String originalInput = "Hello World";
        InputStream inputStream = new ByteArrayInputStream(originalInput.getBytes());
        inputReader = new InputReader(new OneLineScanner(new Scanner(inputStream)));
        String resultInput = inputReader.getInput();
        Assertions.assertEquals(originalInput, resultInput);
    }

    @Test
    void getInput_null(){
        inputReader = new InputReader(null);
        Assertions.assertThrows(NullPointerException.class, () -> inputReader.getInput());
    }

}