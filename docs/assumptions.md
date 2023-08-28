# Assumptions per iteration

## Iteration 2

- I assume that the stop words should be treated as case-insensitive, but the actual stopwords.txt file should only contain lowercase words

## Iteration 4

- I assume that we will have the unique assumption in a case-insensitive way so for input `House HoUse HOUSE house second SECOND` we would count 2 unique
  words
- Because of the example input and output given by the task I assume that from now on I need to support words being separated with
  the following special characters as well: `.` and `-`

## Iteration 6

- I assume that the average word length should be 0 if we have 0 words

## Iteration 7

- Based on the example output I assume the indexed words needs to be in a case-insensitive alphabetical order
- If I find a unique word, then it's first appearance format should be used in the indexed words, for example: "Mary mary" should return Mary as the indexed
  word
- I assume that the -index will be case-sensitive, so -Index or -INDEX will not be accepted

## Iteration 8

- I assume that filenames can not start with '-'
- I assume that the arguments of the application are case-sensitive and they can be in any order
- I assume that if multiple dictionary arguments are used then only the first one should be taken into account