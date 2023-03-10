# Assumptions per iteration

## Iteration 1
I assume that input with punctuation is considered not a word, so I exclude the word for counting.
I count same words as different so "Hello", "Hello" count as 2 different words.

## Iteration 2
- The stopwords.txt file is in the current working directory

## Iteration 3
- This is an I/O functionality that is best covered by not a unit test but rather an integration test that runs the whole application as black box
- We can create the integration test application in a separate folder called integration-tests
- Creating a separate application is out of the scope of this exercise and will be skipped

## Iteration 4
- Change the original definition of word to be counted: A word is any non-empty sequence of letters (a-z or A-Z), any non-letter characters are just separator and never counted, words containing hyphen are counted as multiple words

## Iteration 5
- Doubled or tripled etc. hyphens cannot be used to join parts of one word
- Hyphens at the start or end of a word are not part of the word, so e.g. beautiful and beautiful- are the same word

## Iteration 6
- Average length is computed from all words, so multiple occurrences of a word do have impact on the average
- The average is displayed rounded to 2 decimal places
- If there are 0 words, we print N/A instead of the average