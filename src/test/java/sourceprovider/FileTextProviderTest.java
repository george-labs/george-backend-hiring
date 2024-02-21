package sourceprovider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileTextProviderTest {

    TextProvider textProvider;

    private void init() {
        textProvider = new FileTextProvider("src\\test\\resources\\sourceprovider\\testmytext.txt");
    }

    @Test
    public void testFile() {
        init();

        String fileText = textProvider.provide();

        Assertions.assertEquals("Some dummy text to be read by provider", fileText);
    }

    @Test
    public void testNoFile() {
        textProvider = new FileTextProvider("");

        Assertions.assertThrows(RuntimeException.class, () -> textProvider.provide());
    }
}
