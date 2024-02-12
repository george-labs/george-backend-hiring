package processor;

import validator.Validator;

import java.util.List;

public class ItemProcessor implements Processor{


    // TODO: passing some Function<I, O> to this method to be more generic
    @Override
    public long process(List<String> input) {
        return input.stream()
                .count();


    }
}
