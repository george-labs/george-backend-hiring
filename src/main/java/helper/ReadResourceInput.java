package helper;

import java.util.List;

public class ReadResourceInput {

    public List<String> readInputFromFile() {
        ReadTextFile readTextFile = new ReadTextFile();
        return readTextFile.readResourceTextFile();
    }
}
