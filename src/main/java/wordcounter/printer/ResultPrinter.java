package wordcounter.printer;

import wordcounter.model.WordCountDto;

public interface ResultPrinter {

    void printWordCount(WordCountDto wordCountDto);

}
