package interview;

import interview.business.WordCounter;
import interview.output.WordCountOutput;
import interview.presenter.WordCountPresenter;
import interview.reader.ConsoleInputReader;
import interview.reader.InputReader;

public class JavaApplication {

    public static void main(String[] args) {

        InputReader inputReader = new ConsoleInputReader(System.in);
        WordCounter wordCounter = new WordCounter(inputReader);
        final WordCountOutput output = wordCounter.processInput();

        WordCountPresenter presenter = new WordCountPresenter();

        presenter.presentWordCount(output);
    }
}
