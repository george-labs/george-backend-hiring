import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @Test
    void GIVEN__WHEN__THEN_() {
        JavaApplication javaApplication = new JavaApplication();

        int maryHadALittleLamb = javaApplication.getCountOfWords("Mary wor!");

        assertEquals(0, maryHadALittleLamb);
    }

}
