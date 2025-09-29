import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FilterServiceTest {
    private IFilterService filterService = new FilterService();

    @Test
    void test_filterInputString_normalString(){
        //Given
        List<String> input = List.of("Hello", "World");
        int expectedCount = 2;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_allLowerCaseString(){
        //Given
        List<String> input = List.of("hello", "world");
        int expectedCount = 2;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_allUpperCaseString(){
        //Given
        List<String> input = List.of("HELLO", "WORLD");
        int expectedCount = 2;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_umlautString(){
        //Given
        List<String> input = List.of("Hellö", "Wörld", "saß");
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_partiallyValidString(){
        //Given
        List<String> input = List.of("Hello", "World!");
        int expectedCount = 1;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_punctuationValidString(){
        //Given
        List<String> input = List.of("Hello,", "World!");
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_noValidString(){
        //Given
        List<String> input = List.of("H3llo", "World!");

        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_emptyValidString(){
        //Given
        List<String> input = List.of("");
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_spaceValidString(){
        //Given
        List<String> input = List.of("                   ");
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_emptyList(){
        //Given
        List<String> input = new ArrayList<>();
        int expectedCount = 0;

        //Then
        Assertions.assertEquals(expectedCount, filterService.filterInputString(input));
    }

    @Test
    void test_filterInputString_nullList(){
        //Given
        List<String> input = null;

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> filterService.filterInputString(input));
    }
}
