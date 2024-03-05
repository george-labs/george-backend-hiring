package bl.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputProviderFactoryTest {

    @Test
    public void getStdInputProvider() {
        InputProvider provider = InputProviderFactory.getProvider(null);
        assertInstanceOf(StdInputProvider.class, provider);
    }

    @Test
    public void getFileInputProvider() {
        InputProvider provider = InputProviderFactory.getProvider("file.txt");
        assertInstanceOf(FileInputProvider.class, provider);
    }
}