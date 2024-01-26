import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {


    public static void main(String... args) throws IOException {
        var result = new JavaApplication().countWordsFromFileDashAsSpace(args.length != 0 ? args[0] : null);
        System.out.println("number of words: " + result.get(0) + ", unique: " + result.get(1));
    }


    public static int countWord(String input) {

        return new Words().getWords(input).size();
    }

    public long countWordExceptStopWords(String input) {
        var words = new Words();
        var notstopWord = words.getWordsExceptStopWords(words.getWords(input));
        return new WordsCounter().countWordsExceptStopWords(notstopWord);
    }


    public long countWordsFromFile(String path) throws IOException {

        var workCounter = new WordsCounter();
        var pathCheck = new PathCheck();
        if (pathCheck.checkNull(path)) {
            return countWordsFromConsole();
        } else if (pathCheck.pathIsInvalid(path)) {
            System.err.println("File not exist");
            return countWordsFromConsole();
        }
        return countWordFromFile(path);
    }

    public long countWordsFromConsole() {
        System.out.println("enter text: ");
        var input = inputString();
        return countWordExceptStopWords(input);
    }

    private static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public long countWordFromFile(String path) throws IOException {
        var word = new Words();
        return new WordsCounter().countWordsExceptStopWords(word.getWordsExceptStopWords(word.getWords(new InputFileReader().readFromFile(path))));
    }

    public List<Integer> countWordsFromFileDashAsSpace(String path) throws IOException {

        var pathCheck = new PathCheck();
        var words = new Words();
        if (pathCheck.checkNull(path)) {
            return countWordsFromConsoleDashAsSpace();
        } else if (pathCheck.pathIsInvalid(path)) {
            System.err.println("File not exist");
            return countWordsFromConsoleDashAsSpace();
        }
        var wordsInFle = new InputFileReader().readFromFile(path);
        var wordList = words.getWords(words.normalizeTextWithHyphen(wordsInFle));
        return getWordsAndUniqueCount(words, wordList);
    }

    public List<Integer> countWordsFromFileDashAsWord(String path) throws IOException {
        var workCounter = new WordsCounter();
        var pathCheck = new PathCheck();
        var words = new Words();
        if (pathCheck.checkNull(path)) {
            return countWordsFromConsoleDashAsSpace();
        } else if (pathCheck.pathIsInvalid(path)) {
            System.err.println("File not exist");
            return countWordsFromConsoleDashAsSpace();
        }
        var wordsInFle = new InputFileReader().readFromFile(path);
        var wordList = words.getWords(words.normalizeTextWithHyphen(wordsInFle));
        return getWordsAndUniqueCount(words, wordList);
    }

    private List<Integer> countWordsFromConsoleDashAsSpace() {
        var workCounter = new WordsCounter();
        var words = new Words();
        System.out.println("enter text: ");
        var input = inputString();
        var wordList = words.getWordsWithDash(input);
        return getWordsAndUniqueCount(words, wordList);
    }

    @NotNull
    private static List<Integer> getWordsAndUniqueCount(Words words, List<String> wordList) {
        var workCounter = new WordsCounter();
        var stopWordList = words.getWordsExceptStopWords(wordList);
        var stopWordExclusiveWords = workCounter.countWordsExceptStopWords(stopWordList);
        return List.of(stopWordExclusiveWords, workCounter.getUniqueCountExceptStopWords(stopWordList));
    }


    public List<Integer> countWordsFromFileHyphenAsWord(String path) throws IOException {
        var pathCheck = new PathCheck();
        var words = new Words();
        if (pathCheck.checkNull(path)) {
            return countWordsFromConsoleDashAsWord();
        } else if (pathCheck.pathIsInvalid(path)) {
            System.err.println("Invalid path");
            return countWordsFromConsoleDashAsWord();
        }
        var wordsInFle = new InputFileReader().readFromFile(path);
        var wordList = words.getWords(words.normalizeTextWithHyphen(wordsInFle));
        return getWordsAndUniqueCount(words, wordList);


    }

    private List<Integer> countWordsFromConsoleDashAsWord() {
        var words = new Words();
        System.out.println("enter text: ");
        var input = inputString();
        var wordList = words.getWords(input);
        return getWordsAndUniqueCount(words, wordList);
    }
}
