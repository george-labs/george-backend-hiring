public class TestOutputWriter implements OutputWriter {

    private final StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void writeOutput(String output) {
        stringBuffer.append(output);
    }

    public String getResult() {
        return stringBuffer.toString();
    }
}
