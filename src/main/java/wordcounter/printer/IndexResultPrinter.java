package wordcounter.printer;

import wordcounter.model.WordCountDto;

public class IndexResultPrinter implements ResultPrinter {

    @Override
    public void printWordCount(WordCountDto wordCountDto) {
        String result = String.format("Number of words: %d, unique: %d, average word length: %.2f characters\nIndex: %s",
                wordCountDto.getCount(), wordCountDto.getUnique(), wordCountDto.getAverageLength(), String.join("\n", wordCountDto.getCountedWords()));
        System.out.println(result);
    }

}
