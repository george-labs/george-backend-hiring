package service.input.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderServiceProviderTest {

    @Test
    void getProviderForConsoleTest() {
        InputReaderServiceProvider provider = new InputReaderServiceProvider();

        var result = provider.getProvider(null);

        assertInstanceOf(ConsoleReaderServiceImpl.class, result);
    }

    @Test
    void getProviderForFileTest() {
        InputReaderServiceProvider provider = new InputReaderServiceProvider();

        var result = provider.getProvider(new String[] {"mytext.txt"});

        assertInstanceOf(FileReaderServiceImpl.class, result);
    }


    @Test
    void getProviderWillFailTest() {
        InputReaderServiceProvider provider = new InputReaderServiceProvider();

        assertThrows(IllegalStateException.class, () -> provider.getProvider(new String[] {"mytext.txt", "mytext2.txt"}));
    }
}