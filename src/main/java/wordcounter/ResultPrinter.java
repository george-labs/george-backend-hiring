package wordcounter;

import wordcounter.model.WordCountDto;

public class ResultPrinter {

    public void printWordCount(WordCountDto wordCountDto) {
        String result = String.format("Number of words: %d, unique: %d",
                wordCountDto.getCount(), wordCountDto.getUnique());
        System.out.println(result);
    }

}
