import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ReadInputUtilTest {

    private final ReadInputUtil readInputUtil = new ReadInputUtil();

    @Test
    void readInputFileFromArgs(){
        String[] args = new String[]{"src/test/resources/mytext.txt"};
        String expectedResult = "Mary had a little pony ";

        String result = readInputUtil.readInputLine(args, new FileReader());

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void readInputFileFromConsole(){
        String[] args = new String[]{""};
        String expectedResult = "Mary had a little pony ";
        provideInput("Mary had a little pony ");

        String result = readInputUtil.readInputLine(args, new FileReader());

        Assertions.assertEquals(expectedResult, result);
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
