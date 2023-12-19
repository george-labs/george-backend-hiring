import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParamParser {

    private final String INDEX_PARAM_NAME = "-index";

    private List<String> params;

    public ParamParser(String[] params) {
        this.params = params == null ? List.of() : Arrays.asList(params);
    }

    public boolean shouldCreateIndex() {
        return params.contains(INDEX_PARAM_NAME);
    }

    public Optional<String> getFileName() {
        return params.stream()
                .filter(s -> !s.equals(INDEX_PARAM_NAME))
                .findFirst();
    }

}
