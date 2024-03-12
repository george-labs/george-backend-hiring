import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wordcounter.functionalities.InputOutputLogic;
import wordcounter.functionalities.impl.ConsoleIOLogicImpl;

import java.io.ByteArrayInputStream;

import static wordcounter.constants.Constants.NUMBER_OF_WORDS;

public class ConsoleIOLogicImplTest {

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void testCompleteIOLogicForAllValidWords(){
        provideInput("Mary had a little lamb");
        InputOutputLogic ioLogic = new ConsoleIOLogicImpl();
        String outputString = ioLogic.completeIOLogic();
        Assertions.assertEquals(NUMBER_OF_WORDS + 5, outputString);
    }

    @Test
    void testCompleteIOLogicWithOneInvalidWord(){
        provideInput("Mary h3d a little lamb");
        InputOutputLogic ioLogic = new ConsoleIOLogicImpl();
        String outputString = ioLogic.completeIOLogic();
        Assertions.assertEquals(NUMBER_OF_WORDS + 4, outputString);
    }
}
