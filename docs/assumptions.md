# Assumptions per iteration

## Iteration 1
- Word is something that is seperated with space
- Word is something that does not have any other character in it than (a-z,A-Z)
- E.G. `word word` = 2, `word. word` = 1, `word word3  word` = 2, `word3word` = 0

## Iteration 2
- `stopwords.txt` contains valid words with only one word in a line (invalid words are words with number or other characters in them, having a space still makes them valid)
- User of wordcount CLI application would pass the path of `stopwords.txt` file as first argument


## Iteration 3
- Both `mytext.txt` and `stopwords.txt` are optional argument to the CLI application
- Usage of CLI looks like
  * `Usage: wordcount [mytext.txt] [stopwords.txt]` here both `mytext.txt` and `stopwords.txt` are optional and should be on this order if present


## Iteration 4
- Words are case insensitive (e.g. Hello & hello are same)
- Words are seperated by (-, ., SPACE)