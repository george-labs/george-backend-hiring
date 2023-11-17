import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MainTest {

    @Test
    public void testWithWrongArgsFileName() throws IOException {


        String text = Main.readFromArgs(new String[]{"mytex.txt"}, 0);


        Assertions.assertEquals("", text);
    }

    @Test
    public void testWithArgsFileName() throws IOException {


        String text = Main.readFromArgs(new String[]{"mytext.txt"}, 0);


        Assertions.assertEquals("Mary had\n" +
                "a little\n" +
                "lamb\n", text);
    }

}
