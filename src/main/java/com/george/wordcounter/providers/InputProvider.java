package com.george.wordcounter.providers;

import java.io.IOException;

public interface InputProvider {
  String readFromInput() throws IOException;
}
