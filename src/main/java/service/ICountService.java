package service;

import domain.CountResult;

public interface ICountService {
    CountResult countWordsInString(String string);
}
