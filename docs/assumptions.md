# Assumptions per iteration

## Iteration 1
As an initial assumption, whitespace will be considered the only valid word separator.

## Iteration 2
* It is assumed that if the internal resource file `stopwords.txt` cannot be found, then the application should fail to start.
* The provided stopwords are in lower case, but the filtering should also handle the corresponding mixed and upper case words.

## Iteration 3
* If the file provided as a command line argument cannot be read for any reason, the application will fail with the corresponding exception.