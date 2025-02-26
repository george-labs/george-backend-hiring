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