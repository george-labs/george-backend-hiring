package com.example.components;

import com.example.utils.FileHelper;

import java.util.List;

public class FileTextProvider implements ITextProvider{
    private final String textFileName;

    public FileTextProvider(String textFileName) {
        this.textFileName = textFileName;
    }

    @Override
    public String getInputText() {
        List<String> textFileContent = FileHelper.getFileLines(textFileName);
        return textFileContent != null
                ? String.join(" ", textFileContent)
                : null;
    }
}
