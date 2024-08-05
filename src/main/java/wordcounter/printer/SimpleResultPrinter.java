package wordcounter.printer;

import wordcounter.model.WordCountDto;

public class SimpleResultPrinter implements ResultPrinter {

    @Override
    public void printWordCount(WordCountDto wordCountDto) {
        String result = String.format("Number of words: %d, unique: %d, average word length: %.2f characters",
                wordCountDto.getCount(), wordCountDto.getUnique(), wordCountDto.getAverageLength());
        System.out.println(result);
    }

}
