package filter;

import validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class RegexFilter implements Filter{

    private final Validator validator;

    public RegexFilter(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<String> filter(List<String> inputs) {
        return inputs.stream()
                .filter(str -> validator.isValidInput(str))
                .collect(Collectors.toList());

    }
}
