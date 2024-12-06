import impl.writers.InputScannerImpl;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputScannerImplTest {

    @Test
    public void testScanInput() {
        InputScannerImpl scanner = new InputScannerImpl(new Scanner("mary had a lamb"));
        List<String> actual = scanner.scanInput();

        List<String> expected = List.of("mary had a lamb");

        Assertions.assertEquals(expected, actual);
    }
}