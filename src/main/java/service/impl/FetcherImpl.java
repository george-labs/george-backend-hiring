package service.impl;

import model.Input;
import service.Fetcher;

public class FetcherImpl implements Fetcher {

    @Override
    public Input fetch(String input) {
        return build(input);
    }

    private Input build(String input) {
        //TODO potential improvment to add a mapper
        return new Input(input);
    }


}
