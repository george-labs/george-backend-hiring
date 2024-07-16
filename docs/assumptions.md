# Assumptions per iteration

## Iteration 1

I assume any character different from a-z and A-Z is a word sepearator.
i.e. "sdf2asdf" will result in 2.

## Iteration 2

I assume the file stopwords.txt is located in the current working directory.
I will not care about the exception if the file is not found I pass it over to the caller.

## Iteration 3

without an command line argument it works as before.

## Iteration 6

I assume the average of unique words is wanted.

## Iteration 7

Simplification only the last filename counts if more than one other arg than -index is passed by.
I assume all counted words just means the unique words, so no duplicates are printed.
