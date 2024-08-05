package wordcounter;

import java.io.ByteArrayInputStream;

public class InputUtils {

    public static void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

}
