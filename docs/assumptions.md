# Assumptions per iteration

## Iteration 1

Any word containing numbers or non-alphabetical characters is not counted, i.e.:
- `l1ttle` is not counted
- `Mary, had` is one word, because punctuation is not allowed at this point
- `Mary had a lamb.` is 3 words, because of the same reason

## Iteration 2

Stopword file will be bundled within the app in resources
If `stopwords.txt` file is not found, we'll print a warning and use empty set of stopwords
Stopwords are going to be considered case-insensitive so `The lamp` and `the lamp` will both count 1 word if `the` is contained in stopwords
There will be small amount of stopwords overall, so keeping them in Set/List in-memory and matching via `word !in stopwords` will not have significant impact on performance

## Iteration 3

If file is not provided, or if there are some problems accessing it (i.e. permissions) the app will throw an exception
If number of arguments does not conform with the expected state (0 or 1) the app will show an error

## Iteration 4

The requirement to not count words with punctuation characters at the end is now invalid. `Mary had two lambs.` is now 4 words. `Mary, had` is now 2 words.
Hyphenation character is now considered a separator. `Humpty-Dumpty` is 2 words even though it has no whitespace in between
Unique words would be considered case-insensitive. so `Humpty humpty` is 1 unique word
Hyphens are considered separators, so they behave as if they were whitespaces. `Humpty--Dumpty` is 2 words 
Hyphens at the beginning and end of a word are still not invalidating the word itself. `--Dumpty-` is 1 word 
