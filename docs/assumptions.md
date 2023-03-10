# Assumptions per iteration

## Iteration 1
I assume that input with punctuation is considered not a word, so I exclude the word for counting.
I count same words as different so "Hello", "Hello" count as 2 different words.

## Iteration 2
- I assume that the stopwords.txt file is in the same folder as the executable
- I assume every lines in the stopwords.txt file is a single word

## Iteration 3
- This is an I/O functionality that is best covered by not a unit test but rather an integration test that runs the whole application as black box
- We can create the integration test application in a separate folder called integration-tests
- Creating a separate application is out of the scope of this exercise and will be skipped
