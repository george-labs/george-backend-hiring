package service;

import java.util.List;

public class FileInput implements UserInput{

    private final String fileName;

    public FileInput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String provideInput() {
        FileReader fileReader = new FileReader();
        return convertListToString(fileReader.readFile("src/main/resources/" + fileName));
    }

    private String convertListToString(List<String> wordsFileLines) {
        StringBuilder text = new StringBuilder();
        for (String wordsFileLine : wordsFileLines) {
            text.append(wordsFileLine);
            text.append(" ");
        }
        return text.toString();
    }
}
