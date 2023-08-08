import operations.StringOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class JavaApplicationTest
{
    @Test
    public void initialTest()
    {
        Assertions.assertTrue(true);
    }

    @Test
    public void countWordsTest()
    {
        Assertions.assertEquals(StringOperations.countWords("a set of words"),4);
        Assertions.assertEquals(StringOperations.countWords("a set of words"," "),4);
    }
}
