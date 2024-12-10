package api.core;

import java.util.List;

public interface InputProcessor {

    int processScannedInput(List<String> input, List<String> stopWords);
}
