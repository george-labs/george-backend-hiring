import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class JavaApplicationTest {

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testMainMethod(){
        provideInput("Mary Had a little lamb");
        JavaApplication.main(new String[1]);
    }

}
