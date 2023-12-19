import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParamParserImpl implements ParamParser {

    private final String INDEX_PARAM_NAME = "-index";
    private final String DICTIONARY_PARAM_NAME = "-dictionary";

    private List<String> params;

    public ParamParserImpl(String[] params) {
        this.params = params == null ? List.of() : Arrays.asList(params);
    }

    @Override
    public boolean shouldCreateIndex() {
        return params.contains(INDEX_PARAM_NAME);
    }

    @Override
    public Optional<String> getFileName() {
        return params.stream()
                .filter(s -> !s.equals(INDEX_PARAM_NAME))
                .findFirst();
    }

    @Override
    public Optional<String> getDictionaryFileName() {
        return params.stream()
                .filter(s -> s.startsWith(DICTIONARY_PARAM_NAME))
                .findFirst()
                .map(s -> s.substring(DICTIONARY_PARAM_NAME.length() + 1));
    }

}
