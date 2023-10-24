package service;

import model.Input;
import model.Words;

public interface Parser {

    Words parse(Input input);
}
