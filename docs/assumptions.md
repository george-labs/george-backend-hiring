# Assumptions per iteration

## Iteration 1
- words which do not match regex would be ignored
- as logging tool I'm using just console (bcs logging tool is missing in pom)
- method provideInput is just for testing (it can be replaced by something nicer: but I would need to add external dependency)

## Iteration 2
- file stopwords.txt is located in resources folder
- if file is missing or cannot be read, error message is logged inside console logger and application is ignoring this
  stopwords functionality
- javadocs are missing due simple implementation, and I'm trying to write self documented code

## Iteration 3

- input file is located in resources folder
- if file doesn't exist, or it cannot be read, application will ask for input

## Iteration 4

- I assume that words with minus sign are 2 "correct" words
- I assume that words with suffix '.' are not correct words
- Humpty Dumpty sat Humpty Dumpty had great -> 7 words (instead of 9)
- unique for this iteration would be 5 (instead of 7)
- some command line argument tool should be used for parsing input arguments (for main method)

## Iteration 5

- same as before
- I assume that words with suffix '.' are not correct words
- Number of words: 7, unique: 6
- is changed to
- Number of words: 5, unique: 4
- words starts with minus sign are ignored
- words ends with minus sign are ignored
- I would ask business guy, what 'containing' means to clarify behavior

## Iteration 6

- decimal precision can be change (instead of '4.333333333333333')
- edge cases needs to be tested / fixed -> I did not finish that part
- 