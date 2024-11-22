package input;

public class InputReader {


    private final InputSource inputSource;


    public InputReader(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public String getInput(){
        return inputSource.getInput();
    }


}
