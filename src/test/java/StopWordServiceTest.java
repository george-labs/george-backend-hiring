import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StopWordServiceTest {
    StopWordReadingService stopWordReadingService = new StopWordReadingService();

    @Test
    void test_getStopwordsValidFile(){
        //Given
        String fileLocationForStopwords = "stopwords.txt";
        Set<String> expectedStopwords = new HashSet<>(Arrays.asList("the", "a", "off", "on"));

        //Then
        Assertions.assertEquals(expectedStopwords, stopWordReadingService.getStopWords(fileLocationForStopwords));
    }

    @Test
    void test_getStopwordsValidFileWithRepetitions(){
        //Given
        String fileLocationForStopwords = "stopwordsRepetition.txt";
        Set<String> expectedStopwords = new HashSet<>(Arrays.asList("the", "a", "off", "on"));

        //Then
        Assertions.assertEquals(expectedStopwords, stopWordReadingService.getStopWords(fileLocationForStopwords));
    }

    @Test
    void test_getStopwordsEmptyFile(){
        //Given
        String fileLocationForStopwords = "stopwordsEmpty.txt";
        Set<String> expectedStopwords = new HashSet<>();

        //Then
        Assertions.assertEquals(expectedStopwords, stopWordReadingService.getStopWords(fileLocationForStopwords));
    }

    @Test
    void test_getStopwordsInvalidFile(){
        //Given
        String fileLocationForStopwords = "thisFileDoesNotExist.txt";
        Set<String> expectedStopwords = new HashSet<>();

        //Then
        Assertions.assertEquals(expectedStopwords, stopWordReadingService.getStopWords(fileLocationForStopwords));
    }
}
