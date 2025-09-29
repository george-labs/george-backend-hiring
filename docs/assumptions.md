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
