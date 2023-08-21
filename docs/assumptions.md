# Assumptions per iteration

## Iteration 1
- Word is something that is seperated with space
- Word is something that does not have any other character in it than (a-z,A-Z)
- E.G. `word word` = 2, `word. word` = 1, `word word3  word` = 2, `word3word` = 0

## Iteration 2
- `stopwords.txt` contains valid words with only one word in a line
- User of wordcount CLI application would pass the path of `stopwords.txt` file as first argument