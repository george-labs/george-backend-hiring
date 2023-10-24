package factory;

import repository.StopWordsRepository;
import repository.impl.StopWordsFileRepositoryImpl;
import service.Filter;
import service.impl.StopWordsFilterImpl;

public class FilterFactory {

    public static Filter createWith(String filename) {
        StopWordsRepository stopWordsRepository = new StopWordsFileRepositoryImpl(filename);
        return new StopWordsFilterImpl(stopWordsRepository);
    }
}
