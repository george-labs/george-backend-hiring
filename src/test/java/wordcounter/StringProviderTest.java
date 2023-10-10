package wordcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordcounter.reader.ConsoleLineReader;

class StringProviderTest {
    StringProvider stringProvider;
    @BeforeEach
    void setup() {
        stringProvider = new StringProvider();
    }

    @Test
    void getStringFromInput() {
        ConsoleLineReader reader = new ConsoleLineReader();
        String result = stringProvider.getStringFromInput(reader, "input.txt");
        Assertions.assertEquals("space ghost ca1t mouse on", result);
    }
}