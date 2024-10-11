# Assumptions per iteration

## Iteration 1
- words are stretches of letters (a-z,A-Z)
- stretch of ONLY letters is a word
- something that has for example a number in it is not a word
- there is no specification about how the whole string should be split
- that means if "Hello, World!" is same as a "Hello World"
- so let's assume there will be no special characters in the text
- and we split just by spaces
- so "Hello, World!" will have 0 words while "Hello World" will have 2 words

## Iteration 2
- file name is specified as "stopwords.txt"
- that means it will be hardcoded in main function
- there is no specification about the size of the file
- so let's assume it will be small enough to fit in memory
- there is no specification about the encoding of the file
- so let's assume it will be ASCII encoded
- let's assume that the file will be in directory where the application is run
- if file is found than assume that it is valid

## Iteration 3
- the file is assumed to be placed in the same directory as where the application is running or by full path