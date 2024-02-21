package sourceprovider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextProviderStrategyImplTest {

    TextProviderStrategy strategy;

    private void init() {
        strategy = new TextProviderStrategyImpl();
    }

    @Test
    public void fileTextProviderTest() {
        init();

        TextProvider textProvider = strategy.getProvider("src\\test\\resources\\sourceprovider\\testmytext.txt");

        Assertions.assertTrue(textProvider instanceof FileTextProvider);
    }

    @Test
    public void consoleTextProviderTest() {
        init();

        TextProvider textProvider = strategy.getProvider("");

        Assertions.assertTrue(textProvider instanceof ConsoleTextProvider);
    }
}
