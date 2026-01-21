# Assumptions per iteration

## Iteration 1
- We do consider non-english words as input, for example:
  input "word wor2d" results in 3
- Diacricits should split the words in input, for example:
  input "Helálo hello" results in 3
- Blank spaces are trimmed

## Iteration 2
- Stopwords are filtered case insensitive
- If a list of stopwords is not provided or empty, all words are considered

## Iteration 3
- If file is not found we fallback to empty input