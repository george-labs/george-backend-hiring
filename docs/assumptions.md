# Assumptions per iteration

## Iteration 1
Assuming a string contains punctuations adjacent to words:
Hello, World!
Iteration 1 is going to assume that these words are not valid:
Output: Count: 0

Code assumption: Providing null value to WordCount Method in WordCount Service is considered Programming error 
and throws exception

## Iteration 2 
For iteration 2 it is assumed that stopwords do not take case sensitivity into consideration 
For instance: Stopwords: the house
Sentence: The house
Output: Size: 1 (The)

It is also assumed that, should no valid file be provided, the program will still run but use no stopwords

## Iteration 4
For this iteration, it is assumed that, if one word occurs twice, it is counted once towards the unique count

## Iteration 5 
Previously, words with hyphen were completely excluded; now they are no longer
It is assumed that Hyphens at the start or end of a word are not excluded. So words like Hello- would be valid now