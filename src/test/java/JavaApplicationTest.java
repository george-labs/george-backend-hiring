import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    @Test
    @DisplayName("Testing the Whole App Flow")
    public void main(){
        String[] args = new String[0];
        System.setOut(new PrintStream(outputStreamCaptor));
        provideInput("Mary had a little lamb");
        JavaApplication.main(args);
        assertEquals("Enter text: Number of words: 5", outputStreamCaptor.toString()
                .trim());
    }
}


