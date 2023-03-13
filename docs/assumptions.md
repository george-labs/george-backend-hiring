# Assumptions per iteration

## Iteration 1
I assume that input with punctuation is considered not a word, so I exclude the word for counting.
I count same words as different so "Hello", "Hello" count as 2 different words.

## Iteration 2
- I assume that the stopwords.txt file is in the same folder as the executable
- I assume every lines in the stopwords.txt file is a single word

## Iteration 3
I assume that the text in input can be splitted in multiple lines and the output is counted as one line.
