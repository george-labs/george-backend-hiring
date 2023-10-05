package io;

import java.io.IOException;

public interface IO {

    String read() throws IOException;
    void print(String text);
    void println(String text);
}
