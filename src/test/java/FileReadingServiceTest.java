import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FileReadingServiceTest {

    IFileReadingService fileReadingService = new FileReadingService();

    @Test
    void test_getStopwordsValidFile(){
        //Given
        String fileLocationForStopwords = "stopwords.txt";
        List<String> expectedStopwords = new ArrayList<>(Arrays.asList("the", "a", "off", "on"));

        //With
        Collections.sort(expectedStopwords);
        List<String> result = fileReadingService.getFileContent(fileLocationForStopwords);
        Collections.sort(result);

        //Then
        Assertions.assertEquals(expectedStopwords, result);
    }

    @Test
    void test_getStopwordsValidFileWithRepetitions(){
        //Given
        String fileLocationForStopwords = "stopwordsRepetition.txt";
        List<String> expectedStopwords = new ArrayList<>(Arrays.asList("the", "a", "off", "on", "the", "a", "off", "on"));

        //With
        Collections.sort(expectedStopwords);
        List<String> result = fileReadingService.getFileContent(fileLocationForStopwords);
        Collections.sort(result);

        //Then
        Assertions.assertEquals(expectedStopwords, result);
    }

    @Test
    void test_getStopwordsEmptyFile(){
        //Given
        String fileLocationForStopwords = "stopwordsEmpty.txt";
        List<String> expectedStopwords = new ArrayList<>();

        //Then
        Assertions.assertEquals(expectedStopwords, fileReadingService.getFileContent(fileLocationForStopwords));
    }

    @Test
    void test_getStopwordsInvalidFile(){
        //Given
        String fileLocationForStopwords = "thisFileDoesNotExist.txt";
        List<String> expectedStopwords = new ArrayList<>();

        //Then
        Assertions.assertEquals(expectedStopwords, fileReadingService.getFileContent(fileLocationForStopwords));
    }
}
