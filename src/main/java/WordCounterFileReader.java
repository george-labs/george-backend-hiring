import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounterFileReader implements WordCounter {

    private final StopWords stopWords;
    private final FileReader fileReader;
    private final String arg;

    public WordCounterFileReader(StopWords stopWords, FileReader fileReader, String arg) {
        this.stopWords = stopWords;
        this.fileReader = fileReader;
        this.arg = arg;
    }

    protected String getSentence() {
        return fileReader.readString(arg);
    }

    @Override
    public int count() {
        String sentence = getSentence();
        if (sentence == null) {
            return 0;
        }

        List<String> words = getWords(sentence);
        return filterStopWords(words).size();
    }

    private List<String> getWords(String sentence) {
        String[] split = sentence.split("\\s+");
        if (split.length < 1) {
            return Collections.emptyList();
        }

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        return Arrays.stream(split).filter(w -> {
            Matcher matcher = pattern.matcher(w);
            return matcher.matches();
        }).collect(Collectors.toList());
    }

    private List<String> filterStopWords(List<String> words) {
        List<String> stopWordsList = stopWords.getStopWords();
        return words.stream().filter(w -> !stopWordsList.contains(w)).collect(Collectors.toList());
    }
}
