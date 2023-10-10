import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EuropeanWordValidatorTest {
    WordValidator validator;

    @BeforeEach
    void setup(){
        validator = new EuropeanWordValidator();
    }
    @Test
    void isValidWord() {
        Assertions.assertEquals(true, validator.isValidWord("abc"));
        Assertions.assertNotEquals(true, validator.isValidWord("a123bc"));
        Assertions.assertNotEquals(true, validator.isValidWord(""));
    }
}