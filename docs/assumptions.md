# Assumptions per iteration

## Iteration 1

- Words containing numbers or special characters it counts as 2 words (`te12st` counts as 2 words `te` and `st`).

## Iteration 2

- Words that are split by a stop word `testfootest` where `foo` is a stop word should still count as 1 valid word. 

## Iteration 3

- We assume the input file will be small enough to fit into the memory.

## Iteration 5

- Hyphen is the only valid non-letter character that can still form words. (`.`, `,`, `+`, etc. cannot be in words)
- Hyphen at the start or end of the word will cause the "word" to be not counted. (e.g., `-foo` is not a word)
- Multiple hyphens inside word still count as a valid word. (e.g., `foo--bar` counts as 1 word)
