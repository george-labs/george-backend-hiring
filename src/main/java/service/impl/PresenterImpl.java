package service.impl;

import model.Output;
import model.Words;
import service.Presenter;

public class PresenterImpl implements Presenter {

    private static final String TEMPLATE_OUTPUT = "Number of words: %d";

    @Override
    public Output present(Words words) {
        String outputMessage = String.format(TEMPLATE_OUTPUT, words.getCountedWords());
        return new Output(outputMessage);
    }

}
