package process;

import exception.IterationException;
import read.Reader;

import java.io.IOException;

public interface Counter {

    int count() throws IOException, IterationException;

}
