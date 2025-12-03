import exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import service.ValidationService;
import service.ValidationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationServiceTest {

    ValidationService validationService = new ValidationServiceImpl();

    @Test
    public void testValidateValidInput() {
        String inputString = "";
        assertThrows(InvalidInputException.class,() -> {
            validationService.validate(inputString);
        });
    }
}
