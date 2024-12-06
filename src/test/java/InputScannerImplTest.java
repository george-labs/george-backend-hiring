import impl.writers.InputReaderImpl;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputScannerImplTest {

    @Test
    public void testScanInput() {
        InputReaderImpl scanner = new InputReaderImpl(new Scanner("mary had a lamb"));
        List<String> actual = scanner.readInput();

        List<String> expected = List.of("mary had a lamb");

        Assertions.assertEquals(expected, actual);
    }
}