package utils;

public class InputFileUtils {

    public static String getInputFile() {
        return InputFileUtils.class.getClassLoader().getResource("input.txt").getPath();
    }
}
