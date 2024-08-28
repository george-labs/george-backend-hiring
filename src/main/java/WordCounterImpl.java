import java.util.List;

public class WordCounterImpl implements WordCounter {

    @Override
    public int countWords() {
        String[] splitedSentence = WordUtils.splitWordsBySpace(WordUtils.readSentence());
        List<String> filterWords = WordUtils.filterWords(splitedSentence);
        return WordUtils.countWords(filterWords);
    }

}
