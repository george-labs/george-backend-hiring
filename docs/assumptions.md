# Assumptions per iteration

## Iteration 1

- I assume that words are separated either by one or many spaces, end of lines, tabs, commas or dots.

## Iteration 2

- I assume that all words in stopwords.txt file are on their own lines, which means one word per line.
- Empty lines in stopwords.txt file are not considered.
- If no file is provided, or any error happens when reading the stopwords.txt file, then empty list of stop words is provided to the application.


## Iteration 3

- I assume that the text file provided to application exists.


## Iteration 4

- I assume that words are unique unless they match every character including case (uppercase, lowercase). Which means that "Cat" and "cat" are both unique. 