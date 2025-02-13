# Assumptions per iteration

## Iteration 1
- If there is some other character than a-z || A-Z the word is not counted f.e. `test.` it's not a word // in the iteration 4 we can see that words also count when there is -
- If there is no input from the user I will return 0 as the result
- Words are split with one or more whitespaces
## Iteration 2 
- I cannot see stopwords.txt so I will create it with the words provided as example in the iteration2
- if there is no stopword file application should throw an error that file is missing
- There are not many changes and the file will not be very big in the future
## Iteration 3
- I will add some information to the user for the output with errors when loading file

## Iteration 4
- When there is word with `-` in between it counts as 2 words
- Also this will change for the `.` with current solution, and I will also do `,`
- THIS, this and ThIs is the same words