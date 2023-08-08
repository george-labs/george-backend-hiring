import operations.AlphabeticOperations;
import operations.StringOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class JavaApplicationTest
{
    private AlphabeticOperations operations;
    private AlphabeticOperations operationsWithBlacklist;

    public JavaApplicationTest()
    {
        operations = new StringOperations();
        operationsWithBlacklist = new StringOperations("not,allowed");
    }

    @Test
    public void initialTest()
    {
        Assertions.assertTrue(true);
    }

    @Test
    public void countWordsTest()
    {
        Assertions.assertEquals(4,operations.countWords("a set of words"));
        Assertions.assertEquals(4,operations.countWords("a set of words"," "));
    }

    @Test
    public void countWordsWithBlacklistingTest()
    {
        Assertions.assertEquals(4, operationsWithBlacklist.countWords("a set allowed of words"));
        Assertions.assertEquals(0, operationsWithBlacklist.countWords("not allowed"," "));
    }

    @Test
    public void countWordsWithEmptyInput()
    {
        Assertions.assertEquals(0, operationsWithBlacklist.countWords(""));
    }
}
