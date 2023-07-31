import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {


    @Test
    public void testAdd() {
        JavaApplication app = new JavaApplication();
        int result = app.add(2, 3);
        assertEquals(5, result);
    }
}
