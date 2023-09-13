package sk.app.application.domain;

import java.util.List;

import sk.app.application.port.incoming.WordCalculation;

public class WordCalculationService implements WordCalculation {

	private final WordCounterBase wordCounterBase;

	public WordCalculationService(WordCounterBase wordCounterBase) {
		this.wordCounterBase = wordCounterBase;
	}


	@Override
	public double calculateAverageWordLength(String text) {
		List<String> allWords = this.wordCounterBase.findAllWords(text);
		return calculateAverage(allWords);
	}

	private double calculateAverage(List<String> allWords) {
		if (allWords == null || allWords.isEmpty()) {
			return 0;
		}
		long sum = 0;
		for (String word : allWords) {
			sum += word.length();
		}
		return (double) sum / allWords.size();
	}
}
