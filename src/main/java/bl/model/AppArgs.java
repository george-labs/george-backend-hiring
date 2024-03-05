package bl.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppArgs {
    private static final String INDEX_ARG = "-index";

    private final boolean showIndex;
    private final String fileName;

    public AppArgs(boolean showIndex, String fileName) {
        this.showIndex = showIndex;
        this.fileName = fileName;
    }

    public static AppArgs parse(String[] args) {
        List<String> argsList = new ArrayList<>(Arrays.asList(args));
        boolean showIndex = argsList.contains(INDEX_ARG);
        argsList.remove(INDEX_ARG);
        if (argsList.size() > 1) {
            throw new IllegalArgumentException("There are unexpected arguments.");
        }
        String fileName = argsList.isEmpty() ? null : argsList.get(0);

        return new AppArgs(showIndex, fileName);
    }

    public boolean isShowIndex() {
        return showIndex;
    }

    public String getFileName() {
        return fileName;
    }
}
