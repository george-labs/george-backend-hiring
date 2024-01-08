# Assumptions per iteration

## Iteration 1
Based on "Words are stretches of letters (a-z,A-Z)", I assume that words containing numbers are actually not words.

examples: 

"Mary Had 5 lambs"  -> 5 is not a word

"M4ry had" -> M4ry is not a word.


## Iteration 2 

I assume the file stopwords.txt is something already defined in the application, not passed from outside. 


## Iteration 4
1. I assume that I can ask for the total word count and the unique number of words separatelly. 
2. I assume that "Humpty-Dumpty" counts as 2 words.
4. I assume "wall." is also a word ("wall").
