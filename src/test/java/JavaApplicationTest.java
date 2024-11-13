import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class JavaApplicationTest {


    @Test
    void shouldParseFile() {
        Assertions.assertDoesNotThrow(
                () -> JavaApplication.main(new String[]{"build/resources/test/testInput.txt"}));
    }

    @Test
    void shouldReportMissingFile() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> JavaApplication.main(new String[]{"wrong"}));
    }
}
