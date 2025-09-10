# Assumptions per iteration

## Iteration 1
As an initial assumption, whitespace will be considered the only valid word separator.

## Iteration 2
* It is assumed that if the internal resource file `stopwords.txt` cannot be found, then the application should fail to start.
* The provided stopwords are in lower case, but the filtering should also handle the corresponding mixed and upper case words.

## Iteration 3
* If the file provided as a command line argument cannot be read for any reason, the application will fail with the corresponding exception.

## Iteration 5
* A word that ends with a hyphen (e.g. `word-`) will be considered an invalid word.
* A word that contains multiple hyphens (e.g. `word-other-word`) will also be considered an invalid word.
* Based on the assumption of iteration 1, a word that contains a punctuation should not be considered a valid word. (e.g. `wall.`)
  * Because of this assumption, the sentence `Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.` would produce the result `Number of words: 5, unique: 4`, instead of the proposed `Number of words: 7, unique: 6` from the specification

## Iteration 6
* The average word-length is calculated based on all the valid words, not just the unique ones.
