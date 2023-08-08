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
        Assertions.assertEquals(4,operations.countWords("a set of words").size());
        Assertions.assertEquals(5,operations.countWords("a set of words different    ").size());
    }

    @Test
    public void countWordsWithBlacklistingTest()
    {
        Assertions.assertEquals(4, operationsWithBlacklist.countWords("a set allowed of words").size());
        Assertions.assertEquals(0, operationsWithBlacklist.countWords("not allowed").size());
    }

    @Test
    public void countWordsWithBlacklistingTestUnique()
    {
        Assertions.assertEquals(4,operationsWithBlacklist.uniqueWords(operationsWithBlacklist.countWords("a set allowed of words words")));
    }

    @Test
    public void countWordsWithEmptyInput()
    {
        Assertions.assertEquals(0, operationsWithBlacklist.countWords("").size());
    }

    @Test
    public void countWordsWithBlacklistingTestUniqueHyphen()
    {
        Assertions.assertEquals(5,operationsWithBlacklist.countWords("a set-set allowed of words words").size());
    }

    @Test
    public void countWordsWithBlacklistingTestAvg()
    {
        Assertions.assertEquals(2.75,operationsWithBlacklist.averageCountOfWords(operationsWithBlacklist.countWords("a set allowed of words")));
    }
}
