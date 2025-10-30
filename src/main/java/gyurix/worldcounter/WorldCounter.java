package gyurix.worldcounter;

public class WorldCounter {
    private String input;
    private int result;
    private boolean complete;

    public void setInput(String input) {
        this.complete = false;
        if (input == null || !input.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Invalid input, only a-z, A-Z and spaces are allowed");
        }
        this.input = input;
    }

    public void doWork() {
        if (input == null) {
            throw new NullPointerException("Input is null");
        }
        this.result = input.split(" ").length;
        this.complete = true;
    }

    public int getResult() {
        if (!complete) {
            throw new IllegalStateException("Result is not complete");
        }
        return result;
    }
}
