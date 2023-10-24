package service.impl;

import model.Input;
import service.Fetcher;

public class FetcherImpl implements Fetcher {

    @Override
    public Input fetch(String input) {
        return build(input);
    }

    private Input build(String input) {
        return new Input(input);
    }


}
