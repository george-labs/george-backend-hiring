package sk.app.api;

import java.io.IOException;

public interface WordFilter {

	boolean isStopWord(String word);
}
