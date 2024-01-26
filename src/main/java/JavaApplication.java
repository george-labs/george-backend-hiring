import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class JavaApplication {


    public static void main(String... args) throws IOException {
        var result = new JavaApplication().countWordsFromFileHyphenAsWord(args.length != 0 ? args[0] : null);
        System.out.println("Number of words: " + result.get(0) + ", unique: " + result.get(1));
    }

    public static int countWord(String input) {
        return new Words().getWords(input).size();
    }

    public long countWordExceptStopWords(String input) throws IOException {
        var words = new Words();
        InputFileReader inputFileReader = new InputFileReader();
        var stopWords = inputFileReader.getWordsExceptStopWords();
        var notStopWord = words.getWordsExceptStopWords(words.getWords(input), stopWords);
        return new WordsCounter().countWordsExceptStopWords(notStopWord);
    }


    public long countWordsFromFile(String path) throws IOException {

        var pathCheck = new PathCheck();
        if (pathCheck.checkNull(path)) {
            return countWordsFromConsole();
        } else if (pathCheck.pathIsInvalid(path)) {
            System.err.println("File not exist");
            return countWordsFromConsole();
        }
        return countWordFromFile(path);
    }

    public long countWordsFromConsole() throws IOException {
        System.out.println("enter text: ");
        var input = new InputText().getInput();
        return countWordExceptStopWords(input);
    }


    public long countWordFromFile(String path) throws IOException {
        var word = new Words();
        InputFileReader inputFileReader = new InputFileReader();
        var stopWords = inputFileReader.getWordsExceptStopWords();
        return new WordsCounter().countWordsExceptStopWords(word.getWordsExceptStopWords(word.getWords(new InputFileReader().readFromFile(path)), stopWords));
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
        var wordList = words.getWords(words.normalizeTextWithHyphenAsSeparator(wordsInFle));
        return getWordsAndUniqueCount(words, wordList);
    }

    private List<Integer> countWordsFromConsoleDashAsSpace() throws IOException {
        var words = new Words();
        System.out.println("enter text: ");
        var input = new InputText().getInput();
        var wordList = words.getWordsWithDash(input);
        return getWordsAndUniqueCount(words, wordList);
    }

    @NotNull
    private static List<Integer> getWordsAndUniqueCount(Words words, List<String> wordList) throws IOException {
        var workCounter = new WordsCounter();
        InputFileReader inputFileReader = new InputFileReader();
        var stopWords = inputFileReader.getWordsExceptStopWords();
        var stopWordList = words.getWordsExceptStopWords(wordList, stopWords);
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
        var wordList = words.getWords(words.normalizeTextWithHyphenAsWord(wordsInFle));
        return getWordsAndUniqueCount(words, wordList);


    }

    private List<Integer> countWordsFromConsoleDashAsWord() throws IOException {
        var words = new Words();
        System.out.print("Enter text: ");
        var input = new InputText().getInput();
        var wordList = words.getWords(words.normalizeTextWithHyphenAsWord(input));
        return getWordsAndUniqueCount(words, wordList);
    }
}
