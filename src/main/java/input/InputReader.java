package input;

import java.io.IOException;

public class InputReader {


    private final InputSource inputSource;


    public InputReader(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public String getInput(){
        return inputSource.getInput();
    }

    public void closeInputSource() throws IOException {
        inputSource.close();
    }


}
