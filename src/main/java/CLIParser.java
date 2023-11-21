import java.util.LinkedList;
import java.util.List;

public class CLIParser {
    static class CLIParserResult {
        private List<String> arguments;
        private List<String> activeOptions;

        private CLIParserResult(List<String> arguments, List<String> activeOptions) {
            this.arguments = arguments;
            this.activeOptions = activeOptions;
        }

        public List<String> getArguments() {
            return arguments;
        }

        public boolean isOptionActive(String option) {
            return this.activeOptions.contains(option.toLowerCase());
        }
    }

    private CLIParser() { }

    public static CLIParserResult parse(String[] args) {
        List<String> arguments = new LinkedList<>();
        List<String> activeOptions = new LinkedList<>();

        for (String arg : args) {
            if (arg.startsWith("-")) {
                if (arg.length() > 1) {
                    activeOptions.add(arg.substring(1).toLowerCase());
                }
            } else {
                arguments.add(arg);
            }
        }

        return new CLIParserResult(arguments, activeOptions);
    }
}
