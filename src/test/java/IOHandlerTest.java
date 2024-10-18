import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static constant.TestConstant.TEST_MARY_TEXT;

class IOHandlerTest {

//    @BeforeAll
//    public static void setUpStreams() {
//        System.setIn(new ByteArrayInputStream(TEST_MARY_TEXT.getBytes()));
//    }

    @Test
    void getCmdInputTest() {
        IOHandler testHandler = new IOHandler(new ByteArrayInputStream(TEST_MARY_TEXT.getBytes()));

        final var actualResult = testHandler.getCmdInput();
        Assertions.assertEquals(TEST_MARY_TEXT, actualResult);
    }
}