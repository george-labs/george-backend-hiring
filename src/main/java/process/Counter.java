package process;

import exception.IterationException;
import model.WordCountModel;

import java.io.IOException;

public interface Counter {

    WordCountModel count() throws IOException, IterationException;

}
