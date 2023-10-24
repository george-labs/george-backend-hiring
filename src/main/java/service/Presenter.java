package service;

import model.Output;
import model.Words;

public interface Presenter {
    Output present(Words words);
}
