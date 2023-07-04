import java.io.IOException;

public class Handler {

    InputFileText inputFileText;

    FileReaderText fileReaderText;

    StopWords stopWords;

    public Handler(InputFileText inputFileText, FileReaderText fileReaderText, StopWords stopWords) {
        this.inputFileText = inputFileText;
        this.fileReaderText = fileReaderText;
        this.stopWords = stopWords;
    }


    public void handlingCountingByInput(String [] arguments) throws IOException {
        stopWords.setStopWords(fileReaderText.readingTxtFileConvertingToListOfString("stopwords.txt"));
        if(arguments.length == 0){

        }


    }
}
