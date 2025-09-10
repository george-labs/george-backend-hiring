# Assumptions per iteration

## Iteration 1
As an initial assumption, whitespace will be considered the only valid word separator.

## Iteration 2
* It is assumed that if the internal resource file `stopwords.txt` cannot be found, then the application should fail to start.
* The provided stopwords are in lower case, but the filtering should also handle the corresponding mixed and upper case words.