# Assumptions per iteration

## Iteration 1
- The user will input one line of text at a time.
- When a phrase contains invalid words, those words will be ignored and not counted.
## Iteration 2
- If the stopwords file does not exist, all valid words in the phrases will be counted.
- The stopwords file should be in the resource folder.
- An assumption is made that the letter case of stopwords is irrelevant. This means that if the stopfile contains the word 'the', then none of the following words will be counted: 'the', 'The', and 'THE'.
